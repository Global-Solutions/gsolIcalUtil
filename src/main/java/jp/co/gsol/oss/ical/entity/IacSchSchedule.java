/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */
package jp.co.gsol.oss.ical.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * IacSchScheduleエンティティクラス
 * @author Global Solutions Co., Ltd.
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2014/01/08 16:13:26")
public class IacSchSchedule implements Serializable {

    private static final long serialVersionUID = 1L;

    /** scheduleCdプロパティ */
    @Id
    @Column(length = 20, nullable = false, unique = true)
    public String scheduleCd;

    /** repeatCdプロパティ */
    @Column(length = 20, nullable = false, unique = false)
    public String repeatCd;

    /** titleプロパティ */
    @Column(length = 800, nullable = false, unique = false)
    public String title;

    /** startDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp startDate;

    /** endDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp endDate;

    /** startDateNumプロパティ */
    @Column(precision = 12, nullable = false, unique = false)
    public BigDecimal startDateNum;

    /** endDateNumプロパティ */
    @Column(precision = 12, nullable = false, unique = false)
    public BigDecimal endDateNum;

    /** timezoneIdプロパティ */
    @Column(length = 128, nullable = false, unique = false)
    public String timezoneId;

    /** descriptionプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String description;

    /** placeプロパティ */
    @Column(length = 400, nullable = true, unique = false)
    public String place;

    /** goingoutFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal goingoutFlag;

    /** visitorFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal visitorFlag;

    /** editPermissionFlagプロパティ */
    @Column(precision = 1, nullable = false, unique = false)
    public BigDecimal editPermissionFlag;

    /** privateTypeプロパティ */
    @Column(precision = 1, nullable = false, unique = false)
    public BigDecimal privateType;

    /** fileExistsFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal fileExistsFlag;

    /** folderPathプロパティ */
    @Column(length = 1000, nullable = true, unique = false)
    public String folderPath;

    /** joinUserListプロパティ */
    @Column(length = 2147483647, nullable = false, unique = false)
    public String joinUserList;

    /** reserveFacilityListプロパティ */
    @Column(length = 2147483647, nullable = true, unique = false)
    public String reserveFacilityList;

    /** registerUserCdプロパティ */
    @Column(length = 100, nullable = false, unique = false)
    public String registerUserCd;

    /** registerUserNameプロパティ */
    @Column(length = 1000, nullable = false, unique = false)
    public String registerUserName;

    /** registerDepartmentCdプロパティ */
    @Column(length = 100, nullable = true, unique = false)
    public String registerDepartmentCd;

    /** registerDepartmentNameプロパティ */
    @Column(length = 2000, nullable = true, unique = false)
    public String registerDepartmentName;

    /** registerDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp registerDate;

    /** updateUserCdプロパティ */
    @Column(length = 100, nullable = false, unique = false)
    public String updateUserCd;

    /** updateUserNameプロパティ */
    @Column(length = 1000, nullable = false, unique = false)
    public String updateUserName;

    /** updateDepartmentCdプロパティ */
    @Column(length = 100, nullable = true, unique = false)
    public String updateDepartmentCd;

    /** updateDepartmentNameプロパティ */
    @Column(length = 2000, nullable = true, unique = false)
    public String updateDepartmentName;

    /** updateDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp updateDate;

    /** selectedLocaleIdプロパティ */
    @Column(length = 50, nullable = false, unique = false)
    public String selectedLocaleId;

    /** createUserCdプロパティ */
    @Column(length = 100, nullable = false, unique = false)
    public String createUserCd;

    /** createDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp createDate;

    /** recordUserCdプロパティ */
    @Column(length = 100, nullable = false, unique = false)
    public String recordUserCd;

    /** recordDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp recordDate;

    /** iacSchParticipantList関連プロパティ */
    @OneToMany(mappedBy = "iacSchSchedule")
    public List<IacSchParticipant> iacSchParticipantList;
}