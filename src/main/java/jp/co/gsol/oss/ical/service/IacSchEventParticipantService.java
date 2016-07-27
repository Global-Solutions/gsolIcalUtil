/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.oss.ical.service;

import java.util.List;
import javax.annotation.Generated;
import jp.co.gsol.oss.ical.entity.IacSchEventParticipant;

import static jp.co.gsol.oss.ical.entity.IacSchEventParticipantNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link IacSchEventParticipant}のサービスクラスです。
 * 
 * @author Global Solutions Co., Ltd.
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2014/01/08 16:13:46")
public class IacSchEventParticipantService extends AbstractService<IacSchEventParticipant> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param eventCd
     *            識別子
     * @param userCd
     *            識別子
     * @return エンティティ
     */
    public IacSchEventParticipant findById(String eventCd, String userCd) {
        return select().id(eventCd, userCd).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<IacSchEventParticipant> findAllOrderById() {
        return select().orderBy(asc(eventCd()), asc(userCd())).getResultList();
    }
}