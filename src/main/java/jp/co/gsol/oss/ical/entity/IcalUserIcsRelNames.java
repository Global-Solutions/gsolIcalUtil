/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.oss.ical.entity;

import java.sql.Timestamp;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link IcalUserIcsRel}のプロパティ名の集合です。
 * 
 * @author Global Solutions Co., Ltd.
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2014/01/08 16:13:44")
public class IcalUserIcsRelNames {

    /**
     * userCdのプロパティ名を返します。
     * 
     * @return userCdのプロパティ名
     */
    public static PropertyName<String> userCd() {
        return new PropertyName<String>("userCd");
    }

    /**
     * icsNameのプロパティ名を返します。
     * 
     * @return icsNameのプロパティ名
     */
    public static PropertyName<String> icsName() {
        return new PropertyName<String>("icsName");
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
     * @author Global Solutions Co., Ltd.
     */
    public static class _IcalUserIcsRelNames extends PropertyName<IcalUserIcsRel> {

        /**
         * インスタンスを構築します。
         */
        public _IcalUserIcsRelNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _IcalUserIcsRelNames(final String name) {
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
        public _IcalUserIcsRelNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
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
         * icsNameのプロパティ名を返します。
         *
         * @return icsNameのプロパティ名
         */
        public PropertyName<String> icsName() {
            return new PropertyName<String>(this, "icsName");
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
    }
}