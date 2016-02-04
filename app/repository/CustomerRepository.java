package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Card;
import model.Customer;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Customer CRUD repository
 *
 * @author nihilist - created 04.02.2016
 * @since 0.1.0
 */
@Singleton
public class CustomerRepository implements BaseCRUDRepository<Customer> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<Customer> create(Customer entity) {

        final Promise<Customer> promise = Futures.promise();

        connectionPool.getConnection().query("select nextval('hibernate_sequence')", idRes -> {
            final Long id = idRes.row(0).getLong(0);
            final String query = "INSERT INTO " + connectionPool.getSchemaName() +
                    ".customer(id, title, firstName, lastName, registrationDate, dateBirth, active, address1, address2, postcode, city, email, kyc, password) VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14)";
            connectionPool.getConnection().query(query, asList(id, entity.getTitle(), entity.getFirstName(),
                    entity.getLastName(), entity.getRegistrationDate(), entity.getDateBirth(), entity.getActive(), entity.getAddress1(), entity.getAddress2(), entity.getPostcode(), entity.getCity(), entity.getEmail(), entity.getKyc(), entity.getPassword()), result -> promise.success(entity), promise::failure);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Customer> retrieveById(Object id) {

        final Promise<Customer> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createCustomer(result.row(0))), promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Customer>> retrieveAll() {

        final Promise<List<Customer>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createCustomer(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Customer> update(Customer entity) {

        final Promise<Customer> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() +
                ".customer SET title=$2, firstName=$3, lastName=$4, registrationDate=$5, dateBirth=$6, active=$7, address1=$8, address2=$9, postcode=$10, city=$11, email=$12, kyc=$13, password=$14 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getTitle(), entity.getFirstName(),
                entity.getLastName(), entity.getRegistrationDate(), entity.getDateBirth(), entity.getActive(), entity.getAddress1(), entity.getAddress2(), entity.getPostcode(), entity.getCity(), entity.getEmail(), entity.getKyc(), entity.getPassword()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Customer entity) {
        final Promise<Customer> promise = Futures.promise();
        final String query = "DELETE FROM " + connectionPool.getSchemaName() +
                ".customers WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId()), result -> promise.success(entity), promise::failure);
    }

    private Customer createCustomer(Row row) {
        return new Customer(row.getLong("id"), row.getDate("registrationDate"), row.getString("title"), row.getString("firstname"), row.getString("lastname"), row.getString("address1"), row.getString("address2"), row.getString("postcode"), row.getString("city"), row.getString("email"), row.getDate("dateBirth"), row.getBoolean("active"), KYC.valueOf(row.getString("kyc")), row.getString("password"));
    }
}
