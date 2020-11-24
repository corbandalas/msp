package module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import provider.CardProvider;
import provider.CardProviderVendor;
import sms.SmsGateway;
import util.Utils;

import java.util.Set;

/**
 * Base project configuration module
 *
 * @author corbandalas - created 09.02.2016
 * @since 0.1.0
 */
public class MspModule extends AbstractModule {

    @Override
    protected void configure() {

        //Automatic binding of repository beans annotated with Singleton
        Set<Class<?>> annotatedClasses = Utils.getAnnotatedClasses("repository", Singleton.class);

        annotatedClasses.forEach(this::bind);

        //Automatic binding of trigger beans annotated with Singleton
        Set<Class<?>> annotatedTriggerClasses = Utils.getAnnotatedClasses("trigger", Singleton.class);

        annotatedTriggerClasses.forEach(this::bind);

        //Card provider binding
        Config conf = ConfigFactory.load();

        String cardProviderVendorName = conf.getString("card.provider.vendor");

        Set<Class<?>> annotatedProviderVendorsClasses = Utils.getAnnotatedClasses("provider", CardProviderVendor.class);

        for (Class classValue : annotatedProviderVendorsClasses) {

            CardProviderVendor annotation = (CardProviderVendor) classValue
                    .getAnnotation(CardProviderVendor.class);

            String vendorValue = annotation.value();

            if (vendorValue.equalsIgnoreCase(cardProviderVendorName)) {

                bind(CardProvider.class).to(classValue);

                break;
            }

        }

        bind(PropertyLoader.class);

        bind(SmsGateway.class);

        bind(TokenLoader.class);
    }
}
