package repository;

import akka.dispatch.Futures;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Property;
import model.PropertyCategory;
import scala.concurrent.Future;
import scala.concurrent.Promise;


import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


/**
 * Application property CRUD repository
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */

@Singleton
public class PropertyRepository implements BaseCRUDRepository<Property> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<Property> create(Property entity) {

        final Promise<Property> promise = Futures.promise();

        connectionPool.getConnection().query("INSERT INTO " + connectionPool.getSchemaName() + ".property(id, value, description, category) VALUES ($1, $2, $3, $4)",
                asList(
                        entity.getId(), entity.getValue(), entity.getDescription(), entity.getCategory().getValue()),res -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public Future<Property> retrieveById(Object id) {

        final Promise<Property> promise = Futures.promise();

        final String query = "select * from " + connectionPool.getSchemaName() + ".property where id ='" + id + "'" ;

        connectionPool.getConnection().query(query,
                result -> {

                        final Property property = new Property(result.row(0).getString("id"), result.row(0).getString("value"),
                                result.row(0).getString("description"), PropertyCategory.valueOf(result.row(0).getString("category")));

                    promise.success(property);
                },
                promise::failure
        );

        return promise.future();

    }

    @Override
    public Future<List<Property>> retrieveAll() {

        final Promise<List<Property>> promise = Futures.promise();

        final String query = "select * from " + connectionPool.getSchemaName() + ".property";

        connectionPool.getConnection().query(query,
                result -> {
                    final List<Property> properties = new ArrayList<>();

                    result.forEach(row -> {
                        final Property property = new Property(row.getString("id"), row.getString("value"),
                                row.getString("description"), PropertyCategory.valueOf(row.getString("category")));
                        properties.add(property);
                    });

                    promise.success(properties);
                },
                promise::failure
        );

        return promise.future();

    }

    @Override
    public Future<Property> update(Property entity) {

        final Promise<Property> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() + ".property SET value = '" + entity.getValue() +
                "', description = '" + entity.getDescription() + "', category = '" + entity.getCategory() + "' where id = '" + entity.getId() + "'";

        connectionPool.getConnection().query(query,res -> promise.success(entity), promise::failure);

        return promise.future();


    }

    @Override
    public void delete(Property entity) {
        //Not required to implement DELETE method for application property case.
    }

}
