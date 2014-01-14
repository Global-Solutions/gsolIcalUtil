package jp.co.gsol.ical.logic;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;

import jp.co.gsol.ical.data.CalendarConverter;
import jp.co.gsol.ical.entity.IcalUserIcsRel;
import jp.co.gsol.ical.exception.DirectoryTraversalException;
import jp.co.gsol.ical.exception.ICalException;
import jp.co.gsol.ical.exception.NoSuchDirectoryException;
import jp.co.gsol.ical.io.DocumentFileWriter;
import jp.co.gsol.ical.settings.ICalSetting;
import jp.co.intra_mart.foundation.i18n.datetime.DateTime;

/**
 * icsファイルを書き込むクラスです.
 * @author Global Solutions Co., Ltd.
 */
public class ICalGeneratorLogic {

    /** ファイルアクセス.*/
    private final DocumentFileWriter writer;
    /** カレンダー取得.*/
    private final CalendarReaderLogic calendarReaderLogic;
    /** ics関連操作.*/
    private final IcsLogic icsLogic;

    /**
     * ICalSettingの設定を使って、icsファイルを書き込むオブジェクトを作成します.
     * @param jdbcMan 使用するJdbcManager
     * @throws NoSuchDirectoryException {@link DocumentFileWriter#DocumentFileWriter(String)}
     */
    public ICalGeneratorLogic(final JdbcManager jdbcMan)
            throws NoSuchDirectoryException {
        this(ICalSetting.documentDirectory(), jdbcMan);
    }
    /**
     * dir directoryにicsファイルを書き込むオブジェクトを作成します.
     * @param dir 指定するdirectoryへのパス文字列
     * @param jdbcMan 使用するJdbcManager
     * @throws NoSuchDirectoryException {@link DocumentFileWriter#DocumentFileWriter(String)}
     */
    public ICalGeneratorLogic(final String dir, final JdbcManager jdbcMan)
            throws NoSuchDirectoryException {
        writer = new DocumentFileWriter(dir);
        calendarReaderLogic = new CalendarReaderLogic(jdbcMan);
        icsLogic = new IcsLogic(jdbcMan);
    }
    /**
     * icsファイル更新(指定期間のスケジュールを出力).
     * @param filename icsファイル名
     * @param userCd user code
     * @param refDate ユーザ情報参照基準日
     * @param startDate 開始日
     * @param endDate 終了日
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final void write(
            final String filename, final String userCd, final DateTime refDate,
            final DateTime startDate, final DateTime endDate)
                throws IOException, ICalException {
        try {
            writer.write(filename,
                    new CalendarConverter(
                        calendarReaderLogic.read(
                                userCd, refDate,
                                startDate, endDate
                        )));
        } catch (DirectoryTraversalException e) {
            throw new ICalException(e);
        }
    }
    /**
     * icsファイル更新 (設定ファイルで指定された期間のスケジュールを出力).
     * @param filename icsファイル名
     * @param userCd user code
     * @param refDate ユーザ情報参照基準日
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final void write(final String filename,
            final String userCd, final DateTime refDate)
            throws IOException, ICalException {
        write(filename, userCd, refDate,
                refDate.plusMonths(ICalSetting.icsStartMonth()).withTime(0, 0),
                refDate.plusMonths(ICalSetting.icsEndMonth()).withTime(0, 0));
    }
    /**
     * icsファイルをまとめて更新 (設定ファイルで指定された期間のスケジュールを出力).
     * @param icsRels ics 更新対象のユーザとicsファイルの情報
     * @param refDate ユーザ情報参照基準日
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final void writeBatch(
            final List<IcalUserIcsRel> icsRels, final DateTime refDate)
            throws IOException, ICalException {
        for (IcalUserIcsRel ics: icsRels)
            write(ics.icsName, ics.userCd, refDate);
    }
    /**
     * スケジュールが更新されたicsファイルをまとめて更新 (設定ファイルで指定された期間のスケジュールを出力).
     * @param lastUpdateDate 前回の実行日時
     * @param refDate ユーザ情報参照基準日
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final void writeBatchUpdatedSchedules(
            final Date lastUpdateDate, final DateTime refDate)
            throws IOException, ICalException {
        writeBatch(icsLogic.findAllCandToBeUpdated(lastUpdateDate), refDate);
    }
}
