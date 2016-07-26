package jp.co.gsol.oss.ical.logic;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.seasar.extension.jdbc.JdbcManager;

import jp.co.gsol.oss.ical.entity.IcalUserIcsRel;
import jp.co.gsol.oss.ical.service.extended.ExtendedIcalUpdateQueueService;
import jp.co.gsol.oss.ical.service.extended.ExtendedIcalUserIcsRelService;

/**
 * icsファイル関連の操作.
 * @author Global Solutions Co., Ltd.
 */
public class IcsLogic {

    /** ical_user_ics_rel テーブル service.*/
    private ExtendedIcalUserIcsRelService extendedIcalUserIcsRelService;
    /** ical_user_ics_rel テーブル service.*/
    private ExtendedIcalUpdateQueueService extendedIcalUpdateQueueService;

    /**
     * JdbcManagerを指定する.
     * @param jdbcMan 指定するJdbcManager
     */
    public IcsLogic(final JdbcManager jdbcMan) {
        extendedIcalUserIcsRelService = new ExtendedIcalUserIcsRelService() {
            { this.jdbcManager = jdbcMan; }
        };
        extendedIcalUpdateQueueService = new ExtendedIcalUpdateQueueService() {
            { this.jdbcManager = jdbcMan; }
        };
    }
    /**
     * 指定日時後に更新されたのuserCdとicsファイル名を取得.
     * @param lastUpdateDate nullの場合は、全件取得
     * @return 更新対象候補
     */
    public final List<IcalUserIcsRel>
    findAllCandToBeUpdated(final Date lastUpdateDate) {
        if (lastUpdateDate == null)
            return extendedIcalUserIcsRelService.findAll();
        return extendedIcalUserIcsRelService.findAllLaterThan(lastUpdateDate);
    }
    /**
     * 指定日時後に更新されたのuserCdを取得
     * @param lastUpdateDate nullの場合は、空
     * @return 更新されたuserCd
     */
    public final Stream<String>
    findAllUserCdStreamToBeUpdated(final Date lastUpdateDate) {
        if (lastUpdateDate == null)
            return Stream.empty();
        return extendedIcalUpdateQueueService.findAllLaterThan(lastUpdateDate)
                .stream().map(q -> q.userCd);
    }
    /**
     * 指定日時後に更新されたのuserCdを取得
     * @param lastUpdateDate nullの場合は、空
     * @return 更新されたuserCd
     */
    public final List<String>
    findAllUserCdToBeUpdated(final Date lastUpdateDate) {
        return findAllUserCdStreamToBeUpdated(lastUpdateDate)
                .collect(Collectors.toList());
    }
    /**
     * ユーザとicsファイルの関連を登録か更新する.
     * @param userCd user code
     * @param filename ics ファイル名
     * @return 影響のあった行数
     */
    public final int insertOrUpdate(
            final String userCd, final String filename) {
        return extendedIcalUserIcsRelService
                .insertOrUpdate(userCd, filename,
                userCd, new Timestamp(new Date().getTime()));
    }
    /**
     * ユーザのics ファイル名を取得.
     * @param userCd user code
     * @return user's ics ファイル名
     */
    public final String findIcsFilename(final String userCd) {
        final IcalUserIcsRel user =
                extendedIcalUserIcsRelService.findById(userCd);
        if (user != null)
            return user.icsName;
        return null;
    }
    /**
     * ユーザとicsファイル名の関連を削除する.
     * @param userCd user code
     * @return 影響のあった行数
     */
    public final int deleteByUserCd(final String userCd) {
        return extendedIcalUserIcsRelService.deleteById(userCd);
    }
    /**
     * ファイル名に対応する情報が登録されているか.
     * @param filename ics ファイル名
     * @return すでにファイル名が登録されているとき、true
     */
    public final boolean existsFilename(final String filename) {
        return extendedIcalUserIcsRelService.findByIcs(filename) != null;
    }
}
