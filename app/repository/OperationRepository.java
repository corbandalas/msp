package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Operation;
import model.enums.OperationType;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;

/**
 * Operation CRUD repository
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
@Singleton
public class OperationRepository implements BaseCRUDRepository<Operation> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<Operation> create(Operation entity) {

        final Promise<Operation> promise = Futures.promise();

        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".operation_seq')",
                idResult -> {
                    final Long id = idResult.row(0).getLong(0);

                    final String query = "INSERT INTO " + connectionPool.getSchemaName() + ".operation (id, orderid," +
                            " description, type, createdate) VALUES ($1, $2, $3, $4, $5)";
                    connectionPool.getConnection().query(query, asList(id, entity.getOrderId(), entity.getDescription(),
                            entity.getType().name(), new Timestamp(entity.getCreateDate().getTime())),
                            result -> {
                                entity.setId(idResult.row(0).getLong(0));
                                promise.success(entity);
                            }, promise::failure);
                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Optional<Operation>> retrieveById(Object id) {

        final Promise<Optional<Operation>> promise = Futures.promise();

        final String query = "Select * FROM " + connectionPool.getSchemaName() + ".operation WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createEntity(result))
                , promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Operation>> retrieveAll() {

        final Promise<List<Operation>> promise = Futures.promise();

        final String query = "Select * FROM " + connectionPool.getSchemaName() + ".operation";
        connectionPool.getConnection().query(query, result -> {
            promise.success(StreamSupport.stream(result.spliterator(), true).map(row ->
                    createEntity(row)).collect(Collectors.toList()));
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Operation>> retrieveByDateAndType(Date dateFrom, Date dateTo, OperationType type, Short limit, Long offset) {

        final Promise<List<Operation>> promise = Futures.promise();

        final StringBuilder queryBuilder = new StringBuilder("Select * FROM ").append(connectionPool.getSchemaName())
                .append(".operation where createdate between $1 and $2");

        if (type != null) queryBuilder.append(" and type='").append(type.name()).append("'");

        queryBuilder.append(" limit $3 offset $4");

        connectionPool.getConnection().query(queryBuilder.toString(), asList(new Timestamp(dateFrom.getTime()),
                new Timestamp(dateTo.getTime()), limit, offset), result -> promise.success(StreamSupport
                .stream(result.spliterator(), true).map(this::createEntity).collect(Collectors.toList())), promise::failure);

        return promise.future();
    }

    @Override
    public Future<Operation> update(Operation entity) {

        final Promise<Operation> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() + ".operation SET orderid=$2, description=$3," +
                " type=$4, createdate=$5 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getOrderId(), entity.getDescription(),
                entity.getType().name(), new Timestamp(entity.getCreateDate().getTime())),
                result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Operation entity) {
        //not required
    }

    public Operation createEntity(Row row) {
        return new Operation(row.getLong("id"), OperationType.valueOf(row.getString("type")), row.getString("orderid"),
                row.getString("description"), row.getTimestamp("createdate"));
    }
}
