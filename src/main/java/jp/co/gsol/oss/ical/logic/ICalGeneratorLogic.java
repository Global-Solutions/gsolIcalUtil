package jp.co.gsol.oss.ical.logic;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.seasar.extension.jdbc.JdbcManager;

import jp.co.gsol.oss.ical.config.general.GsolIcalConfigCont;
import jp.co.gsol.oss.ical.data.CalendarConverter;
import jp.co.gsol.oss.ical.entity.IcalUserIcsRel;
import jp.co.gsol.oss.ical.exception.DirectoryTraversalException;
import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.gsol.oss.ical.exception.NoSuchDirectoryException;
import jp.co.gsol.oss.ical.io.DocumentFileWriter;
import jp.co.intra_mart.foundation.config.ConfigurationException;
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
    /** ical設定.*/
    private final GsolIcalConfigCont conf;

    /**
     * 設定ファイルに従って、icsファイルを書き込むオブジェクトを作成します.
     * @param jdbcMan 使用するJdbcManager
     * @throws NoSuchDirectoryException {@link DocumentFileWriter#DocumentFileWriter(GsolIcalConfigCont)}
     * @throws IOException {@link DocumentFileWriter#DocumentFileWriter(GsolIcalConfigCont)}
     * @throws ConfigurationException {@link GsolIcalConfigCont#GsolIcalConfigCont()}
     */
    public ICalGeneratorLogic(final JdbcManager jdbcMan)
            throws NoSuchDirectoryException, IOException, ConfigurationException {
        this(new GsolIcalConfigCont(), jdbcMan);
    }
    /**
     * 設定に従って、icsファイルを書き込むオブジェクトを作成します.
     * @param conf ical設定
     * @param jdbcMan 使用するJdbcManager
     * @throws NoSuchDirectoryException {@link DocumentFileWriter#DocumentFileWriter(GsolIcalConfigCont)}
     * @throws IOException {@link DocumentFileWriter#DocumentFileWriter(GsolIcalConfigCont)}
     */
    public ICalGeneratorLogic(final GsolIcalConfigCont conf, final JdbcManager jdbcMan)
            throws NoSuchDirectoryException, IOException {
        writer = new DocumentFileWriter(conf);
        calendarReaderLogic = new CalendarReaderLogic(jdbcMan, conf);
        icsLogic = new IcsLogic(jdbcMan);
        this.conf = conf;
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
        } catch (final DirectoryTraversalException e) {
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
                refDate.plusMonths(conf.getIcsStartMonth()).withTime(0, 0),
                refDate.plusMonths(conf.getIcsEndMonth()).withTime(0, 0));
    }
    /**
     * icsファイルをまとめて更新 (設定ファイルで指定された期間のスケジュールを出力).
     * @param icsRels ics 更新対象のユーザとicsファイルの情報
     * @param refDate ユーザ情報参照基準日
     * @return 更新件数
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final int writeBatch(
            final List<IcalUserIcsRel> icsRels, final DateTime refDate)
            throws IOException, ICalException {
        for (IcalUserIcsRel ics: icsRels)
            write(ics.icsName, ics.userCd, refDate);
        return icsRels.size();
    }
    /**
     * スケジュールが更新されたicsファイルをまとめて更新 (設定ファイルで指定された期間のスケジュールを出力).
     * @param lastUpdateDate 前回の実行日時
     * @param refDate ユーザ情報参照基準日
     * @return 更新件数
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final int writeBatchUpdatedSchedulesNoRecovery(
            final Date lastUpdateDate, final DateTime refDate)
            throws IOException, ICalException {
        return writeBatch(icsLogic.findAllCandToBeUpdated(lastUpdateDate), refDate);
    }
    /**
     * スケジュールが更新されたicsファイルをまとめて更新 (設定ファイルで指定された期間のスケジュールを出力).
     * @param lastUpdateDate 前回の実行日時
     * @param refDate ユーザ情報参照基準日
     * @return 更新件数
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final int writeBatchUpdatedSchedulesAutoRecovery(
            final Date lastUpdateDate, final DateTime refDate)
            throws IOException, ICalException {
        final List<IcalUserIcsRel> allRels = icsLogic.findAll();

        final List<String> updatedUserCds =
                icsLogic.findAllUserCdToBeUpdated(lastUpdateDate);
        final List<String> files = writer.ls();
        final Stream<IcalUserIcsRel> missingFiles =
                allRels.stream().filter(r -> !files.contains(r.icsName));
        return writeBatch(Stream.concat(
                lastUpdateDate == null ? allRels.stream():
                    allRels.stream().filter(r -> updatedUserCds.contains(r.userCd)),
                missingFiles
        ).distinct().collect(Collectors.toList()), refDate);
    }
    /**
     * スケジュールが更新されたicsファイルをまとめて更新 (設定ファイルで指定された期間のスケジュールを出力).
     * @param lastUpdateDate 前回の実行日時
     * @param refDate ユーザ情報参照基準日
     * @param autoRecovery 存在しないファイルを自動回復するか
     * @return 更新件数
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final int writeBatchUpdatedSchedules(
            final Date lastUpdateDate, final DateTime refDate,
            final boolean autoRecovery)
            throws IOException, ICalException {
        if (autoRecovery)
            return writeBatchUpdatedSchedulesAutoRecovery(lastUpdateDate, refDate);
        else
            return writeBatchUpdatedSchedulesNoRecovery(lastUpdateDate, refDate);
    }
    /**
     * スケジュールが更新されたicsファイルをまとめて更新 (設定ファイルで指定された期間のスケジュールを出力).
     * @param lastUpdateDate 前回の実行日時
     * @param refDate ユーザ情報参照基準日
     * @return 更新件数
     * @throws IOException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * @throws ICalException {@link DocumentFileWriter#write(String, CalendarConverter)}
     * または、 {@link CalendarReaderLogic#read(String, DateTime, DateTime, DateTime)}
     * または、ディレクトリトラバーサルする可能性があるとき
     */
    public final int writeBatchUpdatedSchedules(
            final Date lastUpdateDate, final DateTime refDate)
            throws IOException, ICalException {
        return writeBatchUpdatedSchedules(lastUpdateDate, refDate, conf.isAutoRecoveryFile());
    }
}
