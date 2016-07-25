package jp.co.gsol.ical.service.extended;

import java.util.List;

import org.seasar.extension.jdbc.parameter.Parameter;

import jp.co.gsol.ical.entity.IacSchEvent;
import jp.co.gsol.ical.entity.Names;

/**
 * iACのイベントテーブルのServiceクラスです.
 *  @author Global Solutions Co., Ltd.
 */
public class ExtendedIacSchEventService extends
        jp.co.gsol.ical.service.IacSchEventService {

    /**
     * ユーザの期間内のイベントを検索します.
     * @param userCd user code
     * @param startDate 開始日 (yyyyMMdd パターン文字列)
     * @param endDate 終了日 (yyyyMMdd パターン文字列)
     * @return ユーザのイベントリスト
     */
    public final List<IacSchEvent> findAllByUserCd(final String userCd,
            final String startDate, final String endDate) {
        return jdbcManager.selectBySqlFile(IacSchEvent.class,
                SqlFiles.IAC_SCH_EVENT_SERVICE_FIND_BY_USER_CD,
                Parameter.params(
                    Names.iacSchEventParticipant().userCd().toString(), userCd)
                    .$(Names.iacSchEvent().startDate().toString(), startDate)
                    .$(Names.iacSchEvent().endDate().toString(), endDate)
                .$()).getResultList();
    }

}
