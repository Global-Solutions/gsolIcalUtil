/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */
package jp.co.gsol.ical.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * IacSchParticipantエンティティクラス
 * @author Global Solutions Co., Ltd.
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2014/01/08 16:13:26")
public class IacSchParticipant implements Serializable {

    private static final long serialVersionUID = 1L;

    /** scheduleCdプロパティ */
    @Id
    @Column(length = 20, nullable = false, unique = false)
    public String scheduleCd;

    /** userCdプロパティ */
    @Id
    @Column(length = 100, nullable = false, unique = false)
    public String userCd;

    /** startDateNumプロパティ */
    @Column(precision = 12, nullable = false, unique = false)
    public BigDecimal startDateNum;

    /** endDateNumプロパティ */
    @Column(precision = 12, nullable = false, unique = false)
    public BigDecimal endDateNum;

    /** reminder1NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder1NoticeFlag;

    /** reminder2NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder2NoticeFlag;

    /** reminder3NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder3NoticeFlag;

    /** reminder4NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder4NoticeFlag;

    /** reminder5NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder5NoticeFlag;

    /** reminder6NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder6NoticeFlag;

    /** reminder7NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder7NoticeFlag;

    /** reminder8NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder8NoticeFlag;

    /** reminder9NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder9NoticeFlag;

    /** reminder10NoticeFlagプロパティ */
    @Column(precision = 1, nullable = true, unique = false)
    public BigDecimal reminder10NoticeFlag;

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

    /** iacSchSchedule関連プロパティ */
    @ManyToOne
    @JoinColumn(name = "schedule_cd", referencedColumnName = "schedule_cd")
    public IacSchSchedule iacSchSchedule;
}