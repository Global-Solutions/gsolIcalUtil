/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */
package jp.co.gsol.oss.ical.entity;

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
 * IacSchEventParticipantエンティティクラス
 * @author Global Solutions Co., Ltd.
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2014/01/08 16:13:26")
public class IacSchEventParticipant implements Serializable {

    private static final long serialVersionUID = 1L;

    /** eventCdプロパティ */
    @Id
    @Column(length = 20, nullable = false, unique = false)
    public String eventCd;

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

    /** remindDateプロパティ */
    @Column(nullable = true, unique = false)
    public Timestamp remindDate;

    /** remindTimezoneIdプロパティ */
    @Column(length = 128, nullable = true, unique = false)
    public String remindTimezoneId;

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

    /** iacSchEvent関連プロパティ */
    @ManyToOne
    @JoinColumn(name = "event_cd", referencedColumnName = "event_cd")
    public IacSchEvent iacSchEvent;
}
