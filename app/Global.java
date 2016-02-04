import akka.actor.ActorSystem;
import akka.dispatch.MessageDispatcher;
import akka.dispatch.OnComplete;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.*;
import dto.PropertyListResponse;
import model.Property;
import play.GlobalSettings;
import play.Application;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import play.Logger;
import play.libs.Akka;
import play.libs.F;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http.Request;
import play.mvc.Result;
import repository.PropertyRepository;
import scala.concurrent.Future;
import util.Utils;

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
                        } else {

                            Logger.info("Property" + property.getId() + " exists in DB. Trying to update it");

                            propertyRepository.update(property);
                        }
                    }
                },  application.getWrappedApplication().actorSystem().dispatcher());

            }

        } catch (IOException e) {
            Logger.error("Error while parsing properties.json file", e);
        }


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
