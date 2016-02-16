package util;

import org.apache.commons.codec.binary.Base64;

/**
 * Utility for encrypting/decrypting String data with AES-128 algorythm. Key
 * consists from two parts. Result key is obtains by formula
 * RESULT_KEY=KEY_PART_1+KEY_PART_2.
 *
 * @author ra
 */
public final class CryptUtil {

    private static final Base64 theBase64Codec = new Base64();

    public static String encodeString(String str) {
        return new String(theBase64Codec.encode(str.getBytes())).trim();
    }

    public static String decodeString(String str) {
        return new String(theBase64Codec.decode(str.getBytes()));
    }

}









