/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.ical.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import jp.co.gsol.ical.entity.IacSchEventNames._IacSchEventNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link IacSchEventParticipant}のプロパティ名の集合です。
 * 
 * @author Global Solutions Co., Ltd.
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2014/01/08 16:13:44")
public class IacSchEventParticipantNames {

    /**
     * eventCdのプロパティ名を返します。
     * 
     * @return eventCdのプロパティ名
     */
    public static PropertyName<String> eventCd() {
        return new PropertyName<String>("eventCd");
    }

    /**
     * userCdのプロパティ名を返します。
     * 
     * @return userCdのプロパティ名
     */
    public static PropertyName<String> userCd() {
        return new PropertyName<String>("userCd");
    }

    /**
     * startDateNumのプロパティ名を返します。
     * 
     * @return startDateNumのプロパティ名
     */
    public static PropertyName<BigDecimal> startDateNum() {
        return new PropertyName<BigDecimal>("startDateNum");
    }

    /**
     * endDateNumのプロパティ名を返します。
     * 
     * @return endDateNumのプロパティ名
     */
    public static PropertyName<BigDecimal> endDateNum() {
        return new PropertyName<BigDecimal>("endDateNum");
    }

    /**
     * remindDateのプロパティ名を返します。
     * 
     * @return remindDateのプロパティ名
     */
    public static PropertyName<Timestamp> remindDate() {
        return new PropertyName<Timestamp>("remindDate");
    }

    /**
     * remindTimezoneIdのプロパティ名を返します。
     * 
     * @return remindTimezoneIdのプロパティ名
     */
    public static PropertyName<String> remindTimezoneId() {
        return new PropertyName<String>("remindTimezoneId");
    }

    /**
     * createUserCdのプロパティ名を返します。
     * 
     * @return createUserCdのプロパティ名
     */
    public static PropertyName<String> createUserCd() {
        return new PropertyName<String>("createUserCd");
    }

    /**
     * createDateのプロパティ名を返します。
     * 
     * @return createDateのプロパティ名
     */
    public static PropertyName<Timestamp> createDate() {
        return new PropertyName<Timestamp>("createDate");
    }

    /**
     * recordUserCdのプロパティ名を返します。
     * 
     * @return recordUserCdのプロパティ名
     */
    public static PropertyName<String> recordUserCd() {
        return new PropertyName<String>("recordUserCd");
    }

    /**
     * recordDateのプロパティ名を返します。
     * 
     * @return recordDateのプロパティ名
     */
    public static PropertyName<Timestamp> recordDate() {
        return new PropertyName<Timestamp>("recordDate");
    }

    /**
     * iacSchEventのプロパティ名を返します。
     * 
     * @return iacSchEventのプロパティ名
     */
    public static _IacSchEventNames iacSchEvent() {
        return new _IacSchEventNames("iacSchEvent");
    }

    /**
     * @author Global Solutions Co., Ltd.
     */
    public static class _IacSchEventParticipantNames extends PropertyName<IacSchEventParticipant> {

        /**
         * インスタンスを構築します。
         */
        public _IacSchEventParticipantNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _IacSchEventParticipantNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _IacSchEventParticipantNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * eventCdのプロパティ名を返します。
         *
         * @return eventCdのプロパティ名
         */
        public PropertyName<String> eventCd() {
            return new PropertyName<String>(this, "eventCd");
        }

        /**
         * userCdのプロパティ名を返します。
         *
         * @return userCdのプロパティ名
         */
        public PropertyName<String> userCd() {
            return new PropertyName<String>(this, "userCd");
        }

        /**
         * startDateNumのプロパティ名を返します。
         *
         * @return startDateNumのプロパティ名
         */
        public PropertyName<BigDecimal> startDateNum() {
            return new PropertyName<BigDecimal>(this, "startDateNum");
        }

        /**
         * endDateNumのプロパティ名を返します。
         *
         * @return endDateNumのプロパティ名
         */
        public PropertyName<BigDecimal> endDateNum() {
            return new PropertyName<BigDecimal>(this, "endDateNum");
        }

        /**
         * remindDateのプロパティ名を返します。
         *
         * @return remindDateのプロパティ名
         */
        public PropertyName<Timestamp> remindDate() {
            return new PropertyName<Timestamp>(this, "remindDate");
        }

        /**
         * remindTimezoneIdのプロパティ名を返します。
         *
         * @return remindTimezoneIdのプロパティ名
         */
        public PropertyName<String> remindTimezoneId() {
            return new PropertyName<String>(this, "remindTimezoneId");
        }

        /**
         * createUserCdのプロパティ名を返します。
         *
         * @return createUserCdのプロパティ名
         */
        public PropertyName<String> createUserCd() {
            return new PropertyName<String>(this, "createUserCd");
        }

        /**
         * createDateのプロパティ名を返します。
         *
         * @return createDateのプロパティ名
         */
        public PropertyName<Timestamp> createDate() {
            return new PropertyName<Timestamp>(this, "createDate");
        }

        /**
         * recordUserCdのプロパティ名を返します。
         *
         * @return recordUserCdのプロパティ名
         */
        public PropertyName<String> recordUserCd() {
            return new PropertyName<String>(this, "recordUserCd");
        }

        /**
         * recordDateのプロパティ名を返します。
         *
         * @return recordDateのプロパティ名
         */
        public PropertyName<Timestamp> recordDate() {
            return new PropertyName<Timestamp>(this, "recordDate");
        }

        /**
         * iacSchEventのプロパティ名を返します。
         * 
         * @return iacSchEventのプロパティ名
         */
        public _IacSchEventNames iacSchEvent() {
            return new _IacSchEventNames(this, "iacSchEvent");
        }
    }
}
