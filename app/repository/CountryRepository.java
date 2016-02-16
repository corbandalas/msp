package repository;

import akka.dispatch.Futures;
import com.github.pgasync.ResultSet;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Card;
import model.Country;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Country CRUD repository
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
@Singleton
public class CountryRepository implements BaseCRUDRepository<Country> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<Country> create(Country entity) {

        final Promise<Country> promise = Futures.promise();

        final String query = "INSERT INTO " + connectionPool.getSchemaName() +
                ".country(id, name, phonecode, active, currency_id) VALUES ($1, $2, $3, $4, $5)";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getName(), entity.getPhoneCode(),
                entity.getActive(), entity.getCurrencyId()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public Future<Optional<Country>> retrieveById(Object id) {

        final Promise<Optional<Country>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".country WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createEntity(result)), promise::failure);

        return promise.future();
    }

    public Future<Boolean> checkCountry(Object id) {

        final Promise<Boolean> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".country WHERE id=$1 and active = true";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(result.size() > 0), promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Country>> retrieveAll() {

        final Promise<List<Country>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".country";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Country> countries = new ArrayList<>();
            result.forEach(row -> countries.add(createEntity(row)));
            promise.success(countries);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Country>> retrieveByActive(Boolean active) {
        final Promise<List<Country>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".country WHERE active=$1";
        connectionPool.getConnection().query(query, asList(active), result -> {
            final ArrayList<Country> countries = new ArrayList<>();
            result.forEach(row -> countries.add(createEntity(row)));
            promise.success(countries);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Country> update(Country entity) {

        final Promise<Country> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() +
                ".country SET name=$2, phonecode=$3, active=$4, currency_id=$5 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getName(), entity.getPhoneCode(),
                entity.getActive(), entity.getCurrencyId()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Country entity) {
        //Not required yet
    }

    public Country createEntity(Row row) {

        return new Country(row.getString("id"), row.getString("name"), row.getShort("phonecode"), row.getBoolean("active"),
                row.getString("currency_id"), row.getString("code"));
    }


}
