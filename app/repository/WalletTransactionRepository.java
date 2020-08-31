package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.WalletTransaction;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Wallet transaction CRUD repository
 *
 * @author tar - created 21.08.2020
 * @since 0.1.0
 */
@Singleton
public class WalletTransactionRepository implements BaseCRUDRepository<WalletTransaction> {

    @Inject
    private ConnectionPool connectionPool;


    @Override
    public Future<WalletTransaction> create(WalletTransaction entity) {

        final Promise<WalletTransaction> promise = Futures.promise();

        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".wallet_transaction_seq')",
                idResult -> {
                    final Long id = idResult.row(0).getLong(0);

                    String query = "INSERT INTO " + connectionPool.getSchemaName() + ".wallet_transaction(id, src_token, dest_token, uuid, amount_cts, date_added, description, currency, type" +
                            " )" +
                            " VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9)";
                    connectionPool.getConnection().query(query, asList(id, entity.getSrc_token(), entity.getDest_token(), entity.getUuid(), entity.getAmount_cts(),
                            entity.getDate_added(), entity.getDescription(),
                            entity.getCurrency(),
                            entity.getType()
                    ), result -> {
                        entity.setId(id);
                        promise.success(entity);
                    }, promise::failure);
                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Optional<WalletTransaction>> retrieveById(Object id) {

        final Promise<Optional<WalletTransaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".wallet_transaction WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createEntity(result)),
                promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<WalletTransaction>> retrieveAll() {

        final Promise<List<WalletTransaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".wallet_transaction";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<WalletTransaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createEntity(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<WalletTransaction> update(WalletTransaction entity) {

        final Promise<WalletTransaction> promise = Futures.promise();

        //TODO: Do it later
        String query = "UPDATE " + connectionPool.getSchemaName() + ".wallet_transaction SET operation_id=$2, amount=$3, currency_id=$4," +
                " from_account_id=$5, to_account_id=$6, from_card_id=$7, to_card_id=$8, from_account_exchange_rate=$9," +
                " to_account_exchange_rate=$10, from_card_exchange_rate=$11, to_card_exchange_rate=$12, type=$13 WHERE id=$1";
//        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getOperationId(), entity.getAmount(), entity.getCurrencyId(),
//                entity.getFromAccountId(), entity.getToAccountId(), entity.getFromCardId(), entity.getToCardId(),
//                entity.getFromAccountExchangeRate(), entity.getToAccountExchangeRate(), entity.getFromCardExchangeRate(),
//                entity.getToCardExchangeRate(), entity.getType().name()),
//                result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(WalletTransaction entity) {
        //not required yet
    }


    public Future<Boolean> deleteAll(String uuid) {
        final Promise<Boolean> promise = Futures.promise();

        String query = "DELETE from" + connectionPool.getSchemaName() + ".wallet_transaction where uuid=$1";
        connectionPool.getConnection().query(query, asList(uuid),
                result -> promise.success(true), promise::failure);

        return promise.future();
    }

    public Future<List<WalletTransaction>> retrieveByUuid(String uuid) {

        final Promise<List<WalletTransaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".wallet_transaction where uuid=$1";
        connectionPool.getConnection().query(query, asList(uuid), result -> {
            final ArrayList<WalletTransaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createEntity(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<WalletTransaction>> retrieveByUuidAndDate(String uuid, long toDate, long fromDate) {

        final Promise<List<WalletTransaction>> promise = Futures.promise();

        String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".wallet_transaction where uuid=$1 and date_added >= $1 and date_added <=$2";
        connectionPool.getConnection().query(query, asList(uuid, toDate, fromDate), result -> {
            final ArrayList<WalletTransaction> transactions = new ArrayList<>();
            result.forEach(row -> transactions.add(createEntity(row)));
            promise.success(transactions);
        }, promise::failure);

        return promise.future();
    }

    public Future<Double> retrieveSumByUUID(String uuid) {

        final Promise<Double> promise = Futures.promise();

        String query = "SELECT sum(amount_cts) FROM " + connectionPool.getSchemaName() + ".wallet_transaction where uuid=$1";
        connectionPool.getConnection().query(query, asList(uuid), result -> {
            promise.success(result.row(0).getDouble(0));
        }, promise::failure);

        return promise.future();
    }

    public WalletTransaction createEntity(Row row) {
        return new WalletTransaction(row.getLong("id"), row.getLong("amount_cts"), row.getString("currency"), row.getLong("date_added"),
                row.getString("type"), row.getString("description"),
                row.getString("src_token"), row.getString("dest_token"), row.getString("uuid"));
    }
}
