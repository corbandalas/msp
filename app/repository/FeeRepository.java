package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Fee;
import model.enums.OperationType;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Fee repository
 *
 * @author corbandalas - created 08.05.2017
 * @since 0.4.0
 */
@Singleton
public class FeeRepository implements BaseCRUDRepository<Fee> {

    @Inject
    private ConnectionPool connectionPool;


    @Override
    public Future<Fee> create(Fee entity) {
        final Promise<Fee> promise = Futures.promise();

        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".fee_seq')",
                idResult -> {
                    final Long id = idResult.row(0).getLong(0);

                    String query = "INSERT INTO " + connectionPool.getSchemaName() + ".fee(id, start_amount_range, end_amount_range, currency_id," +
                            " account_id, operation_type" +
                            " VALUES ($1, $2, $3, $4, $5, $6, $7)";
                    connectionPool.getConnection().query(query, asList(id, entity.startAmountRange, entity.endAmountRange, entity.currencyId,
                            entity.accountId, entity.operationType.name()), result -> promise.success(new Fee(id, entity.startAmountRange, entity.endAmountRange, entity.currencyId, entity.accountId, entity.operationType)), promise::failure);
                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Optional<Fee>> retrieveById(Object id) {
        final Promise<Optional<Fee>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".fee WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createEntity(result)),
                promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Fee>> retrieveAll() {
        final Promise<List<Fee>> completableFuture = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".fee";
        connectionPool.getConnection().query(query, result -> {
            final List<Fee> fees = new ArrayList<>();
            result.forEach(row -> fees.add(createEntity(row)));
            completableFuture.success(fees);
        }, completableFuture::failure);

        return completableFuture.future();
    }

    @Override
    public Future<Fee> update(Fee entity) {
        final Promise<Fee> completableFuture = Futures.promise();

        String query = "UPDATE " + connectionPool.getSchemaName() + ".fee SET start_amount_range=$2, end_amount_range=$3, currency_id=$4," +
                " account_id=$5, operation_type=$6 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.startAmountRange, entity.endAmountRange, entity.currencyId,
                entity.accountId, entity.operationType.name()),
                result -> completableFuture.success(entity), completableFuture::failure);

        return completableFuture.future();
    }

    @Override
    public void delete(Fee entity) {
        final Promise<Fee> completableFuture = Futures.promise();
        String query = "DELETE FROM " + connectionPool.getSchemaName() + ".fee where id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId()),
                result -> completableFuture.success(entity), completableFuture::failure);
    }

    public Future<Optional<Fee>> retrieveAppropriateFee(Integer accountId, OperationType operationType, Long amount, String currency) {

        final Promise<Optional<Fee>> completableFuture = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".fee where account_id=$1 and operation_type=$2 and currency_id=$3 and start_amount_range <= $4 and end_amount_range > $4";
        connectionPool.getConnection().query(query, asList(accountId, operationType.name(), currency, amount), result -> completableFuture.success(createEntity(result)), completableFuture::failure);

        return completableFuture.future();
    }

    public Fee createEntity(Row row) {
        return new Fee(row.getLong("id"), row.getLong("start_amount_range"), row.getLong("end_amount_range"), row.getString("currency_id"), row.getInt("account_id"), OperationType.valueOf(row.getString("operation_type")));
    }

}
