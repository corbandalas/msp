package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SecurityUtils cls for MD5 based checksum calculation
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 *
 */

public class SecurityUtil {

    public static String generateKeyFromArray(String... params) {
        try {
            byte byteHash[];
            final MessageDigest md5 = MessageDigest.getInstance("SHA-256");

            final StringBuilder buf = new StringBuilder();
            for (final String item : params) {
                buf.append(item);
            }

            md5.update(buf.toString().getBytes());
            byteHash = md5.digest();
            md5.reset();

            return toHexString(byteHash);
        } catch (final NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static String generateKeyFromArrayMD5(String... params) {
        try {
            byte byteHash[];
            final MessageDigest md5 = MessageDigest.getInstance("md5");

            final StringBuffer buf = new StringBuffer();
            for (final String item : params) {
                buf.append(item);
            }

            md5.update(buf.toString().getBytes());
            byteHash = md5.digest();
            md5.reset();

            return toHexString(byteHash);
        } catch (final NoSuchAlgorithmException e) {
        }
        return null;
    }

    private static String toHexString(final byte[] array) {
        final StringBuilder sb = new StringBuilder();

        for (final byte element : array) {
            final String hex = "0" + Integer.toHexString(element);
            final String end = hex.substring(hex.length() - 2);
            sb.append(end.toUpperCase());
        }
        return sb.toString();
    }
}
