package jp.co.gsol.oss.ical.service.extended;

import java.util.Date;
import java.util.List;

import org.seasar.extension.jdbc.parameter.Parameter;
import org.seasar.extension.jdbc.where.SimpleWhere;



import jp.co.gsol.oss.ical.entity.IcalUpdateQueue;
import jp.co.gsol.oss.ical.entity.Names;
import jp.co.gsol.oss.ical.service.IcalUpdateQueueService;

public class ExtendedIcalUpdateQueueService extends IcalUpdateQueueService {

    /**
     * 指定日時以降に更新されたレコードを検索する.
     * @param lastUpdateTime 前回の検索日時
     * @return 更新対象候補の情報
     */
    public final List<IcalUpdateQueue>
    findAllLaterThan(final Date lastUpdateTime) {
        return jdbcManager.from(IcalUpdateQueue.class)
                .where(new SimpleWhere()
                    .gt(Names.icalUpdateQueue().lastUpdateTime().toString(),
                    Parameter.timestamp(lastUpdateTime)))
               .getResultList();
    }
}
