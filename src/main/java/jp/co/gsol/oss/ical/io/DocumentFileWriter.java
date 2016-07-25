package jp.co.gsol.oss.ical.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import jp.co.gsol.oss.ical.data.CalendarConverter;
import jp.co.gsol.oss.ical.exception.DirectoryTraversalException;
import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.gsol.oss.ical.exception.NoFileNameException;
import jp.co.gsol.oss.ical.exception.NoSuchDirectoryException;
import jp.co.gsol.oss.ical.settings.ICalSetting;

/**
 * Document directoryにファイルを書き込むクラスです.
 * @author Global Solutions Co., Ltd.
 */

public class DocumentFileWriter {

    /** 書き込み先directory.*/
    private final Path _dir;
    /** temporary file prefix.*/
    private final String _tempFilePrefix;
    /** temporary file's extension.*/
    private final String _tempFileSuffix;
    /** 書き込みに使う文字コード.*/
    private final Charset _charset;

    /**
     * ICalSettingの設定を使って、dirディレクトリに書き込むオブジェクトを作成します.
     * @param dir document directoryへのパス文字列
     * @throws NoSuchDirectoryException 指定のパスがディレクトリへの絶対パスではないとき
     */
    public DocumentFileWriter(final String dir)
            throws NoSuchDirectoryException {
        this(dir,
            ICalSetting.tempFilePrefix(), ICalSetting.tempFileSuffix(),
            Charset.forName(ICalSetting.charset()));
    }

    /**
     * dirディレクトリに書き込むオブジェクトを作成します.
     * @param dir 書き込み先directory
     * @param tempFilePrefix temporary file prefix
     * @param tempFileSuffix temporary file の拡張子
     * @param charset 書き込みに使う文字コード
     * @throws NoSuchDirectoryException 指定のパスがディレクトリへの絶対パスではないとき
     */
    public DocumentFileWriter(final String dir,
            final String tempFilePrefix, final String tempFileSuffix,
            final Charset charset) throws NoSuchDirectoryException {
        _dir = Paths.get(dir);
        if (!_dir.isAbsolute() || !Files.isDirectory(_dir))
            throw new NoSuchDirectoryException(
                    "Argument dir needs abusolute path to document directory"
                    + " dir: " + dir
                    );
        _tempFilePrefix = tempFilePrefix;
        _tempFileSuffix = tempFileSuffix;
        _charset = charset;
    }
    /**
     * ConvertCalendarLogicを使ってファイルに書き込みます.
     * @param filename ics ファイル名
     * @param iCal iCal変換クラス
     * @throws IOException {@link java.nio.file.Files}
     * または、 {@link CalendarConverter#write(java.io.Writer)}
     * @throws ICalException {@link CalendarConverter#write(java.io.Writer)}
     * @throws DirectoryTraversalException {@link #validTraverse(Path)}
     */
    public final void write(final String filename, final CalendarConverter iCal)
            throws IOException, ICalException, DirectoryTraversalException {
        final Path file = _dir.resolve(filename);
        validTraverse(file);

        final Path tempFile = Files.createTempFile(_dir,
                _tempFilePrefix, _tempFileSuffix);
        try (BufferedWriter bw = Files.newBufferedWriter(tempFile,
                _charset, StandardOpenOption.CREATE)) {
            iCal.write(bw);
        } catch (Exception e) {
            Files.deleteIfExists(tempFile);
            throw e;
        }
        Files.move(tempFile, file, StandardCopyOption.REPLACE_EXISTING);
    }
    /**
     * ディレクトリトラバーサルしないか確認します.
     * @param path 確認するPath(絶対パスで指定)
     * @throws DirectoryTraversalException Pathの絶対パスと正規化パスが一致しないとき
     */
    public static void validTraverse(final Path path)
            throws DirectoryTraversalException {
        if (!path.toAbsolutePath().equals(path.normalize()))
            throw new DirectoryTraversalException(
                    "It is not allowed to access parent directry!"
                    + " Absolute path:" + path.toAbsolutePath()
                    + " Canonical path:" + path.normalize());
    }
    /**
     * ファイルを削除します.
     * @param filename 削除するファイル名
     * @throws IOException {@link java.nio.file.Files#deleteIfExists(Path)}
     * @throws NoFileNameException ファイル名がnullのとき
     * @throws DirectoryTraversalException {@link #validTraverse(Path)}
     */
    public final void delete(final String filename)
            throws IOException, NoFileNameException, DirectoryTraversalException {
        if (filename == null)
            throw new NoFileNameException("filename is required.");

        final Path file = _dir.resolve(filename);
        validTraverse(file);
        Files.deleteIfExists(file);
    }
}
