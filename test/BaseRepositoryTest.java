import akka.actor.ActorSystem;
import org.junit.Before;
import play.api.Application;
import play.api.inject.guice.GuiceApplicationBuilder;
import repository.ConnectionPool;
import scala.concurrent.ExecutionContextExecutor;

/**
 * @author nihilist created 06.02.2016.
 * @since 0.1.0
 */
public class BaseRepositoryTest {

    protected Application application;
    protected ExecutionContextExecutor dispatcher;

    @Before
    public void init() {
        application = new GuiceApplicationBuilder().build();
        dispatcher = application.injector().instanceOf(ActorSystem.class).dispatcher();
        ConnectionPool connectionPool = application.injector().instanceOf(ConnectionPool.class);
        connectionPool.setSchemaName("test_scheme");

    }
}
