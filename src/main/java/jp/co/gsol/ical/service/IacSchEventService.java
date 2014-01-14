/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.ical.service;

import java.util.List;
import javax.annotation.Generated;
import jp.co.gsol.ical.entity.IacSchEvent;

import static jp.co.gsol.ical.entity.IacSchEventNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link IacSchEvent}のサービスクラスです。
 * 
 * @author Global Solutions Co., Ltd.
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2014/01/08 16:13:46")
public class IacSchEventService extends AbstractService<IacSchEvent> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param eventCd
     *            識別子
     * @return エンティティ
     */
    public IacSchEvent findById(String eventCd) {
        return select().id(eventCd).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<IacSchEvent> findAllOrderById() {
        return select().orderBy(asc(eventCd())).getResultList();
    }
}