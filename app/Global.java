import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import play.GlobalSettings;
import play.Application;
import java.lang.reflect.Method;
import java.util.Set;

import play.Logger;
import play.mvc.Action;
import play.mvc.Http.Request;
import util.Utils;

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
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

                //Automatic binding of repository beans annotated with Singleton
                Set<Class<?>> annotatedClasses = Utils.getAnnotatedClasses("repository", Singleton.class);

                annotatedClasses.forEach(this::bind);
            }
        });
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
