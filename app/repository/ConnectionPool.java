package repository;

import com.github.pgasync.ConnectionPoolBuilder;
import com.github.pgasync.Db;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


/**
 * DB connection pool using Async PostgreSQL driver
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */

@Singleton
public class ConnectionPool {

    private Db db;

    private String schemaName;


    @Inject
    public void onLoad() {

        Config conf = ConfigFactory.load();


        db = new ConnectionPoolBuilder()
                .hostname(conf.getString("database.host"))
                .port(Integer.parseInt(conf.getString("database.port")))
                .database(conf.getString("database.name"))
                .username(conf.getString("database.username"))
                .password(conf.getString("database.password"))
                .poolSize(Integer.parseInt(conf.getString("database.pool.size")))
                .converters(new BooleanConverter())
                .build();

        schemaName = conf.getString("database.schema");
    }

    public void close() throws Exception {
        db.close();
    }


    public Db getConnection() {
        return db;
    }


    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }
}
