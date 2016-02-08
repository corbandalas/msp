package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Transaction;
import model.enums.TransactionType;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.ArrayList;
import java.util.List;

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
                    final Long id=idResult.row(0).getLong(0);

                    String query = "INSERT INTO " + connectionPool.getSchemaName() + ".transaction(id, operation_id, amount, currency_id," +
                            " from_account_id, to_account_id, card_id, from_exchange_rate, to_exchange_rate, type)" +
                            " VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10)";
                    connectionPool.getConnection().query(query, asList(id, entity.getOperationId(), entity.getAmount(), entity.getCurrencyId(),
                            entity.getFromAccountId(), entity.getToAccountId(), entity.getCardId(), entity.getFromExchangeRate(),
                            entity.getToExchangeRate(), entity.getType().name()), result -> {
                        entity.setId(id);
                        promise.success(entity);}, promise::failure);
                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Transaction> retrieveById(Object id) {

        final Promise<Transaction> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createTransaction(result.row(0))),
                promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Transaction>> retrieveAll() {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createTransaction(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Transaction> update(Transaction entity) {

        final Promise<Transaction> promise = Futures.promise();

        String query = "UPDATE " + connectionPool.getSchemaName() + ".transaction SET operation_id=$2, amount=$3, currency_id=$4," +
                " from_account_id=$5, to_account_id=$6, card_id=$7, from_exchange_rate=$8, to_exchange_rate=$9, type=$10 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getOperationId(), entity.getAmount(), entity.getCurrencyId(),
                entity.getFromAccountId(), entity.getToAccountId(), entity.getCardId(), entity.getFromExchangeRate(),
                entity.getToExchangeRate(), entity.getType().name()),
                result -> promise.success(createTransaction(result.row(0))), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Transaction entity) {
        //not required yet
    }

    public Future<List<Transaction>> retrieveByOperationId(Long operationId) {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction where operation_id=$1";
        connectionPool.getConnection().query(query, asList(operationId), result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createTransaction(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Transaction>> retrieveByFromAccountId(Long fromAccountId) {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction where from_account_id=$1";
        connectionPool.getConnection().query(query, asList(fromAccountId), result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createTransaction(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Transaction>> retrieveByToAccountId(Long toAccountId) {

        final Promise<List<Transaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".transaction where to_account_id=$1";
        connectionPool.getConnection().query(query, asList(toAccountId), result -> {
            final ArrayList<Transaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createTransaction(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    private Transaction createTransaction(Row row) {
        return new Transaction(row.getLong("id"), row.getLong("operation_id"), row.getLong("amount"), row.getString("currency_id"),
                row.getInt("from_account_id"), row.getInt("to_account_id"), row.getLong("card_id"), row.getDouble("from_exchange_rate"),
                row.getDouble("to_exchange_rate"), TransactionType.valueOf(row.getString("type")));
    }
}
