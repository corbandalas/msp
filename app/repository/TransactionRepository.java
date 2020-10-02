package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Operation;
import model.Transaction;
import model.enums.OperationType;
import model.enums.TransactionType;
import org.apache.commons.lang3.StringUtils;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;

/**
 * Transaction CRUD repository
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
@Singleton
public class TransactionRepository implements BaseCRUDRepository<Transaction> {

    @Inject
    private ConnectionPool connectionPool;


    @Override
    public Future<Transaction> create(Transaction entity) {

        final Promise<Transaction> promise = Futures.promise();

        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".transaction_seq')",
                idResult -> {
                    final Long id = idResult.row(0).getLong(0);

                    String query = "INSERT INTO " + connectionPool.getSchemaName() + ".transaction(id, operation_id, amount, currency_id," +
                            " from_account_id, to_account_id, from_card_id,  to_card_id, from_account_exchange_rate," +
                            " to_account_exchange_rate, from_card_exchange_rate, to_card_exchange_rate, type, create_date, order_id)" +
                            " VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15)";
                    connectionPool.getConnection().query(query, asList(id, entity.getOperationId(), entity.getAmount(), entity.getCurrencyId(),
                            entity.getFromAccountId(), entity.getToAccountId(), entity.getFromCardId(), entity.getToCardId(),
                            entity.getFromAccountExchangeRate(), entity.getToAccountExchangeRate(), entity.getFromCardExchangeRate(),
                            entity.getToCardExchangeRate(), entity.getType().name(), new Timestamp(entity.getCreateDate().getTime()), entity.getOrderID()), result -> {
                        entity.setId(id);
                        promise.success(entity);
                    }, promise::failure);
                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Optional<Transaction>> retrieveById(Object id) {

        final Promise<Optional<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createEntity(result)),
                promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Transaction>> retrieveAll() {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createEntity(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Transaction>> retrieveAll(Integer  accountID) {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction where to_account_id=$1 OR from_account_id=$1";
        connectionPool.getConnection().query(query, asList(accountID), result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createEntity(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Transaction> update(Transaction entity) {

        final Promise<Transaction> promise = Futures.promise();

        String query = "UPDATE " + connectionPool.getSchemaName() + ".transaction SET operation_id=$2, amount=$3, currency_id=$4," +
                " from_account_id=$5, to_account_id=$6, from_card_id=$7, to_card_id=$8, from_account_exchange_rate=$9," +
                " to_account_exchange_rate=$10, from_card_exchange_rate=$11, to_card_exchange_rate=$12, type=$13 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getOperationId(), entity.getAmount(), entity.getCurrencyId(),
                entity.getFromAccountId(), entity.getToAccountId(), entity.getFromCardId(), entity.getToCardId(),
                entity.getFromAccountExchangeRate(), entity.getToAccountExchangeRate(), entity.getFromCardExchangeRate(),
                entity.getToCardExchangeRate(), entity.getType().name()),
                result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Transaction entity) {
        //not required yet
    }

    public Future<Boolean> deleteAllTransaction(Long cardID) {
        final Promise<Boolean> promise = Futures.promise();

        String query = "DELETE from " + connectionPool.getSchemaName() + ".transaction where to_card_id=$1 OR from_card_id=$1";
        connectionPool.getConnection().query(query, asList(cardID),
                result -> promise.success(true), promise::failure);

        return promise.future();
    }

    public Future<List<Transaction>> retrieveByOperationId(Long operationId) {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction where operation_id=$1";
        connectionPool.getConnection().query(query, asList(operationId), result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createEntity(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Transaction>> retrieveByFromAccountId(Integer fromAccountId) {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction where from_account_id=$1";
        connectionPool.getConnection().query(query, asList(fromAccountId), result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createEntity(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Transaction>> retrieveByToAccountId(Integer toAccountId) {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction where to_account_id=$1";
        connectionPool.getConnection().query(query, asList(toAccountId), result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createEntity(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    public Future<Double> retrieveSumByToCardId(Long toCardId) {

        final Promise<Double> promise = Futures.promise();

        String query = "SELECT sum(amount*to_card_exchange_rate) FROM " + connectionPool.getSchemaName() + ".transaction where to_card_id=$1";
        connectionPool.getConnection().query(query, asList(toCardId), result -> {
            promise.success(result.row(0).getDouble(0));
        }, promise::failure);

        return promise.future();
    }

    public Future<Double> retrieveSumByFromCardId(Long fromCardId) {

        final Promise<Double> promise = Futures.promise();

        String query = "SELECT sum(amount*from_card_exchange_rate) FROM " + connectionPool.getSchemaName() + ".transaction where from_card_id=$1";
        connectionPool.getConnection().query(query, asList(fromCardId), result -> {
            promise.success(result.row(0).getDouble(0));
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Transaction>> retrieveByDateAndType( Integer  accountID, Date dateFrom, Date dateTo, TransactionType type, Short limit, Long offset, String orderID) {

        final Promise<List<Transaction>> promise = Futures.promise();

        final StringBuilder queryBuilder = new StringBuilder("Select * FROM ").append(connectionPool.getSchemaName())
                .append(".transaction where create_date between $1 and $2");

        if (StringUtils.isNotBlank(orderID)) {
            queryBuilder.append(" and order_id = '").append(orderID).append("'");;
        }

        if (type != null) queryBuilder.append(" and type='").append(type.name()).append("'");

        queryBuilder.append(" where to_account_id=$5 OR from_account_id=$5");


        queryBuilder.append(" limit $3 offset $4");



        connectionPool.getConnection().query(queryBuilder.toString(), asList(new Timestamp(dateFrom.getTime()),
                new Timestamp(dateTo.getTime()), limit, offset, orderID, accountID), result -> promise.success(StreamSupport
                .stream(result.spliterator(), true).map(this::createEntity).collect(Collectors.toList())), promise::failure);

        return promise.future();
    }

    public Future<List<Transaction>> retrieveByDateAndType(Date dateFrom, Date dateTo, TransactionType type, Short limit, Long offset, String orderID) {

        final Promise<List<Transaction>> promise = Futures.promise();

        final StringBuilder queryBuilder = new StringBuilder("Select * FROM ").append(connectionPool.getSchemaName())
                .append(".transaction where create_date between $1 and $2");

        if (type != null) queryBuilder.append(" and type='").append(type.name()).append("'");

        if (StringUtils.isNotBlank(orderID)) {
            queryBuilder.append(" and order_id = '").append(orderID).append("'");;
        }

        queryBuilder.append(" limit $3 offset $4");



        connectionPool.getConnection().query(queryBuilder.toString(), asList(new Timestamp(dateFrom.getTime()),
                new Timestamp(dateTo.getTime()), limit, offset, orderID), result -> promise.success(StreamSupport
                .stream(result.spliterator(), true).map(this::createEntity).collect(Collectors.toList())), promise::failure);

        return promise.future();
    }



    public Transaction createEntity(Row row) {
        return new Transaction(row.getLong("id"), row.getLong("operation_id"), row.getLong("amount"), row.getString("currency_id"),
                row.getInt("from_account_id"), row.getInt("to_account_id"), row.getLong("from_card_id"), row.getLong("to_card_id"),
                row.getDouble("from_account_exchange_rate"), row.getDouble("to_account_exchange_rate"), row.getDouble("from_card_exchange_rate"),
                row.getDouble("to_card_exchange_rate"), TransactionType.valueOf(row.getString("type")), row.getTimestamp("create_date"), row.getString("order_id"));
    }
}
