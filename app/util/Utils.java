package util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import exception.MspException;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import play.Logger;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Class to store util methods for common usage across the project
 *
 * @author corbandalas - created 02.02.2016
 * @since 0.1.0
 */
public final class Utils {

    /**
     * Constant for timestamp {@value}
     */
    public static final String DEFAULT_DATE_TIME_FORMAT
            = "yyyy-MM-dd HH:mm:ss";

    /**
     * Constant for date format {@value}
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    private static final ThreadLocal<DateFormat> DATE_FORMAT
            = new ThreadLocal<DateFormat>() {
        /**
         * @see java.lang.ThreadLocal#initialValue()
         */
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        }
    };

    /**
     * Thread safe date time format
     */
    private static final ThreadLocal<DateFormat> DATE_TIME_FORMAT
            = new ThreadLocal<DateFormat>() {
        /**
         * @see java.lang.ThreadLocal#initialValue()
         */
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(DEFAULT_DATE_TIME_FORMAT);
        }
    };

    private static String[] theSortedLocales;

    /**
     * Constructor.
     *
     * @since 0.1.0
     */
    private Utils() {
    }

    /**
     * Return a sorted list of locales supported by Java
     *
     * @return a String array of sorted locales
     * @since 0.1.0
     */
    public static String[] getLocales() {
        if (theSortedLocales == null) {
            Locale locales[] = Locale.getAvailableLocales();

            theSortedLocales = new String[locales.length];

            int i = 0;
            for (Locale locale : locales) {
                theSortedLocales[i++] = locale.toString();
            }

            Arrays.sort(theSortedLocales);
        }

        return theSortedLocales;
    }

    /**
     * Return the current / default locale
     *
     * @return String representation of the current locale
     * @since 0.1.0
     */
    public static String getDefaultLocale() {
        return Locale.getDefault().toString();
    }

    /**
     * Return a date formated in yyyy-MM-dd format.
     *
     * @param date to format
     * @return the formatted date.
     */
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return DATE_FORMAT.get().format(date);
    }

    /**
     * Parse the supplied date.
     *
     * @param date
     * @return a date if able to parse the string.
     * @throws ParseException if unable to parse the date.
     */
    public static Date parseDate(String date) throws ParseException {
        return DATE_FORMAT.get().parse(date);
    }

    /**
     * The supplied date is formatted using the yyyy-MM-dd HH:mm:ss formatting pattern
     *
     * @param date the date to format
     * @return a formatted date and time string.
     * @since 1.0
     */
    public static String formatDateTime(Date date) {
        if (date == null) {
            return "";
        }
        return DATE_TIME_FORMAT.get().format(date);
    }

    /**
     * The supplied date is formatted using the yyyy-MM-dd HH:mm:ss formatting pattern
     *
     * @param millis a time represented as the number of milliseconds, between a point in time and midnight, January 1,
     *               1970 UTC.
     * @return a formatted date and time string.
     * @since 1.0
     */
    public static String formatDateTime(long millis) {
        return formatDateTime(new Date(millis));
    }

    /**
     * Dynamically extend the System Class Loader with the given path or jar file
     *
     * @param path to extend the class path by
     * @throws MspException if invalid path
     * @since 0.1.0
     */
    public static void extendClassPath(String path)
            throws MspException {
        final File filePath = new File(path);

        final ClassLoader cl = ClassLoader.getSystemClassLoader();

        if (cl instanceof URLClassLoader) {
            final URLClassLoader ul = (URLClassLoader) cl;

            final Class<?>[] paraTypes = new Class[1];
            paraTypes[0] = URL.class;

            try {
                final Method method
                        = URLClassLoader.class.getDeclaredMethod("addURL", paraTypes);

                method.setAccessible(true);
                final Object[] args = new Object[1];

                args[0] = filePath.toURI().toURL();
                method.invoke(ul, args);
            } catch (final Exception ex) {
                throw new MspException("Unable to extend class path ", ex);
            }
        } else {
            throw new MspException(
                    "System Class loader is not a URL class loader");
        }
    }

    /**
     * Scans package for annotated classes with specified annotation type.
     *
     * @param packageName    package name
     * @param annotatedClass Annotation class
     * @return a set of annotated classes
     * @since 0.1.0
     */
    public static Set<Class<?>> getAnnotatedClasses(String packageName, Class<? extends Annotation> annotatedClass) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addUrls(ClasspathHelper.forPackage(packageName));
        builder.addScanners(new TypeAnnotationsScanner());
        Reflections reflections = new Reflections(builder);

        return reflections.getTypesAnnotatedWith((Class<? extends Annotation>) annotatedClass);
    }

    /**
     * Scan the given package for methods with the given annotation.
     *
     * @param packageName to search
     * @param annotation  to look for
     * @return a set of methods with the annotation
     * @since 0.1.0
     */
    public static Set<Method> getAnnotatedMethods(String packageName, Class<? extends Annotation> annotation) {
        ConfigurationBuilder builder = new ConfigurationBuilder();
        builder.addUrls(ClasspathHelper.forPackage(packageName));
        builder.addScanners(new MethodAnnotationsScanner());
        Reflections reflections = new Reflections(builder);

        return reflections.getMethodsAnnotatedWith(annotation);
    }

    /**
     * Allows to validate mobile phone number
     *
     * @param phone
     * @param countryCode
     * @return
     * @since 0.3.0
     */
    public static Boolean isValidPhoneNumber(String phone, String countryCode) {
        boolean validNumber = false;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneUtil.parse(phone, countryCode);
            validNumber = phoneUtil.isValidNumber(phoneNumber);
        } catch (NumberParseException e) {
            Logger.error("Phone number validation error", e);
        }

        if (!phone.matches("^\\d+$")) {
            validNumber = false;
        }

        return validNumber;
    }

    /**
     * Return masked card number with specified mask
     *
     * @param cardNumber
     * @param mask
     * @return masked credit card number
     */
    public static String maskCardNumber(String cardNumber, String mask) {

        if (!StringUtils.isNumeric(cardNumber)) {
            return cardNumber;
        }

        // format the number
        int index = 0;
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c == '#') {
                maskedNumber.append(cardNumber.charAt(index));
                index++;
            } else if (c == 'x') {
                maskedNumber.append(c);
                index++;
            } else {
                maskedNumber.append(c);
            }
        }

        // return the masked number
        return maskedNumber.toString();
    }


    /**
     * Return masked card number with predefined default mask
     *
     * @param cardNumber
     * @return
     */
    public static String maskCardNumber(String cardNumber) {

        return maskCardNumber(cardNumber, "#####xxxxxx#####");
    }


}
