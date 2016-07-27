package jp.co.gsol.oss.ical.model;

import net.fortuna.ical4j.model.Date;

/**
 * {@link net.fortuna.ical4j.model.Date} with timezone.
 * @author Global Solutions Co., Ltd.
 */
public class DateWithTimeZone extends Date {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 7137072373171373171L;

    /**
     * {@link net.fortuna.ical4j.model.Date} with timezone.
     * @param date date
     * @param tz specified timezone
     */
    public DateWithTimeZone(final java.util.Date date,
            final java.util.TimeZone tz) {
        super(date.getTime(), 1, tz);
    }
}
