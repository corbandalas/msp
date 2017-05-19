package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.FeeInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

import model.enums.FeeDestinationType;
import model.enums.FeeIntervalType;
import scala.concurrent.Future;
import scala.concurrent.Promise;

/**
 * Fee interval repository
 *
 * @author corbandalas - created 09.05.2017
 * @since 0.4.0
 */
@Singleton
public class FeeIntervalRepository implements BaseCRUDRepository<FeeInterval> {

    @Inject
    private ConnectionPool connectionPool;


    @Override
    public Future<FeeInterval> create(FeeInterval entity) {

        final Promise<FeeInterval> completableFuture = Futures.promise();

        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".fee_interval_seq')",
                idResult -> {
                    final Long id = idResult.row(0).getLong(0);

                    String query = "INSERT INTO " + connectionPool.getSchemaName() + ".fee_interval(id, fee_id, fee_interval_type, fee_destination_type, amount, percent, account_id" +
                            " VALUES ($1, $2, $3, $4, $5, $6)";
                    connectionPool.getConnection().query(query, asList(id, entity.feeId, entity.feeIntervalType.name(), entity.feeDestinationType.name(), entity.amount, entity.percent,
                            entity.accountId), result -> completableFuture.success(new FeeInterval(id, entity.feeId, entity.amount, entity.percent,
                            entity.accountId, entity.feeIntervalType, entity.feeDestinationType)), completableFuture::failure);
                }, completableFuture::failure);

        return completableFuture.future();
    }

    @Override
    public Future<Optional<FeeInterval>> retrieveById(Object id) {

        final Promise<Optional<FeeInterval>> completableFuture = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".fee_interval WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> completableFuture.success(createEntity(result)),
                completableFuture::failure);

        return completableFuture.future();
    }

    @Override
    public Future<List<FeeInterval>> retrieveAll() {

        final Promise<List<FeeInterval>> completableFuture = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".fee_interval";
        connectionPool.getConnection().query(query, result -> {
            final List<FeeInterval> fees = new ArrayList<>();
            result.forEach(row -> fees.add(createEntity(row)));
            completableFuture.success(fees);
        }, completableFuture::failure);

        return completableFuture.future();
    }

    @Override
    public Future<FeeInterval> update(FeeInterval entity) {

        final Promise<FeeInterval> completableFuture = Futures.promise();

        String query = "UPDATE " + connectionPool.getSchemaName() + ".fee_interval SET fee_id=$2, amount=$3, percent=$4, " +
                " account_id=$5, fee_interval_type=$6, fee_destination_type=$7 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.feeId, entity.amount, entity.percent,
                entity.accountId, entity.feeIntervalType.name(), entity.feeDestinationType.name()),
                result -> completableFuture.success(entity), completableFuture::failure);

        return completableFuture.future();
    }

    @Override
    public void delete(FeeInterval entity) {
        final Promise<FeeInterval> completableFuture = Futures.promise();
        String query = "DELETE FROM " + connectionPool.getSchemaName() + ".fee_interval where id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId()),
                result -> completableFuture.success(entity), completableFuture::failure);
    }

    public Future<List<FeeInterval>> retrieveByFeeId(Long feeId) {

        final Promise<List<FeeInterval>> completableFuture = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".fee_interval where fee_id=$1";
        connectionPool.getConnection().query(query, asList(feeId), result -> {
            final List<FeeInterval> feeIntervals = new ArrayList<>();
            result.forEach(row -> feeIntervals.add(createEntity(row)));
            completableFuture.success(feeIntervals);
        }, completableFuture::failure);

        return completableFuture.future();
    }

    public Future<List<FeeInterval>> retrieveByFeeIdAndType(Long feeId, FeeDestinationType feeDestinationType) {

        final Promise<List<FeeInterval>> completableFuture = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".fee_interval where fee_id=$1 and fee_destination_type=$2";
        connectionPool.getConnection().query(query, asList(feeId, feeDestinationType.name()), result -> {
            final List<FeeInterval> feeIntervals = new ArrayList<>();
            result.forEach(row -> feeIntervals.add(createEntity(row)));
            completableFuture.success(feeIntervals);
        }, completableFuture::failure);

        return completableFuture.future();
    }

    public FeeInterval createEntity(Row row) {
        return new FeeInterval(row.getLong("id"), row.getLong("fee_id"), row.getLong("amount"), row.getLong("percent"), row.getInt("account_id"), FeeIntervalType.valueOf(row.getString("fee_interval_type")), FeeDestinationType.valueOf(row.getString("fee_destination_type")));
    }

}
