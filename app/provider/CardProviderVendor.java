package provider;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Card provider vendor annotation
 *
 * @author corbandalas - created 09.02.2016
 * @since 0.1.0
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CardProviderVendor {

    String value();
}