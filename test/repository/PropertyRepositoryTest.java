package repository;

import akka.dispatch.Futures;
import model.Operation;
import model.Property;
import model.PropertyCategory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Holds property repository tests
 *
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
public class PropertyRepositoryTest extends BaseRepositoryTest {

    private PropertyRepository propertyRepository;

    @Before
    public void setup() {
        propertyRepository = application.injector().instanceOf(PropertyRepository.class);
    }

    @Test
    public void create() throws Exception {
        String id = "msp.test";
        final String value = "test property value";
        assertNotNull(Await.result(propertyRepository.create(new Property(id, value, "test property description",
                PropertyCategory.EXCHANGE_RATES_INTEGRATION)), Duration.apply(defaultDelay)));
        final Property property = Await.result(propertyRepository.retrieveById(id), Duration.apply(defaultDelay));
        assertEquals(value, property.getValue());
    }

    @Test
    public void update() throws Exception {
        final Property property = new Property("msp.test", "test property value", "test property description",
                PropertyCategory.EXCHANGE_RATES_INTEGRATION);
        assertNotNull(Await.result(propertyRepository.create(property), Duration.apply(defaultDelay)));

        final String value = "new property value";
        property.setValue(value);
        assertNotNull(Await.result(propertyRepository.update(property), Duration.apply(defaultDelay)));

        final Property propertyById = Await.result(propertyRepository.retrieveById(property.getId()), Duration.apply(defaultDelay));
        assertEquals(value, propertyById.getValue());
    }

    @Test
    public void retrieveById() throws Exception {
        String id = "test.property";
        final String value = "test property value";
        assertNotNull(Await.result(propertyRepository.create(new Property(id, value, "test property description",
                PropertyCategory.EXCHANGE_RATES_INTEGRATION)), Duration.apply(defaultDelay)));
        final Property property = Await.result(propertyRepository.retrieveById(id), Duration.apply(defaultDelay));
        assertEquals(value, property.getValue());
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(propertyRepository.create(new Property("test.property.one", "test property 1 value",
                "test property 1 description", PropertyCategory.EXCHANGE_RATES_INTEGRATION)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(propertyRepository.create(new Property("test.property.two", "test property 1 value",
                "test property 1 description", PropertyCategory.EXCHANGE_RATES_INTEGRATION)), Duration.apply(defaultDelay)));

        final List<Property> properties = Await.result(propertyRepository.retrieveAll(), Duration.apply(defaultDelay));
        assertEquals(2, properties.size());
    }

    @After
    public void clean() {
        final Promise<Property> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(defaultDelay));
        } catch (Exception e) {
            Logger.error("Error", e);
        }
    }
}
