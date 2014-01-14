/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.ical.service;

import javax.annotation.Generated;
import org.junit.runner.RunWith;
import org.seasar.framework.unit.Seasar2;

import static org.junit.Assert.*;

/**
 * {@link IcalUserIcsRelService}のテストクラスです。
 * 
 * @author Global Solutions Co., Ltd.
 */
@RunWith(Seasar2.class)
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceTestModelFactoryImpl"}, date = "2014/01/08 16:13:50")
public class IcalUserIcsRelServiceTest {

    private IcalUserIcsRelService icalUserIcsRelService;

    /**
     * {@link #icalUserIcsRelService}が利用可能であることをテストします。
     * 
     * @throws Exception
     */
    public void testAvailable() throws Exception {
        assertNotNull(icalUserIcsRelService);
    }
}