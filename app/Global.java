import akka.actor.ActorSystem;
import akka.dispatch.OnComplete;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;
import dto.PropertyListResponse;
import model.BaseEntity;
import model.Currency;
import model.Property;
import model.PropertyCategory;
import play.GlobalSettings;
import play.Application;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import play.Logger;
import play.api.libs.ws.WSClient;
import play.api.libs.ws.WSResponse;
import play.libs.Akka;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http.Request;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;
import trigger.ExchangeRatesTriggerJob;
import util.Utils;
import play.libs.F.Promise;



/**
 * Global configuration class
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */
public class Global extends GlobalSettings {

    private Injector injector;

    @Inject
    public ActorSystem system;

    @Override
    public void onStart(Application application) {
        injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {

                //Automatic binding of repository beans annotated with Singleton
                Set<Class<?>> annotatedClasses = Utils.getAnnotatedClasses("repository", Singleton.class);

                annotatedClasses.forEach(this::bind);

                //Automatic binding of trigger beans annotated with Singleton
                Set<Class<?>> annotatedTriggerClasses = Utils.getAnnotatedClasses("trigger", Singleton.class);

                annotatedTriggerClasses.forEach(this::bind);


            }
        });


        //Load properties from properties.json
        try {

            ObjectMapper mapper = new ObjectMapper();

            PropertyListResponse propertyListResponse = mapper.readValue(new String(Files.readAllBytes(Paths.get("conf/properties.json"))), PropertyListResponse.class);

            PropertyRepository propertyRepository = injector.getInstance(PropertyRepository.class);

            for(Property property: propertyListResponse.getPropertyList()) {

                Future<Property> propertyFuture = propertyRepository.retrieveById(property.getId());

                propertyFuture.onComplete(new OnComplete<Property>() {
                    public void onComplete(Throwable failure, Property result) {
                        if (failure != null) {

                            Logger.info("Property" + property.getId() + " doesn't exist in DB. Trying to insert it");

                            propertyRepository.create(property);
                        }
                    }
                },  application.getWrappedApplication().actorSystem().dispatcher());

            }

        } catch (IOException e) {
            Logger.error("Error while parsing properties.json file", e);
        }


        //Exchange Rates trigger
        Akka.system().scheduler().schedule(Duration.create(5, TimeUnit.SECONDS), Duration.create(240, TimeUnit.MINUTES),
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
