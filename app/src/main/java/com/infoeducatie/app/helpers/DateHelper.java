package com.infoeducatie.app.helpers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Browsing on 7/11/2015.
 */
public class DateHelper {
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

    /* converts a   time stamp to a simpler string  */
    public static String ISOFormatToString(Timestamp timestamp) {
        if (timestamp == null) return null;
        try {
            return sDateFormat.format(timestamp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
