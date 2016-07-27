package jp.co.gsol.oss.ical.model;

import java.util.List;
import java.util.TimeZone;

import com.google.common.collect.ImmutableList;

/**
 * Calendar コンテナクラス.
 * @author Global Solutions Co., Ltd.
 */
public class ICalendar {
    /**
     * icsファイルを出力するアプリケーションの情報.
     */
    private final String prodId;

    /**
     * カレンダー名.
     */
    private final String calendarName;

    /**
     * タイムゾーン.
     */
    private final TimeZone timeZone;

    /**
     * イベントのリスト.
     */
    private final ImmutableList<ICalEvent> eventList;

    /**
     * Calendar コンテナクラス.
     * @param id icsファイルを出力するアプリケーションの情報
     * @param name カレンダー名
     * @param tz タイムゾーン
     * @param events イベントのリスト
     */
    public ICalendar(final String id, final String name,
            final TimeZone tz,
            final List<ICalEvent> events) {
        this.prodId = id;
        this.calendarName = name;
        this.timeZone = tz;
        this.eventList = ImmutableList.copyOf(events);
    }

    /**
     * {@link #prodId}.
     * @return prodId
     */
    public final String prodId() {
        return prodId;
    }

    /**
     * {@link #calendarName}.
     * @return calendarName
     */
    public final String calendarName() {
        return calendarName;
    }

    /**
     * {@link #timeZone}.
     * @return timeZone
     */
    public final TimeZone timeZone() {
        return timeZone;
    }

    /**
     * {@link #eventList}.
     * @return eventList
     */
    public final ImmutableList<ICalEvent> eventList() {
        return eventList;
    }
}
