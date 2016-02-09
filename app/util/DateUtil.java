package util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Date helper methods
 *
 * @author corbandalas - created 09.02.2016
 * @since 0.1.0
 *
 */
public class DateUtil {

    /**
     * Constant for date format {@value}
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    private static final ThreadLocal<DateFormat> threadLocalDateFormat
            = new ThreadLocal<DateFormat>() {
        /**
         * @see java.lang.ThreadLocal#initialValue()
         */
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.ENGLISH);
        }
    };


    /**
     * Return a date formated in yyyy-MM-dd format.
     *
     * @param date    to format
     * @param pattern format pattern
     * @return the formatted date.
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) threadLocalDateFormat.get();

        if (StringUtils.isNotBlank(pattern)) {
            simpleDateFormat.applyPattern(pattern);
        }

        return threadLocalDateFormat.get().format(date);
    }

    /**
     * Parse date.
     *
     * @param datePresentation the date presentation
     * @param pattern          the pattern
     * @return the date
     * @throws ParseException the parse exception
     */
    public static Date parse(String datePresentation, String pattern) throws ParseException {
        if (!StringUtils.isNotBlank(datePresentation)) {
            return null;
        }

        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) threadLocalDateFormat.get();

        if (StringUtils.isNotBlank(pattern)) {
            simpleDateFormat.applyPattern(pattern);
        }

        return threadLocalDateFormat.get().parse(datePresentation);
    }

}
