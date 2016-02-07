import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import play.api.Application;
import play.api.inject.guice.GuiceApplicationBuilder;
import repository.ConnectionPool;
import scala.concurrent.ExecutionContextExecutor;

import java.io.File;

/**
 * Base class for tests, replace
 *
 * @author nihilist created 06.02.2016.
 * @since 0.1.0
 */
public class BaseRepositoryTest {

    protected Application application;
    protected ExecutionContextExecutor dispatcher;

    @Before
    public void init() {

        Config conf = ConfigFactory.load();

        Flyway flyway = new Flyway();
        flyway.setDataSource(conf.getString("flywayUrl"), conf.getString("database.username"), conf.getString("database.password"));
        flyway.setSchemas(conf.getString("database.test.schema"));
        flyway.setLocations(conf.getString("flywayLocations"));
        flyway.migrate();

        application = new GuiceApplicationBuilder().build();
        dispatcher = application.injector().instanceOf(ActorSystem.class).dispatcher();
        ConnectionPool connectionPool = application.injector().instanceOf(ConnectionPool.class);
        connectionPool.setSchemaName("test_scheme");

    }
}
