import com.google.inject.Guice;
import com.google.inject.Injector;
import module.MspModule;
import module.PropertyLoader;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;
import play.libs.Akka;
import play.mvc.Action;
import play.mvc.Http.Request;
import scala.concurrent.duration.Duration;
import trigger.ExchangeRatesTriggerJob;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;



/**
 * Global configuration class
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */

public class Global extends GlobalSettings {

    private Injector injector;

    @Override
    public void onStart(Application application) {
        injector = Guice.createInjector(new MspModule());

        //Load new properties to DB
        PropertyLoader propertyLoader = injector.getInstance(PropertyLoader.class);

        propertyLoader.load("conf/properties.json", Play.application().getWrappedApplication().actorSystem().dispatcher());

        //Exchange Rates trigger
        Akka.system().scheduler().schedule(Duration.create(20, TimeUnit.MINUTES), Duration.create(240, TimeUnit.MINUTES),
                injector.getInstance(ExchangeRatesTriggerJob.class), Akka.system().dispatcher());
    }

    public <T> T getControllerInstance(Class<T> aClass) throws Exception {
        return injector.getInstance(aClass);
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Action onRequest(Request request, Method method) {
        Logger.info("//////API method=" + request.method() + " uri=" + request.uri() + " remote-address=" + request.remoteAddress() + " body = {" + request.body().asJson() + "}");

        return super.onRequest(request, method);
    }


}
