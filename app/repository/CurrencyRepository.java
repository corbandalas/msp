package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Currency;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Currency CRUD repository
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
@Singleton
public class CurrencyRepository implements BaseCRUDRepository<Currency> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<Currency> create(Currency entity) {

        final Promise<Currency> promise = Futures.promise();

        final String query = "INSERT INTO " + connectionPool.getSchemaName() +
                ".currency(id, displaytext, code, active, euroindex) VALUES ($1, $2, $3, $4, $5)";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getDisplayText(), entity.getCode(),
                entity.getActive(), entity.getEuroIndex()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public Future<Currency> retrieveById(Object id) {

        final Promise<Currency> promise = Futures.promise();

        final String query = "SELECT * FROM" + connectionPool.getSchemaName() + ".currency where id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(
                createCurrency(result.row(0))), promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Currency>> retrieveAll() {

        final Promise<List<Currency>> promise = Futures.promise();

        final String query = "SELECT * FROM" + connectionPool.getSchemaName() + ".currency";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Currency> currencies = new ArrayList<>();
            result.forEach(row->{
                currencies.add(createCurrency(row));
            });
            promise.success(currencies);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Currency> update(Currency entity) {

        final Promise<Currency> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() +
                ".currency SET displaytext=$2, code=$3, active=$4, euroindex=$5 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getDisplayText(), entity.getCode(),
                entity.getActive(), entity.getEuroIndex()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Currency entity) {
        //not required implemented yet
    }

    private Currency createCurrency(Row row) {
        return new Currency(row.getString("id"), row.getShort("code"), row.getString("displaytext"),
                row.getDouble("euroindex"), row.getBoolean("active"));
    }
}
