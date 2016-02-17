package module;

import akka.dispatch.OnComplete;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import dto.PropertyListResponse;
import model.Property;
import play.Logger;
import play.Play;
import repository.PropertyRepository;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.Future;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * Application properties loader
 *
 * @author corbandalas - created 09.02.2016
 * @since 0.1.0
 */
public class PropertyLoader {

    @Inject
    private PropertyRepository propertyRepository;

    public void load(String url, ExecutionContextExecutor executionContextExecutor) {

        //Load properties from properties.json
        try {

            ObjectMapper mapper = new ObjectMapper();

            PropertyListResponse propertyListResponse = mapper.readValue(new String(Files.readAllBytes(Paths.get(url))), PropertyListResponse.class);

            for (Property property : propertyListResponse.getPropertyList()) {

                Future<Optional<Property>> propertyFuture = propertyRepository.retrieveById(property.getId());

                propertyFuture.onComplete(new OnComplete<Optional<Property>>() {
                    public void onComplete(Throwable failure, Optional<Property> result) {

                        if (!result.isPresent()) {

                            Logger.info("Property " + property.getId() + " doesn't exist in DB. Trying to insert it");

                            propertyRepository.create(property);

                        }


                    }
                }, executionContextExecutor);

            }

        } catch (IOException e) {
            Logger.error("Error while parsing properties.json file", e);
        }

    }
}
