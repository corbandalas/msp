package util;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
/**
 * Security Utils test
 *
 * @author corbandalas created 11.03.2016.
 * @since 0.2.0
 */
public class SecurityUtilsTest {

    @Test
    public void testGenerateKeyFromArray() {
        String enckey = SecurityUtil.generateKeyFromArray("1", "order", "380632426303", "UA", "5eb61fb9bcd17a7479a339b8b3cf9f9f");
        assertEquals(enckey, "a99fe14a2ddaa1f42a8ae5e6095cefb82357c32f24c97c2b2433e35625d9d57d".toUpperCase());
    }
}
