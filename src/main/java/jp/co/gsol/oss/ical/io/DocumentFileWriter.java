package jp.co.gsol.oss.ical.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jp.co.gsol.oss.ical.config.general.GsolIcalConfigCont;
import jp.co.gsol.oss.ical.data.CalendarConverter;
import jp.co.gsol.oss.ical.exception.DirectoryTraversalException;
import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.gsol.oss.ical.exception.NoFileNameException;
import jp.co.gsol.oss.ical.exception.NoSuchDirectoryException;

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
     * 設定ファイルに従って、icsファイルを書き込むオブジェクトを作成します.
     * @param conf ical設定
     * @throws NoSuchDirectoryException 指定のパスがディレクトリへの絶対パスではないとき
     * @throws IOException ディレクトリ作成時
     */
    public DocumentFileWriter(final GsolIcalConfigCont conf)
            throws NoSuchDirectoryException, IOException {
        this(conf.getDocumentDirectry(),
            conf.getTempFilePrefix(), conf.getTempFileSuffix(),
            Charset.forName(conf.getCharset()), conf.isAutoMkdir());
    }

    /**
     * dirディレクトリに書き込むオブジェクトを作成します.
     * @param dir 書き込み先directory
     * @param tempFilePrefix temporary file prefix
     * @param tempFileSuffix temporary file の拡張子
     * @param charset 書き込みに使う文字コード
     * @param autoMkdir directoryを自動作成するか
     * @throws NoSuchDirectoryException 指定のパスがディレクトリへの絶対パスではないとき
     * @throws IOException ディレクトリ作成時
     */
    public DocumentFileWriter(final String dir,
            final String tempFilePrefix, final String tempFileSuffix,
            final Charset charset, final boolean autoMkdir)
                    throws NoSuchDirectoryException, IOException {

        Path d = Paths.get(dir);
        try {
            d = getCanonicalPath(dir);
        } catch (final NoSuchDirectoryException e) {
            if (autoMkdir)
                d = Files.createDirectory(d);
            else
                throw e;
        }
        _dir = d;
        _tempFilePrefix = tempFilePrefix;
        _tempFileSuffix = tempFileSuffix;
        _charset = charset;
    }
    private static final Path getCanonicalPath(final Path dir)
            throws NoSuchDirectoryException {
        if (!dir.isAbsolute())
            throw new IllegalArgumentException(dir + " is not abusolute path");
        if (!Files.isDirectory(dir))
            throw new NoSuchDirectoryException(dir + " not found");
        return dir;
    }
    private static final Path getCanonicalPath(final String dir)
            throws NoSuchDirectoryException {
        return getCanonicalPath(Paths.get(dir));
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
        } catch (final Exception e) {
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
    public static final void validTraverse(final Path path)
            throws DirectoryTraversalException {
        if (!path.toAbsolutePath().equals(path.normalize()))
            throw new DirectoryTraversalException(
                    "It is not allowed to access parent directry!"
                    + " Absolute path:" + path.toAbsolutePath()
                    + " Canonical path:" + path.normalize());
    }
    /**
     * 書き込み先directoryのファイルの一覧を取得.
     * @return ファイル一覧のList
     * @throws IOException {@link java.nio.file.Files#list(Path)}
     */
    public final List<String> ls() throws IOException {
        return ls(_dir);
    }
    /**
     * 書き込み先directoryのファイルの一覧を取得.
     * @return ファイル一覧のStream
     * @throws IOException {@link java.nio.file.Files#list(Path)}
     */
    public final Stream<String> lsStream() throws IOException {
        return lsStream(_dir);
    }
    /**
     * ファイルの一覧を取得.
     * @param dir 一覧を取得するディレクトリ
     * @return ファイル一覧のList
     * @throws IOException {@link java.nio.file.Files#list(Path)}
     */
    public static final List<String> ls(final Path dir) throws IOException {
        return lsStream(dir).collect(Collectors.toList());
    }
    /**
     * ファイルの一覧を取得.
     * @param dir 一覧を取得するディレクトリ
     * @return ファイル一覧のStream
     * @throws IOException {@link java.nio.file.Files#list(Path)}
     */
    public static final Stream<String> lsStream(final Path dir)
            throws IOException {
        return Files.list(dir).map(p -> p.toFile().getName());
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
        delete(_dir, filename);
    }
    /**
     * ファイルを削除します.
     * @param filename 削除するファイル名
     * @throws IOException {@link java.nio.file.Files#deleteIfExists(Path)}
     * @throws NoFileNameException ファイル名がnullのとき
     * @throws DirectoryTraversalException {@link #validTraverse(Path)}
     */
    public static final void delete(final Path dir, final String filename)
            throws IOException, NoFileNameException, DirectoryTraversalException {
        if (filename == null)
            throw new NoFileNameException("filename is required.");

        final Path file = dir.resolve(filename);
        validTraverse(file);
        Files.deleteIfExists(file);
    }
    /**
     * ファイルを削除します.
     * @param filename 削除するファイル名
     * @throws IOException {@link java.nio.file.Files#deleteIfExists(Path)}
     * @throws NoFileNameException ファイル名がnullのとき
     * @throws DirectoryTraversalException {@link #validTraverse(Path)}
     * @throws NoSuchDirectoryException 
     */
    public static final void delete(final String dir, final String filename)
            throws IOException, NoFileNameException, DirectoryTraversalException, NoSuchDirectoryException {
        delete(getCanonicalPath(dir), filename);
    }
}
