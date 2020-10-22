package util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.ning.http.client.AsyncHttpClient;
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

    public static final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

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


    public static String trasliterateDanish(String source) {


//        Æ = Ae
//        æ = ae
//        Ø = Oe
//        ø = oe
//        Å = Aa
//        å = aa

        source = StringUtils.replace(source, "Æ", "Ae");
        source = StringUtils.replace(source, "æ", "ae");
        source = StringUtils.replace(source, "Ø", "Oe");
        source = StringUtils.replace(source, "ø", "o");
        source = StringUtils.replace(source, "Å", "Aa");
        source = StringUtils.replace(source, "å", "aa");

        source = StringUtils.replace(source, "É", "E");
        source = StringUtils.replace(source, "é", "e");
        source = StringUtils.replace(source, "Â", "A");
        source = StringUtils.replace(source, "â", "a");
        source = StringUtils.replace(source, "Ê", "E");
        source = StringUtils.replace(source, "ê", "e");
        source = StringUtils.replace(source, "Î", "I");
        source = StringUtils.replace(source, "î", "i");
        source = StringUtils.replace(source, "Ô", "O");
        source = StringUtils.replace(source, "ô", "o");
        source = StringUtils.replace(source, "Û", "U");
        source = StringUtils.replace(source, "û", "u");
        source = StringUtils.replace(source, "À", "A");
        source = StringUtils.replace(source, "à", "a");
        source = StringUtils.replace(source, "È", "E");
        source = StringUtils.replace(source, "è", "e");

        source = StringUtils.replace(source, "Ù", "U");
        source = StringUtils.replace(source, "ù", "u");
        source = StringUtils.replace(source, "Ë", "E");
        source = StringUtils.replace(source, "ë", "e");

        source = StringUtils.replace(source, "Ï", "I");
        source = StringUtils.replace(source, "ï", "i");
        source = StringUtils.replace(source, "Ü", "U");
        source = StringUtils.replace(source, "ü", "u");

        source = StringUtils.replace(source, "Ÿ", "Y");
        source = StringUtils.replace(source, "ÿ", "y");
        source = StringUtils.replace(source, "Ç", "C");
        source = StringUtils.replace(source, "ç", "c");

        source = StringUtils.replace(source, "Ä", "A");
        source = StringUtils.replace(source, "ä", "a");
        source = StringUtils.replace(source, "Ö", "O");
        source = StringUtils.replace(source, "ö", "o");


        source = StringUtils.replace(source, "ẞ", "Ss");
        source = StringUtils.replace(source, "ß", "ss");
        source = StringUtils.replace(source, "Á", "A");
        source = StringUtils.replace(source, "á", "a");

        source = StringUtils.replace(source, "Ð", "D");
        source = StringUtils.replace(source, "ð", "d");
        source = StringUtils.replace(source, "Ó", "O");
        source = StringUtils.replace(source, "ó", "o");

        source = StringUtils.replace(source, "Ú", "U");
        source = StringUtils.replace(source, "ú", "u");
        source = StringUtils.replace(source, "Ý", "Y");
        source = StringUtils.replace(source, "ý", "y");

        source = StringUtils.replace(source, "Ñ", "N");
        source = StringUtils.replace(source, "ñ", "n");
        source = StringUtils.replace(source, "Á", "A");
        source = StringUtils.replace(source, "á", "a");

        source = StringUtils.replace(source, "Ã", "A");
        source = StringUtils.replace(source, "ã", "a");
        source = StringUtils.replace(source, "Í", "I");
        source = StringUtils.replace(source, "í", "i");

        source = StringUtils.replace(source, "Õ", "O");
        source = StringUtils.replace(source, "õ", "o");
        source = StringUtils.replace(source, "Ğ", "G");
        source = StringUtils.replace(source, "ğ", "g");

        source = StringUtils.replace(source, "Ş", "S");
        source = StringUtils.replace(source, "ş", "s");
        source = StringUtils.replace(source, "ă", "a");
        source = StringUtils.replace(source, "Ă", "A");

        source = StringUtils.replace(source, "Ą", "A");
        source = StringUtils.replace(source, "ą", "a");
        source = StringUtils.replace(source, "Č", "C");
        source = StringUtils.replace(source, "č", "c");

        source = StringUtils.replace(source, "Ę", "E");
        source = StringUtils.replace(source, "ę", "e");
        source = StringUtils.replace(source, "Ē", "E");
        source = StringUtils.replace(source, "ē", "e");

        source = StringUtils.replace(source, "Ė", "E");
        source = StringUtils.replace(source, "ė", "e");
        source = StringUtils.replace(source, "Į", "I");
        source = StringUtils.replace(source, "į", "i");

        source = StringUtils.replace(source, "Š", "S");
        source = StringUtils.replace(source, "š", "s");
        source = StringUtils.replace(source, "Ų", "U");
        source = StringUtils.replace(source, "ų", "u");

        source = StringUtils.replace(source, "Ž", "Z");
        source = StringUtils.replace(source, "ž", "z");
        source = StringUtils.replace(source, "Ā", "A");
        source = StringUtils.replace(source, "ā", "a");

        source = StringUtils.replace(source, "Ģ", "G");
        source = StringUtils.replace(source, "ģ", "g");
        source = StringUtils.replace(source, "Ī", "I");
        source = StringUtils.replace(source, "ī", "i");

        source = StringUtils.replace(source, "Ķ", "K");
        source = StringUtils.replace(source, "ķ", "k");
        source = StringUtils.replace(source, "Ļ", "L");
        source = StringUtils.replace(source, "ļ", "l");

        source = StringUtils.replace(source, "Ņ", "N");
        source = StringUtils.replace(source, "ņ", "n");

        return source;


    }


}
