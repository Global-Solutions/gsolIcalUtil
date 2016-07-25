/*
 * Copyright 2013-2014 Global Solutions Co., Ltd.
 * All rights reserved.
 */

package jp.co.gsol.ical.entity;

import javax.annotation.Generated;
import jp.co.gsol.ical.entity.IacSchEventNames._IacSchEventNames;
import jp.co.gsol.ical.entity.IacSchEventParticipantNames._IacSchEventParticipantNames;
import jp.co.gsol.ical.entity.IacSchParticipantNames._IacSchParticipantNames;
import jp.co.gsol.ical.entity.IacSchScheduleNames._IacSchScheduleNames;
import jp.co.gsol.ical.entity.IcalUpdateQueueNames._IcalUpdateQueueNames;
import jp.co.gsol.ical.entity.IcalUserIcsRelNames._IcalUserIcsRelNames;

/**
 * 名前クラスの集約です。
 * 
 * @author Global Solutions Co., Ltd.
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2014/01/08 16:13:44")
public class Names {

    /**
     * {@link IacSchEvent}の名前クラスを返します。
     * 
     * @return IacSchEventの名前クラス
     */
    public static _IacSchEventNames iacSchEvent() {
        return new _IacSchEventNames();
    }

    /**
     * {@link IacSchEventParticipant}の名前クラスを返します。
     * 
     * @return IacSchEventParticipantの名前クラス
     */
    public static _IacSchEventParticipantNames iacSchEventParticipant() {
        return new _IacSchEventParticipantNames();
    }

    /**
     * {@link IacSchParticipant}の名前クラスを返します。
     * 
     * @return IacSchParticipantの名前クラス
     */
    public static _IacSchParticipantNames iacSchParticipant() {
        return new _IacSchParticipantNames();
    }

    /**
     * {@link IacSchSchedule}の名前クラスを返します。
     * 
     * @return IacSchScheduleの名前クラス
     */
    public static _IacSchScheduleNames iacSchSchedule() {
        return new _IacSchScheduleNames();
    }

    /**
     * {@link IcalUpdateQueue}の名前クラスを返します。
     * 
     * @return IcalUpdateQueueの名前クラス
     */
    public static _IcalUpdateQueueNames icalUpdateQueue() {
        return new _IcalUpdateQueueNames();
    }

    /**
     * {@link IcalUserIcsRel}の名前クラスを返します。
     * 
     * @return IcalUserIcsRelの名前クラス
     */
    public static _IcalUserIcsRelNames icalUserIcsRel() {
        return new _IcalUserIcsRelNames();
    }
}