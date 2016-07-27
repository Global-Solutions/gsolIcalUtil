package jp.co.gsol.oss.ical.service.extended;

import java.util.List;

import org.seasar.extension.jdbc.parameter.Parameter;

import jp.co.gsol.oss.ical.entity.IacSchSchedule;
import jp.co.gsol.oss.ical.entity.Names;
import jp.co.intra_mart.foundation.i18n.datetime.DateTime;

/**
 * iACのスケジュールテーブルのServiceクラスです.
 * @author Global Solutions Co., Ltd.
 */
public class ExtendedIacSchScheduleService extends
        jp.co.gsol.oss.ical.service.IacSchScheduleService {

    /**
     * ユーザの期間内のスケジュールを検索します.
     * @param userCd user code
     * @param startDate 開始日
     * @param endDate 終了日
     * @return ユーザのスケジュールリスト
     */
    public final List<IacSchSchedule> findAllByUserCd(final String userCd,
            final DateTime startDate, final DateTime endDate) {
        return jdbcManager.selectBySqlFile(IacSchSchedule.class,
               SqlFiles.IAC_SCH_SCHEDULE_SERVICE_FIND_BY_USER_CD,
               Parameter.params(
                  Names.iacSchParticipant().userCd().toString(), userCd)
               .$(Names.iacSchSchedule().startDate().toString(),
                       Parameter.timestamp(startDate.getCalendar()))
               .$(Names.iacSchSchedule().endDate().toString(),
                       Parameter.timestamp(endDate.getCalendar()))
               .$()).getResultList();
    }
}
