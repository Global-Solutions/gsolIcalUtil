package jp.co.gsol.oss.ical.data;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.PropertyList;
import net.fortuna.ical4j.model.TimeZone;
import net.fortuna.ical4j.model.TimeZoneRegistryFactory;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.parameter.TzId;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.Description;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import net.fortuna.ical4j.model.property.LastModified;
import net.fortuna.ical4j.model.property.Location;
import net.fortuna.ical4j.model.property.Method;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Summary;
import net.fortuna.ical4j.model.property.Uid;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.model.property.XProperty;

import jp.co.gsol.oss.ical.exception.ICalException;
import jp.co.gsol.oss.ical.model.DateWithTimeZone;
import jp.co.gsol.oss.ical.model.ICalEvent;
import jp.co.gsol.oss.ical.model.ICalendar;

/**
 * {@link ICalendar}を{@link Calendar}に変換.
 * @author Global Solutions Co., Ltd.
 */
public class CalendarConverter {

    /**
     * ical4jのCalendar.
     */
    private final Calendar ical4jCalendar;

    /**
     * 各イベントで使用されているタイムゾーンのマップ.
     */
    private final Map<String, TimeZone> timeZoneMap;

    /**
     * コンストラクタ.
     * ICalendarをical4jのCalendarに変換.
     * @param iCalendar 変換するカレンダー
     */
    public CalendarConverter(final ICalendar iCalendar) {
        // カレンダー作成
        final Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId(iCalendar.prodId()));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);
        calendar.getProperties().add(Method.PUBLISH);

        calendar.getProperties().add(
                new XProperty("X-WR-CALNAME", iCalendar.calendarName()));
        calendar.getProperties().add(
                new XProperty("X-WR-TIMEZONE", iCalendar.timeZone().getID()));

        timeZoneMap = new HashMap<>();
        List<VEvent> eventList = new ArrayList<>();
        for (ICalEvent iCalEvent : iCalendar.eventList()) {
            VEvent vEvent = convertEvent(iCalEvent);
            eventList.add(vEvent);
        }
        for (TimeZone timeZone : timeZoneMap.values()) {
            calendar.getComponents().add(timeZone.getVTimeZone());
        }
        for (VEvent event : eventList) {
            calendar.getComponents().add(event);
        }

        ical4jCalendar = calendar;
    }

    /**
     * icsファイルの書き出し.
     * @param writer 出力先
     * @throws IOException ファイルの書き出しに失敗した場合
     * @throws ICalException カレンダーの形式が不正な場合
     */
    public final void write(final Writer writer)
            throws ICalException , IOException {
        try {
            //ical4jのバージョンが古い(i.0.3)とエラーになるのでCalendarOutputterのvalidatingはfalseに
            final CalendarOutputter outputter = new CalendarOutputter(false);
            outputter.output(ical4jCalendar, writer);
        } catch (ValidationException e) {
            throw new ICalException(e);
        }
    }

    /**
     * iCalEventをVEventに変換.
     * @param iCalEvent 変換前のイベント
     * @return 変換後のイベント
     */
    private VEvent convertEvent(final ICalEvent iCalEvent) {
        final TimeZone startTZ = getTimeZone(
                iCalEvent.startDate().getTimeZone().getID());
        final TimeZone endTZ = getTimeZone(
                iCalEvent.endDate().getTimeZone().getID());
        DtStart dtStart = new DtStart();
        DtEnd dtEnd = new DtEnd();
        if (iCalEvent.wholeDay()) {
            // イベントの場合
            final Date start = new DateWithTimeZone(
                    iCalEvent.startDate().getDate(),
                    iCalEvent.startDate().getTimeZone());
            final Date end = new DateWithTimeZone(
                    iCalEvent.endDate().getDate(),
                    iCalEvent.endDate().getTimeZone());
            dtStart = new DtStart(start);
            dtStart.getParameters().add(new TzId(startTZ.getID()));
            dtEnd = new DtEnd(end);
            dtEnd.getParameters().add(new TzId(endTZ.getID()));
        } else {
            // スケジュールの場合
            final DateTime start =
                    new DateTime(iCalEvent.startDate().getDate());
            start.setTimeZone(startTZ);
            final DateTime end =
                    new DateTime(iCalEvent.endDate().getDate());
            end.setTimeZone(endTZ);
            dtStart = new DtStart(start);
            dtEnd = new DtEnd(end);
        }
        final VEvent vEvent = new VEvent();
        final PropertyList pList = vEvent.getProperties();
        pList.add(new Uid(iCalEvent.id()));
        pList.add(new Summary(iCalEvent.summary()));
        pList.add(dtStart);
        pList.add(dtEnd);
        pList.add(new Description(iCalEvent.description()));
        pList.add(new Location(iCalEvent.location()));
        pList.add(new LastModified(new DateTime(iCalEvent.lastModified()
                .getDate().getTime())));

        return vEvent;
    }

    /**
     * TimeZoneの取得.
     * @param id タイムゾーンのID
     * @return TimeZone
     */
    private TimeZone getTimeZone(final String id) {
        TimeZone timeZone = timeZoneMap.get(id);
        if (timeZone == null) {
            timeZone = TimeZoneRegistryFactory.getInstance().createRegistry()
                    .getTimeZone(id);
            timeZoneMap.put(id, timeZone);
        }
        return timeZone;
    }
}
