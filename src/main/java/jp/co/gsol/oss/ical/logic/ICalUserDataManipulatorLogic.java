package jp.co.gsol.oss.ical.logic;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.seasar.extension.jdbc.JdbcManager;

import jp.co.gsol.oss.ical.config.general.GsolIcalConfigCont;
import jp.co.gsol.oss.ical.exception.DirectoryTraversalException;
import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.gsol.oss.ical.exception.NoFileNameException;
import jp.co.gsol.oss.ical.exception.NoSuchDirectoryException;
import jp.co.gsol.oss.ical.io.DocumentFileWriter;
import jp.co.intra_mart.foundation.config.ConfigurationException;
import jp.co.intra_mart.foundation.i18n.datetime.DateTime;

/**
 * アクションから呼ばれるDBとファイルの操作ロジック.
 * @author Global Solutions Co., Ltd.
 *
 */
public class ICalUserDataManipulatorLogic {

    /** icsファイル関連操作. */
    private IcsLogic icsLogic;
    /** iCalデータ生成. */
    private ICalGeneratorLogic iCalGeneratorLogic;
    /** ical設定.*/
    private final GsolIcalConfigCont conf;

    /**
     * JdbcManagerを指定する.
     * @param jdbcMan 指定するJdbcManager
     * @throws ICalException 設定ファイルが不正な場合
     */
    public ICalUserDataManipulatorLogic(final JdbcManager jdbcMan)
            throws ICalException {
        icsLogic = new IcsLogic(jdbcMan);
        try {
            conf = new GsolIcalConfigCont();
            iCalGeneratorLogic = new ICalGeneratorLogic(jdbcMan);
        } catch (final NoSuchDirectoryException | IOException | ConfigurationException e) {
            throw new ICalException(e);
        }
    }
    /**
     * icsファイル名の取得.
     * ユーザのデータが無ければnullを返す.
     * @param userCd ユーザコード
     * @return icsファイル名
     */
    public final String getFileName(final String userCd) {
        return icsLogic.findIcsFilename(userCd);
    }

    /**
     * ユーザデータの作成.
     * ファイルの作成とDBへの登録/更新を行います。
     * @param userCd ユーザコード
     * @param time 作成する日付時刻
     * @throws ICalException ファイル作成時にエラーが発生した場合
     * @return 作成したファイル名
     */
    public final String createUserData(final String userCd, final DateTime time)
            throws ICalException {
        final String fileName = createUniqueFileName();
        createFile(fileName, userCd, time);
        insertOrUpdateUserSetting(userCd, fileName);
        return fileName;
    }

    /**
     * ファイルの作成.
     * @param filename 作成するファイル名
     * @param userCd ユーザコード
     * @param time 作成する日付時刻
     * @throws ICalException ファイル作成時にエラーが発生した場合
     */
    public final void createFile(final String filename, final String userCd,
            final DateTime time)
            throws ICalException {
        try {
            iCalGeneratorLogic.write(filename, userCd, time);
        } catch (final IOException | ICalException e) {
            throw new ICalException(e);
        }
    }

    /**
     * ユーザデータの更新.
     * 古いファイルは削除されます。
     * @param userCd ユーザコード
     * @param time 更新日付時刻
     * @return 新しいファイル名
     * @throws IOException ファイル削除でエラーが発生した場合
     * @throws ICalException ファイル作成時にエラーが発生した場合
     */
    public final String deleteAndCreateUserData(final String userCd,
            final DateTime time)
            throws IOException, ICalException {
        final String oldFilename = getFileName(userCd);
        final String newFilename = createUserData(userCd, time);
        if (oldFilename != null) deleteFile(oldFilename);
        return newFilename;
    }

    /**
     * ユーザデータのDB登録・更新処理.
     * @param userCd ユーザコード
     * @param fileName ファイル名
     */
    public final void insertOrUpdateUserSetting(
            final String userCd, final String fileName) {
        icsLogic.insertOrUpdate(userCd, fileName);
    }

    /**
     * ユーザデータの削除.
     * ファイルの削除とDBの削除
     * @param userCd ユーザコード
     * @throws IOException ファイル削除時にエラーが起きた場合
     * @throws ICalException ファイル削除の指定が不正な場合
     */
    public final void deleteUserData(final String userCd)
            throws IOException, ICalException {
        try {
            deleteFile(getFileName(userCd));
        } finally {
            deleteUserSetting(userCd);
        }
    }
    /**
     * ユーザデータをDBから削除.
     * @param userCd ユーザコード
     */
    public final void deleteUserSetting(final String userCd) {
        icsLogic.deleteByUserCd(userCd);
    }

    /**
     * ファイルの削除.
     * @param fileName 削除するファイル名
     * @throws IOException ファイル削除時にエラーが起きた場合
     * @throws ICalException ファイル削除の指定が不正な場合
     */
    public final void deleteFile(final String fileName)
            throws IOException, ICalException {
       try {
           new DocumentFileWriter(conf)
           .delete(fileName);
        } catch (final NoFileNameException | DirectoryTraversalException | NoSuchDirectoryException e) {
            throw new ICalException(e);
        }
    }

    /**
     * ランダム英数字からなるユニークなファイル名を生成.
     * @return ユニークなファイル名
     * @throws ICalException 
     */
    public final String createUniqueFileName() throws ICalException {
        return createUniqueFileName(conf.getIcsFilenameLen(),
                conf.getIcsFileExtension());
    }

    /**
     * ランダム英数字からなるユニークなファイル名を生成.
     * @param len ファイル名の長さ.
     * @param extension ファイルの拡張子
     * @return ユニークなファイル名
     * @throws ICalException 
     */
    public final String createUniqueFileName(
            final int len, final String extension) throws ICalException {
        try {
            String fileName = null;
            final List<String> files = new DocumentFileWriter(conf).ls();
            int i = 0;
            do {
                if (i++ > 100)
                    throw new ICalException("cannot create unique filename, because of conflict filename " + fileName);
                fileName = (RandomStringUtils.randomAlphanumeric(len - extension.length())
                        + extension).toLowerCase();
            } while (files.contains(fileName) || icsLogic.existsFilename(fileName));
            return fileName;
        } catch (final IOException | NoSuchDirectoryException e) {
            throw new ICalException(e);
        }
    }

    /**
     * ファイルの一つ上の階層のURLを取得.
     * @return ファイルの一つ上の階層のURL
     */
    public String getParentURL() {
        return conf.getLocationPath();
    }

    /**
     * 外部からファイルにアクセスするURLの取得.
     * @param filename ファイル名
     * @return 外部からファイルにアクセスするURL
     */
    public String getFileAccesssURL(final String filename) {
        return getParentURL() + "/" + filename;
    }
}
