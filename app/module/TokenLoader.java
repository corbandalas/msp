package module;

import akka.dispatch.OnComplete;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import scala.concurrent.ExecutionContextExecutor;
import services.AccomplishService;

/**
 * Application accomplish oauth token loader
 *
 * @author corbandalas - created 24.11.2020
 * @since 0.1.0
 */
public class TokenLoader {

    @Inject
    private AccomplishService accomplishService;

    public void load(ExecutionContextExecutor executionContextExecutor) {

        try {

            Config conf = ConfigFactory.load();
            String list = conf.getString("partners.list");

            boolean needObtainToken = conf.getBoolean("oauth.token.obtain");

            Logger.info("TokenLoader is working....needObtainToken = " + needObtainToken);

            if (needObtainToken) {
                String[] accounts = StringUtils.split(list, ",");

                for (String account : accounts) {
                    AccomplishService.AccomplishSettings accomplishSettings = accomplishService.getSettingsForPartner(account).get(2000);
                    accomplishService.getOauth(accomplishSettings).onComplete(new OnComplete<String>() {
                        public void onComplete(Throwable failure, String result) {


                            Logger.info("Oauth token for partner " + account + " was loaded from Accomplish: " + result);

                        }
                    }, executionContextExecutor);
                }
            }

        } catch (Exception e) {
            Logger.error("Error while getting token", e);
        }
    }
}
