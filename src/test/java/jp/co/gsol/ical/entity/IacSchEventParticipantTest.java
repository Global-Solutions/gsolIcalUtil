/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.ical.entity;

import javax.annotation.Generated;
import org.junit.runner.RunWith;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.TestContext;

import static jp.co.gsol.ical.entity.IacSchEventParticipantNames.*;

/**
 * {@link IacSchEventParticipant}のテストクラスです。
 * 
 * @author Global Solutions Co., Ltd.
 */
@RunWith(Seasar2.class)
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2014/01/08 16:13:48")
public class IacSchEventParticipantTest {

    private TestContext testContext;

    private JdbcManager jdbcManager;

    /**
     * 事前処理をします。
     * 
     * @throws Exception
     */
    public void before() throws Exception {
        testContext.setAutoIncluding(false);
        testContext.include("s2jdbc.dicon");
    }

    /**
     * 識別子による取得をテストします。
     * 
     * @throws Exception
     */
    public void testFindById() throws Exception {
        jdbcManager.from(IacSchEventParticipant.class).id("aaa", "aaa").getSingleResult();
    }

    /**
     * iacSchEventとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_iacSchEvent() throws Exception {
        jdbcManager.from(IacSchEventParticipant.class).leftOuterJoin(iacSchEvent()).id("aaa", "aaa").getSingleResult();
    }
}