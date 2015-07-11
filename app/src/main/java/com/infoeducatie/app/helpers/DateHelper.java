package com.infoeducatie.app.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Browsing on 7/11/2015.
 */
public class DateHelper {
    /* converts a iso time stamp to a simpler string  */
    public static String ISOFormatToString(String iso) {
        if (iso == null) return null;
        try {
            Calendar calendar = ISO8601.toCalendar(iso);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            return format.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
