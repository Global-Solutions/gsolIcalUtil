/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.oss.ical.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import jp.co.gsol.oss.ical.entity.IacSchEventParticipantNames._IacSchEventParticipantNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link IacSchEvent}のプロパティ名の集合です。
 * 
 * @author Global Solutions Co., Ltd.
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2014/01/08 16:13:44")
public class IacSchEventNames {

    /**
     * eventCdのプロパティ名を返します。
     * 
     * @return eventCdのプロパティ名
     */
    public static PropertyName<String> eventCd() {
        return new PropertyName<String>("eventCd");
    }

    /**
     * repeatCdのプロパティ名を返します。
     * 
     * @return repeatCdのプロパティ名
     */
    public static PropertyName<String> repeatCd() {
        return new PropertyName<String>("repeatCd");
    }

    /**
     * titleのプロパティ名を返します。
     * 
     * @return titleのプロパティ名
     */
    public static PropertyName<String> title() {
        return new PropertyName<String>("title");
    }

    /**
     * startDateのプロパティ名を返します。
     * 
     * @return startDateのプロパティ名
     */
    public static PropertyName<String> startDate() {
        return new PropertyName<String>("startDate");
    }

    /**
     * endDateのプロパティ名を返します。
     * 
     * @return endDateのプロパティ名
     */
    public static PropertyName<String> endDate() {
        return new PropertyName<String>("endDate");
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
     * timezoneIdのプロパティ名を返します。
     * 
     * @return timezoneIdのプロパティ名
     */
    public static PropertyName<String> timezoneId() {
        return new PropertyName<String>("timezoneId");
    }

    /**
     * descriptionのプロパティ名を返します。
     * 
     * @return descriptionのプロパティ名
     */
    public static PropertyName<String> description() {
        return new PropertyName<String>("description");
    }

    /**
     * placeのプロパティ名を返します。
     * 
     * @return placeのプロパティ名
     */
    public static PropertyName<String> place() {
        return new PropertyName<String>("place");
    }

    /**
     * goingoutFlagのプロパティ名を返します。
     * 
     * @return goingoutFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> goingoutFlag() {
        return new PropertyName<BigDecimal>("goingoutFlag");
    }

    /**
     * visitorFlagのプロパティ名を返します。
     * 
     * @return visitorFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> visitorFlag() {
        return new PropertyName<BigDecimal>("visitorFlag");
    }

    /**
     * editPermissionFlagのプロパティ名を返します。
     * 
     * @return editPermissionFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> editPermissionFlag() {
        return new PropertyName<BigDecimal>("editPermissionFlag");
    }

    /**
     * privateTypeのプロパティ名を返します。
     * 
     * @return privateTypeのプロパティ名
     */
    public static PropertyName<BigDecimal> privateType() {
        return new PropertyName<BigDecimal>("privateType");
    }

    /**
     * fileExistsFlagのプロパティ名を返します。
     * 
     * @return fileExistsFlagのプロパティ名
     */
    public static PropertyName<BigDecimal> fileExistsFlag() {
        return new PropertyName<BigDecimal>("fileExistsFlag");
    }

    /**
     * folderPathのプロパティ名を返します。
     * 
     * @return folderPathのプロパティ名
     */
    public static PropertyName<String> folderPath() {
        return new PropertyName<String>("folderPath");
    }

    /**
     * joinUserListのプロパティ名を返します。
     * 
     * @return joinUserListのプロパティ名
     */
    public static PropertyName<String> joinUserList() {
        return new PropertyName<String>("joinUserList");
    }

    /**
     * registerUserCdのプロパティ名を返します。
     * 
     * @return registerUserCdのプロパティ名
     */
    public static PropertyName<String> registerUserCd() {
        return new PropertyName<String>("registerUserCd");
    }

    /**
     * registerUserNameのプロパティ名を返します。
     * 
     * @return registerUserNameのプロパティ名
     */
    public static PropertyName<String> registerUserName() {
        return new PropertyName<String>("registerUserName");
    }

    /**
     * registerDepartmentCdのプロパティ名を返します。
     * 
     * @return registerDepartmentCdのプロパティ名
     */
    public static PropertyName<String> registerDepartmentCd() {
        return new PropertyName<String>("registerDepartmentCd");
    }

    /**
     * registerDepartmentNameのプロパティ名を返します。
     * 
     * @return registerDepartmentNameのプロパティ名
     */
    public static PropertyName<String> registerDepartmentName() {
        return new PropertyName<String>("registerDepartmentName");
    }

    /**
     * registerDateのプロパティ名を返します。
     * 
     * @return registerDateのプロパティ名
     */
    public static PropertyName<Timestamp> registerDate() {
        return new PropertyName<Timestamp>("registerDate");
    }

    /**
     * updateUserCdのプロパティ名を返します。
     * 
     * @return updateUserCdのプロパティ名
     */
    public static PropertyName<String> updateUserCd() {
        return new PropertyName<String>("updateUserCd");
    }

    /**
     * updateUserNameのプロパティ名を返します。
     * 
     * @return updateUserNameのプロパティ名
     */
    public static PropertyName<String> updateUserName() {
        return new PropertyName<String>("updateUserName");
    }

    /**
     * updateDepartmentCdのプロパティ名を返します。
     * 
     * @return updateDepartmentCdのプロパティ名
     */
    public static PropertyName<String> updateDepartmentCd() {
        return new PropertyName<String>("updateDepartmentCd");
    }

    /**
     * updateDepartmentNameのプロパティ名を返します。
     * 
     * @return updateDepartmentNameのプロパティ名
     */
    public static PropertyName<String> updateDepartmentName() {
        return new PropertyName<String>("updateDepartmentName");
    }

    /**
     * updateDateのプロパティ名を返します。
     * 
     * @return updateDateのプロパティ名
     */
    public static PropertyName<Timestamp> updateDate() {
        return new PropertyName<Timestamp>("updateDate");
    }

    /**
     * selectedLocaleIdのプロパティ名を返します。
     * 
     * @return selectedLocaleIdのプロパティ名
     */
    public static PropertyName<String> selectedLocaleId() {
        return new PropertyName<String>("selectedLocaleId");
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
     * iacSchEventParticipantListのプロパティ名を返します。
     * 
     * @return iacSchEventParticipantListのプロパティ名
     */
    public static _IacSchEventParticipantNames iacSchEventParticipantList() {
        return new _IacSchEventParticipantNames("iacSchEventParticipantList");
    }

    /**
     * @author Global Solutions Co., Ltd.
     */
    public static class _IacSchEventNames extends PropertyName<IacSchEvent> {

        /**
         * インスタンスを構築します。
         */
        public _IacSchEventNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _IacSchEventNames(final String name) {
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
        public _IacSchEventNames(final PropertyName<?> parent, final String name) {
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
         * repeatCdのプロパティ名を返します。
         *
         * @return repeatCdのプロパティ名
         */
        public PropertyName<String> repeatCd() {
            return new PropertyName<String>(this, "repeatCd");
        }

        /**
         * titleのプロパティ名を返します。
         *
         * @return titleのプロパティ名
         */
        public PropertyName<String> title() {
            return new PropertyName<String>(this, "title");
        }

        /**
         * startDateのプロパティ名を返します。
         *
         * @return startDateのプロパティ名
         */
        public PropertyName<String> startDate() {
            return new PropertyName<String>(this, "startDate");
        }

        /**
         * endDateのプロパティ名を返します。
         *
         * @return endDateのプロパティ名
         */
        public PropertyName<String> endDate() {
            return new PropertyName<String>(this, "endDate");
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
         * timezoneIdのプロパティ名を返します。
         *
         * @return timezoneIdのプロパティ名
         */
        public PropertyName<String> timezoneId() {
            return new PropertyName<String>(this, "timezoneId");
        }

        /**
         * descriptionのプロパティ名を返します。
         *
         * @return descriptionのプロパティ名
         */
        public PropertyName<String> description() {
            return new PropertyName<String>(this, "description");
        }

        /**
         * placeのプロパティ名を返します。
         *
         * @return placeのプロパティ名
         */
        public PropertyName<String> place() {
            return new PropertyName<String>(this, "place");
        }

        /**
         * goingoutFlagのプロパティ名を返します。
         *
         * @return goingoutFlagのプロパティ名
         */
        public PropertyName<BigDecimal> goingoutFlag() {
            return new PropertyName<BigDecimal>(this, "goingoutFlag");
        }

        /**
         * visitorFlagのプロパティ名を返します。
         *
         * @return visitorFlagのプロパティ名
         */
        public PropertyName<BigDecimal> visitorFlag() {
            return new PropertyName<BigDecimal>(this, "visitorFlag");
        }

        /**
         * editPermissionFlagのプロパティ名を返します。
         *
         * @return editPermissionFlagのプロパティ名
         */
        public PropertyName<BigDecimal> editPermissionFlag() {
            return new PropertyName<BigDecimal>(this, "editPermissionFlag");
        }

        /**
         * privateTypeのプロパティ名を返します。
         *
         * @return privateTypeのプロパティ名
         */
        public PropertyName<BigDecimal> privateType() {
            return new PropertyName<BigDecimal>(this, "privateType");
        }

        /**
         * fileExistsFlagのプロパティ名を返します。
         *
         * @return fileExistsFlagのプロパティ名
         */
        public PropertyName<BigDecimal> fileExistsFlag() {
            return new PropertyName<BigDecimal>(this, "fileExistsFlag");
        }

        /**
         * folderPathのプロパティ名を返します。
         *
         * @return folderPathのプロパティ名
         */
        public PropertyName<String> folderPath() {
            return new PropertyName<String>(this, "folderPath");
        }

        /**
         * joinUserListのプロパティ名を返します。
         *
         * @return joinUserListのプロパティ名
         */
        public PropertyName<String> joinUserList() {
            return new PropertyName<String>(this, "joinUserList");
        }

        /**
         * registerUserCdのプロパティ名を返します。
         *
         * @return registerUserCdのプロパティ名
         */
        public PropertyName<String> registerUserCd() {
            return new PropertyName<String>(this, "registerUserCd");
        }

        /**
         * registerUserNameのプロパティ名を返します。
         *
         * @return registerUserNameのプロパティ名
         */
        public PropertyName<String> registerUserName() {
            return new PropertyName<String>(this, "registerUserName");
        }

        /**
         * registerDepartmentCdのプロパティ名を返します。
         *
         * @return registerDepartmentCdのプロパティ名
         */
        public PropertyName<String> registerDepartmentCd() {
            return new PropertyName<String>(this, "registerDepartmentCd");
        }

        /**
         * registerDepartmentNameのプロパティ名を返します。
         *
         * @return registerDepartmentNameのプロパティ名
         */
        public PropertyName<String> registerDepartmentName() {
            return new PropertyName<String>(this, "registerDepartmentName");
        }

        /**
         * registerDateのプロパティ名を返します。
         *
         * @return registerDateのプロパティ名
         */
        public PropertyName<Timestamp> registerDate() {
            return new PropertyName<Timestamp>(this, "registerDate");
        }

        /**
         * updateUserCdのプロパティ名を返します。
         *
         * @return updateUserCdのプロパティ名
         */
        public PropertyName<String> updateUserCd() {
            return new PropertyName<String>(this, "updateUserCd");
        }

        /**
         * updateUserNameのプロパティ名を返します。
         *
         * @return updateUserNameのプロパティ名
         */
        public PropertyName<String> updateUserName() {
            return new PropertyName<String>(this, "updateUserName");
        }

        /**
         * updateDepartmentCdのプロパティ名を返します。
         *
         * @return updateDepartmentCdのプロパティ名
         */
        public PropertyName<String> updateDepartmentCd() {
            return new PropertyName<String>(this, "updateDepartmentCd");
        }

        /**
         * updateDepartmentNameのプロパティ名を返します。
         *
         * @return updateDepartmentNameのプロパティ名
         */
        public PropertyName<String> updateDepartmentName() {
            return new PropertyName<String>(this, "updateDepartmentName");
        }

        /**
         * updateDateのプロパティ名を返します。
         *
         * @return updateDateのプロパティ名
         */
        public PropertyName<Timestamp> updateDate() {
            return new PropertyName<Timestamp>(this, "updateDate");
        }

        /**
         * selectedLocaleIdのプロパティ名を返します。
         *
         * @return selectedLocaleIdのプロパティ名
         */
        public PropertyName<String> selectedLocaleId() {
            return new PropertyName<String>(this, "selectedLocaleId");
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
         * iacSchEventParticipantListのプロパティ名を返します。
         * 
         * @return iacSchEventParticipantListのプロパティ名
         */
        public _IacSchEventParticipantNames iacSchEventParticipantList() {
            return new _IacSchEventParticipantNames(this, "iacSchEventParticipantList");
        }
    }
}
