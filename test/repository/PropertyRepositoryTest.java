package repository;

import model.Property;
import model.PropertyCategory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.Await;
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
                PropertyCategory.EXCHANGE_RATES_INTEGRATION)), Duration.apply("1000 ms")));
        final Property property = Await.result(propertyRepository.retrieveById(id), Duration.apply("1000 ms"));
        assertEquals(value, property.getValue());
    }

    @Test
    public void update() throws Exception {
        final Property property = new Property("msp.test", "test property value", "test property description",
                PropertyCategory.EXCHANGE_RATES_INTEGRATION);
        assertNotNull(Await.result(propertyRepository.create(property), Duration.apply("1000 ms")));

        final String value = "new property value";
        property.setValue(value);
        assertNotNull(Await.result(propertyRepository.update(property), Duration.apply("1000 ms")));

        final Property propertyById = Await.result(propertyRepository.retrieveById(property.getId()), Duration.apply("1000 ms"));
        assertEquals(value, propertyById.getValue());
    }

    @Test
    public void retrieveById() throws Exception {
        String id = "test.property";
        final String value = "test property value";
        assertNotNull(Await.result(propertyRepository.create(new Property(id, value, "test property description",
                PropertyCategory.EXCHANGE_RATES_INTEGRATION)), Duration.apply("1000 ms")));
        final Property property = Await.result(propertyRepository.retrieveById(id), Duration.apply("1000 ms"));
        assertEquals(value, property.getValue());
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(propertyRepository.create(new Property("test.property.one", "test property 1 value",
                "test property 1 description", PropertyCategory.EXCHANGE_RATES_INTEGRATION)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(propertyRepository.create(new Property("test.property.two", "test property 1 value",
                "test property 1 description", PropertyCategory.EXCHANGE_RATES_INTEGRATION)), Duration.apply("1000 ms")));

        final List<Property> properties = Await.result(propertyRepository.retrieveAll(), Duration.apply("1000 ms"));
        assertEquals(2, properties.size());
    }

    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property", resultSet -> {
        }, Throwable::printStackTrace);
    }
}
