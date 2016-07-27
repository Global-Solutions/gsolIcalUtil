/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.oss.ical.service;

import java.util.List;
import javax.annotation.Generated;
import jp.co.gsol.oss.ical.entity.IcalUserIcsRel;

import static jp.co.gsol.oss.ical.entity.IcalUserIcsRelNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link IcalUserIcsRel}のサービスクラスです。
 * 
 * @author Global Solutions Co., Ltd.
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2014/01/08 16:13:46")
public class IcalUserIcsRelService extends AbstractService<IcalUserIcsRel> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param userCd
     *            識別子
     * @return エンティティ
     */
    public IcalUserIcsRel findById(String userCd) {
        return select().id(userCd).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<IcalUserIcsRel> findAllOrderById() {
        return select().orderBy(asc(userCd())).getResultList();
    }
}