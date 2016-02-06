package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Account;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Account CRUD repository
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
@Singleton
public class AccountRepository implements BaseCRUDRepository<Account> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<Account> create(Account entity) {

        final Promise<Account> promise = Futures.promise();

        final String query = "INSERT INTO " + connectionPool.getSchemaName() + ".account(id, currency_id, name," +
                " createdate, active) VALUES ($1, $2, $3, $4, $5)";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getCurrencyId(), entity.getName(),
                entity.getCreateDate(), entity.getActive()),
                result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public Future<Account> retrieveById(Object id) {

        final Promise<Account> promise = Futures.promise();

        final String query = "SELECT * FROM  " + connectionPool.getSchemaName() + ".account WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createAccount(result.row(0))), promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Account>> retrieveAll() {

        final Promise<List<Account>> promise = Futures.promise();

        final String query = "SELECT * FROM  " + connectionPool.getSchemaName() + ".account";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Account> accounts = new ArrayList<>();
            result.forEach(row -> accounts.add(createAccount(row)));
            promise.success(accounts);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Account> update(Account entity) {
        final Promise<Account> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() + ".account SET currency_id=$2, name=$3," +
                " createdate=$4, active=$5 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getCurrencyId(), entity.getName(),
                entity.getCreateDate(), entity.getActive()),
                result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Account entity) {
        //Not required yet
    }

    private Account createAccount(Row row) {
        return new Account(row.getInt("id"), row.getString("name"), row.getString("currency_id"), row.getDate("createdate"),
                row.getBoolean("active"));
    }
}