/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.ical.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import jp.co.gsol.ical.entity.IacSchScheduleNames._IacSchScheduleNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link IacSchParticipant}のプロパティ名の集合です。
 * 
 * @author Global Solutions Co., Ltd.
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2014/01/08 16:13:44")
public class IacSchParticipantNames {

    /**
     * scheduleCdのプロパティ名を返します。
     * 
     * @return scheduleCdのプロパティ名
     */
    public static PropertyName<String> scheduleCd() {
        return new PropertyName<String>("scheduleCd");
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
     * reminder1NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder1NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder1NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder1NoticeFlag");
    }

    /**
     * reminder2NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder2NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder2NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder2NoticeFlag");
    }

    /**
     * reminder3NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder3NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder3NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder3NoticeFlag");
    }

    /**
     * reminder4NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder4NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder4NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder4NoticeFlag");
    }

    /**
     * reminder5NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder5NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder5NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder5NoticeFlag");
    }

    /**
     * reminder6NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder6NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder6NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder6NoticeFlag");
    }

    /**
     * reminder7NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder7NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder7NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder7NoticeFlag");
    }

    /**
     * reminder8NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder8NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder8NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder8NoticeFlag");
    }

    /**
     * reminder9NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder9NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder9NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder9NoticeFlag");
    }

    /**
     * reminder10NoticeFlagのプロパティ名を返します。
     * 
     * @return reminder10NoticeFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> reminder10NoticeFlag() {
        return new PropertyName<BigDecimal>("reminder10NoticeFlag");
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
     * iacSchScheduleのプロパティ名を返します。
     * 
     * @return iacSchScheduleのプロパティ名
     */
    public static _IacSchScheduleNames iacSchSchedule() {
        return new _IacSchScheduleNames("iacSchSchedule");
    }

    /**
     * @author Global Solutions Co., Ltd.
     */
    public static class _IacSchParticipantNames extends PropertyName<IacSchParticipant> {

        /**
         * インスタンスを構築します。
         */
        public _IacSchParticipantNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _IacSchParticipantNames(final String name) {
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
        public _IacSchParticipantNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * scheduleCdのプロパティ名を返します。
         *
         * @return scheduleCdのプロパティ名
         */
        public PropertyName<String> scheduleCd() {
            return new PropertyName<String>(this, "scheduleCd");
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
         * reminder1NoticeFlagのプロパティ名を返します。
         *
         * @return reminder1NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder1NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder1NoticeFlag");
        }

        /**
         * reminder2NoticeFlagのプロパティ名を返します。
         *
         * @return reminder2NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder2NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder2NoticeFlag");
        }

        /**
         * reminder3NoticeFlagのプロパティ名を返します。
         *
         * @return reminder3NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder3NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder3NoticeFlag");
        }

        /**
         * reminder4NoticeFlagのプロパティ名を返します。
         *
         * @return reminder4NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder4NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder4NoticeFlag");
        }

        /**
         * reminder5NoticeFlagのプロパティ名を返します。
         *
         * @return reminder5NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder5NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder5NoticeFlag");
        }

        /**
         * reminder6NoticeFlagのプロパティ名を返します。
         *
         * @return reminder6NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder6NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder6NoticeFlag");
        }

        /**
         * reminder7NoticeFlagのプロパティ名を返します。
         *
         * @return reminder7NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder7NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder7NoticeFlag");
        }

        /**
         * reminder8NoticeFlagのプロパティ名を返します。
         *
         * @return reminder8NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder8NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder8NoticeFlag");
        }

        /**
         * reminder9NoticeFlagのプロパティ名を返します。
         *
         * @return reminder9NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder9NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder9NoticeFlag");
        }

        /**
         * reminder10NoticeFlagのプロパティ名を返します。
         *
         * @return reminder10NoticeFlagのプロパティ名
         */
        public PropertyName<BigDecimal> reminder10NoticeFlag() {
            return new PropertyName<BigDecimal>(this, "reminder10NoticeFlag");
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
         * iacSchScheduleのプロパティ名を返します。
         * 
         * @return iacSchScheduleのプロパティ名
         */
        public _IacSchScheduleNames iacSchSchedule() {
            return new _IacSchScheduleNames(this, "iacSchSchedule");
        }
    }
}