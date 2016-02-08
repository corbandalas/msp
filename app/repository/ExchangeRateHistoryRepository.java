package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.ExchangeRateHistory;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;

/**
 * Exchange rate history CRUD repository
 *
 * @author ra - created 05.02.2016
 * @since 0.1.0
 */
@Singleton
public class ExchangeRateHistoryRepository implements BaseCRUDRepository<ExchangeRateHistory> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<ExchangeRateHistory> create(ExchangeRateHistory entity) {
        final Promise<ExchangeRateHistory> promise = Futures.promise();


        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".exchange_rate_history_seq')",
                idResult -> {
                    final Long id = idResult.row(0).getLong(0);

                    final String query = "INSERT INTO " + connectionPool.getSchemaName() +
                            ".exchange_rate_history(id, euro_index, date, currency_id) VALUES ($1, $2, $3, $4);";
                    connectionPool.getConnection().query(query,
                            asList(id, entity.getEuroIndex(), new Timestamp(entity.getDate().getTime()),
                                    entity.getCurrencyId()),
                            result -> {
                                entity.setId(idResult.row(0).getLong(0));
                                promise.success(entity);
                            }, promise::failure);
                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<ExchangeRateHistory> retrieveById(Object id) {
        final Promise<ExchangeRateHistory> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".exchange_rate_history WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id),
                result -> promise.success(createExchangeRateHistory(result.row(0))), promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<ExchangeRateHistory>> retrieveAll() {
        final Promise<List<ExchangeRateHistory>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".exchange_rate_history";
        connectionPool.getConnection().query(query,
                result -> { promise.success(StreamSupport.stream(result.spliterator(), true).map(row -> createExchangeRateHistory(row))
                        .collect(Collectors.toList()));}, promise::failure);

        return promise.future();
    }

    @Override
    public Future<ExchangeRateHistory> update(ExchangeRateHistory entity) {
        final Promise<ExchangeRateHistory> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() +
                ".exchange_rate_history SET euro_index=$2, date=$3, currency_id=$4 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getEuroIndex(), new Timestamp(entity.getDate().getTime()), entity.getCurrencyId()),
                result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(ExchangeRateHistory entity) {
        //not required yet
    }

    private ExchangeRateHistory createExchangeRateHistory(Row row) {
        return new ExchangeRateHistory(row.getLong("id"), row.getBigDecimal("euro_index"), row.getTimestamp("date"),
                row.getString("currency_id"));
    }
}
