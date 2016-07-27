/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */
package jp.co.gsol.oss.ical.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * IcalUpdateQueueエンティティクラス
 * @author Global Solutions Co., Ltd.
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2014/01/08 16:13:26")
public class IcalUpdateQueue implements Serializable {

    private static final long serialVersionUID = 1L;

    /** userCdプロパティ */
    @Id
    @Column(length = 100, nullable = false, unique = true)
    public String userCd;

    /** lastUpdateTimeプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp lastUpdateTime;

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
}