package jp.co.gsol.oss.ical.logic;

import org.openide.util.MapFormat;
import org.seasar.extension.jdbc.JdbcManager;

import com.google.common.collect.ImmutableMap;

import jp.co.gsol.oss.ical.config.general.GsolIcalConfigCont;
import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.gsol.oss.ical.model.ICalendar;
import jp.co.intra_mart.foundation.exception.BizApiException;
import jp.co.intra_mart.foundation.i18n.datetime.DateTime;
import jp.co.intra_mart.foundation.master.user.UserManager;
import jp.co.intra_mart.foundation.master.user.model.User;
import jp.co.intra_mart.foundation.master.user.model.UserBizKey;

/**
 * ユーザのカレンダーオブジェクトを取得します.
 * @author Global Solutions Co., Ltd.
 */
public class CalendarReaderLogic {

    /** iACスケジュールにアクセスするlogic.*/
    private IacScheduleReaderLogic iacScheduleReaderLogic;
    /** ical設定.*/
    private final GsolIcalConfigCont conf;

    /**
     * JdbcManagerを指定します.
     * @param jdbcManager 指定するJdbcManager
     * @param conf ical設定
     */
    public CalendarReaderLogic(final JdbcManager jdbcManager,
            final GsolIcalConfigCont conf) {
        iacScheduleReaderLogic = new IacScheduleReaderLogic(jdbcManager, conf);
        this.conf = conf;
    }

    /**
     * ユーザのカレンダーを指定期間検索する.
     * @param userCd user code
     * @param refDate ユーザ情報参照基準日
     * @param startDate 開始日
     * @param endDate 終了日
     * @return ユーザのカレンダーオブジェクト
     * @throws ICalException {@link IacScheduleReaderLogic#findAllByUserCd(String, DateTime, DateTime, java.util.Locale)}
     * または、 {@link #getUser(String, DateTime)}
     */
    public final ICalendar read(
            final String userCd, final DateTime refDate,
            final DateTime startDate, final DateTime endDate)
                throws ICalException {
        try {
            return new ICalendar(conf.getProdId(),
                    MapFormat.format(conf.getCalendarNameTemplate(),
                            ImmutableMap.of("userCd", userCd)),
                    refDate.getTimeZone(),
                    iacScheduleReaderLogic.findAllByUserCd(userCd,
                            startDate, endDate,
                            getUser(userCd, refDate).getDefaultLocale()));
        } catch (BizApiException e) {
            throw new ICalException(e);
        }
    }
    /**
     * userCd -> User.
     * @param userCd user code
     * @param date 検索基準日
     * @return ユーザオブジェクト
     * @throws BizApiException
     * {@link jp.co.intra_mart.foundation.master.user.UserManager#getUser(jp.co.intra_mart.foundation.master.user.model.IUserBizKey, java.util.Date)}
     * @throws ICalException ユーザの情報が取得できないとき
     */
    private User getUser(final String userCd, final DateTime date)
            throws BizApiException, ICalException {
        final UserManager um = new UserManager();
        final UserBizKey key = new UserBizKey();
        key.setUserCd(userCd);
        final User user = um.getUser(key, date.getDate());
        if (user == null)
            throw new ICalException(
                    "User's info is missing. "
                    + "userCd: " + userCd + " date: " + date);
        return user;
    }
}
