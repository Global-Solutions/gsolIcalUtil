package jp.co.gsol.oss.ical.logic;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.openide.util.MapFormat;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.util.lang.StringUtil;

import jp.co.gsol.oss.ical.entity.IacSchEvent;
import jp.co.gsol.oss.ical.entity.IacSchSchedule;
import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.gsol.oss.ical.model.ICalEvent;
import jp.co.gsol.oss.ical.service.extended.ExtendedIacSchEventService;
import jp.co.gsol.oss.ical.service.extended.ExtendedIacSchScheduleService;
import jp.co.gsol.oss.ical.settings.ICalSetting;
import jp.co.intra_mart.foundation.i18n.datetime.DateTime;
import jp.co.intra_mart.foundation.security.exception.AccessSecurityException;
import jp.co.intra_mart.foundation.security.message.MessageManager;

/**
 * iACのスケジュールを取得します.
 * @author Global Solutions Co., Ltd.
 */
public class IacScheduleReaderLogic {

    /** iac_sch_schedule テーブルservice.*/
    private ExtendedIacSchScheduleService extendedIacSchScheduleService;

    /** iac_sch_event テーブルservice.*/
    private ExtendedIacSchEventService extendedIacSchEventService;

    /**
     * JdbcManagerを指定する.
     * @param jdbcMan 指定するJdbcManager
     */
    public IacScheduleReaderLogic(final JdbcManager jdbcMan) {
        extendedIacSchScheduleService  = new ExtendedIacSchScheduleService() {
            { this.jdbcManager = jdbcMan; }
        };
        extendedIacSchEventService = new ExtendedIacSchEventService() {
            { this.jdbcManager = jdbcMan; }
        };
    }

    /**
     * ユーザのスケジュールを指定期間取得します.
     * @param userCd user code
     * @param startDate 開始日
     * @param endDate 終了日
     * @param locale 説明欄のLocale
     * @return イベントオブジェクトのリスト
     * @throws ICalException 設定ファイルかメッセージファイルが問題の可能性があります
     */
    public final List<ICalEvent> findAllByUserCd(final String userCd,
            final DateTime startDate, final DateTime endDate,
            final Locale locale) throws ICalException {
        List<ICalEvent> events = new ArrayList<>();
        try {
            for (IacSchSchedule entity
                : extendedIacSchScheduleService.findAllByUserCd(userCd,
                    startDate, endDate))
                events.add(map(entity, locale));
            for (IacSchEvent entity
                : extendedIacSchEventService.findAllByUserCd(userCd,
                    startDate.toDateTimeString(
                            ICalSetting.iacSchEventDatePattern(), locale),
                    endDate.toDateTimeString(
                            ICalSetting.iacSchEventDatePattern(), locale)))
                events.add(map(entity, locale));
        } catch (AccessSecurityException | ParseException e) {
            throw new ICalException(e);
        }
        return events;
    }
    /**
     * IacSchSchedule -> ICalEvent.
     * @param entity iACのスケジュール
     * @param locale 説明欄のLocale
     * @return イベントオブジェクト
     * @throws AccessSecurityException
     * {@link this#compileDesc(String, String, String, boolean, boolean, Locale)}
     * @throws ICalException {@link ICalEvent.Builder#build()}
     */
    private ICalEvent map(final IacSchSchedule entity, final Locale locale)
            throws AccessSecurityException, ICalException {
        final TimeZone tz = TimeZone.getTimeZone(entity.timezoneId);
        return ICalEvent.builder()
                .id(entity.scheduleCd).wholeDay(false)
                .summary(entity.title)
                .startDate(new DateTime(tz, entity.startDate))
                .endDate(new DateTime(tz, entity.endDate))
                .description(compileDesc(entity.description,
                        entity.joinUserList, entity.reserveFacilityList,
                        BigDecimal.ONE.equals(entity.goingoutFlag),
                        BigDecimal.ONE.equals(entity.visitorFlag),
                        locale))
                .location(entity.place)
                .lastModified(new DateTime(tz, entity.updateDate))
              .build();
    }

    /**
     * IacSchEvent -> ICalEvent.
     * @param entity iACのイベント
     * @param locale 説明欄のLocale
     * @return イベントオブジェクト
     * @throws ParseException
     * {@link jp.co.intra_mart.foundation.i18n.datetime.DateTime#parse(TimeZone, String, String)}
     * @throws AccessSecurityException
     * {@link this#compileDesc(String, String, String, boolean, boolean, Locale)}
     * @throws ICalException {@link ICalEvent.Builder#build()}
     */
    private ICalEvent map(final IacSchEvent entity, final Locale locale)
            throws ParseException, AccessSecurityException, ICalException {
        final TimeZone tz = TimeZone.getTimeZone(entity.timezoneId);
        return ICalEvent.builder()
                .id(entity.eventCd).wholeDay(true)
                .summary(entity.title)
                .startDate(DateTime.parse(tz, entity.startDate,
                        ICalSetting.iacSchEventDatePattern()))
                .endDate(DateTime.parse(tz, entity.endDate,
                        ICalSetting.iacSchEventDatePattern()))
                .description(compileDesc(entity.description,
                        entity.joinUserList, null,
                        BigDecimal.ONE.equals(entity.goingoutFlag),
                        BigDecimal.ONE.equals(entity.visitorFlag),
                        locale))
                .location(entity.place)
                .lastModified(new DateTime(tz, entity.updateDate))
              .build();
    }

    /**
     * 説明欄に出力する内容を作成します.
     * @param description iACスケジュールの説明
     * @param users 参加者文字列
     * @param facilities 施設文字列
     * @param out 外出
     * @param visitor 来客
     * @param locale 出力する内容のLocale
     * @return compiled iCalに出力する説明
     * @throws AccessSecurityException
     * {@link jp.co.intra_mart.foundation.security.message.MessageManager#getMessage(Locale, String)}
     */
    private String compileDesc(
            final String description,
            final String users, final String facilities,
            final boolean out, final boolean visitor,
            final Locale locale)
                throws AccessSecurityException {
        final String template = MessageManager.getInstance().getMessage(locale,
                "GSOL.ICAL.ICS_DESCRIPTION");
        final Map<String, String> map = new HashMap<>();
        map.put("description", valueOrBlank(description));
        map.put("users", valueOrBlank(users));
        map.put("facilities", valueOrBlank(facilities));
        map.put("out", out
                ? MessageManager.getInstance().getMessage(locale,
                "GSOL.ICAL.ICS_OUT")
                : StringUtil.EMPTY);
        map.put("visitor", visitor
                ? MessageManager.getInstance().getMessage(locale,
                "GSOL.ICAL.ICS_VISITOR")
                : StringUtil.EMPTY);
        return MapFormat.format(template, map);
    }
    /**
     * nullを空文字列にします.
     * @param str 文字列
     * @return 入力値か空文字列.
     */
    private String valueOrBlank(final String str) {
        return StringUtil.isBlank(str) ? StringUtil.EMPTY : str;
    }
}
