package jp.co.gsol.ical.service.extended;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.seasar.extension.jdbc.parameter.Parameter;
import org.seasar.extension.jdbc.where.SimpleWhere;

import jp.co.gsol.ical.entity.IcalUserIcsRel;
import jp.co.gsol.ical.entity.Names;

/**
 * icsファイルとユーザの関係を保存したテーブルのservice.
 * @author Global Solutions Co., Ltd.
 */
public class ExtendedIcalUserIcsRelService
extends jp.co.gsol.ical.service.IcalUserIcsRelService {
    /**
     * すでに登録されているときは、更新する.
     * @param entity 更新するユーザとicsファイルの情報
     * @return 影響のあった行数
     */
    public final int insertOrUpdate(final IcalUserIcsRel entity) {
        if (findById(entity.userCd) == null)
            return insert(entity);
        else
            return updateExcludesCreateTimestamp(entity);
    }
    /**
     * すでに登録されているときは、更新する.
     * @param userCd user code
     * @param icsName ics ファイル名
     * @param authUserCd レコードを更新するユーザ
     * @param timestamp 更新日時
     * @return 影響のあった行数
     */
    public final int insertOrUpdate(final String userCd, final String icsName,
            final String authUserCd, final Timestamp timestamp) {
        final IcalUserIcsRel entry = new IcalUserIcsRel();
        entry.userCd = userCd;
        entry.icsName = icsName;
        entry.createUserCd = authUserCd;
        entry.createDate = timestamp;
        entry.recordUserCd = authUserCd;
        entry.recordDate = timestamp;
        return insertOrUpdate(entry);
    }
    /**
     * icsファイル名に一致する情報があるか検索する.
     * @param icsName ics ファイル名
     * @return ユーザとファイル名の関連情報かnull
     */
    public final IcalUserIcsRel findByIcs(final String icsName) {
        if (icsName == null) return null;
        return jdbcManager.from(IcalUserIcsRel.class)
                .where(new SimpleWhere()
                .eq(Names.icalUserIcsRel().icsName(), icsName))
                .getSingleResult();
    }
    /**
     * 指定日時以降に更新されたレコードを検索する.
     * @param lastUpdateTime 前回の検索日時
     * @return 更新対象候補の情報
     */
    public final List<IcalUserIcsRel>
    findAllLaterThan(final Date lastUpdateTime) {
        return jdbcManager.selectBySqlFile(IcalUserIcsRel.class,
                SqlFiles.ICAL_USER_ICS_REL_SERVICE_FIND_ALL_LATER_THAN,
                Parameter.params(
                        Names.icalUpdateQueue().lastUpdateTime().toString(),
                        Parameter.timestamp(lastUpdateTime))
                        .$()).getResultList();
    }
    /**
     * 更新する(登録ユーザ、登録日は更新しない).
     * @param entity 更新するユーザとicsファイル名の情報
     * @return 影響のあった行数
     */
    public final int updateExcludesCreateTimestamp(
            final IcalUserIcsRel entity) {
        return jdbcManager.update(entity)
                .excludes(Names.icalUserIcsRel().createUserCd())
                .excludes(Names.icalUserIcsRel().createDate())
                .execute();
    }
    /**
     * 1件も更新されなかったとき、登録する.
     * @param entity 更新するユーザとicsファイル名の情報
     * @return 影響のあった行数
     */
    public final int upsert(final IcalUserIcsRel entity) {
        final int affectedCount = updateExcludesCreateTimestamp(entity);
        if (affectedCount > 0)
            return affectedCount;
        return insert(entity);
    }
    /**
     * 1件も更新されなかったとき、登録する.
     * @param userCd user code
     * @param icsName ics ファイル名
     * @param authUserCd レコードを更新するユーザ
     * @param timestamp 更新日時
     * @return 影響のあった行数
     */
    public final int upsert(final String userCd, final String icsName,
            final String authUserCd, final Timestamp timestamp) {
        final IcalUserIcsRel entry = new IcalUserIcsRel();
        entry.userCd = userCd;
        entry.icsName = icsName;
        entry.createUserCd = authUserCd;
        entry.createDate = timestamp;
        entry.recordUserCd = authUserCd;
        entry.recordDate = timestamp;
        return upsert(entry);
    }
    /**
     * userCdの情報を削除する.
     * @param userCd user code
     * @return 影響のあった行数
     */
    public final int deleteById(final String userCd) {
        final IcalUserIcsRel entity = new IcalUserIcsRel();
        entity.userCd = userCd;
        return jdbcManager.delete(entity).execute();
    }
}
