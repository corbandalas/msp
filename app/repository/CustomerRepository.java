package repository;

import akka.dispatch.Futures;
import com.github.pgasync.ResultSet;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Card;
import model.Customer;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import rx.Observable;
import scala.concurrent.Future;
import scala.concurrent.Promise;
import util.DateUtil;
import util.Utils;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        final String query = "INSERT INTO " + connectionPool.getSchemaName() +
                ".customer(id, title, firstName, lastName, registrationDate, dateBirth, active, address1, address2, postcode, city, email, kyc, password, country_id, temppassword, houseNameNumber, flat, referral, cdata, cdata2, cdata3, phone2, account_id) VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15, $16, $17, $18, $19, $20, $21, $22, $23, $24)";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getTitle(), entity.getFirstName(),
                entity.getLastName(), new Timestamp(entity.getRegistrationDate().getTime()), new Timestamp(entity.getDateBirth().getTime()), entity.getActive(), entity.getAddress1(), entity.getAddress2(), entity.getPostcode(), entity.getCity(), entity.getEmail(), entity.getKyc().toString(), entity.getPassword(), entity.getCountry_id(), entity.getTemppassword(), entity.getHouseNameNumber(), entity.getFlat(), entity.getReferral(), entity.getCdata(), entity.getCdata2(), entity.getCdata3(), entity.getPhone2()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    public Future<Optional<Customer>> retrieveById(String phone2, String cdata) {

        final Promise<Optional<Customer>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE phone2=$1 and cdata=$2";
        connectionPool.getConnection().query(query, asList(phone2, cdata), result -> promise.success(createEntity(result)), promise::failure);

        return promise.future();
    }

    public Future<Optional<Customer>> retrieveByUUID(String cdata) {

        final Promise<Optional<Customer>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE cdata=$1";
        connectionPool.getConnection().query(query, asList(cdata), result -> promise.success(createEntity(result)), promise::failure);

        return promise.future();
    }

    @Override
    public Future<Optional<Customer>> retrieveById(Object id) {

        final Promise<Optional<Customer>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createEntity(result)), promise::failure);

        return promise.future();
    }

    public Future<Optional<Customer>> retrieveById(Object id, String accountID) {

        final Promise<Optional<Customer>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE id=$1 AND account_id=$2";
        connectionPool.getConnection().query(query, asList(id, accountID), result -> promise.success(createEntity(result)), promise::failure);

        return promise.future();
    }

    public Future<Boolean> isRegistered(Object id) {

        final Promise<Boolean> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success((result.size() > 0)), promise::failure);

        return promise.future();
    }

    public Future<Boolean> isRegistered(String phone2, String cdata) {

        final Promise<Boolean> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() +  ".customer WHERE phone2=$1 and cdata=$2";
        connectionPool.getConnection().query(query, asList(phone2, cdata), result -> promise.success((result.size() > 0)), promise::failure);

        return promise.future();
    }

    public Future<Customer> retrieveByIdAndPassword(Object id, String password) {

        final Promise<Customer> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE id=$1 AND password=$2";
        connectionPool.getConnection().query(query, asList(id, password), result -> promise.success(createEntity(result.row(0))), promise::failure);

        return promise.future();
    }


    public Future<List<Customer>> retrieveByRegistrationDate(Date startDate, Date endDate) {
        final Promise<List<Customer>> promise = Futures.promise();
        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE registrationDate BETWEEN $1 AND $2";
        connectionPool.getConnection().query(query, asList(new Timestamp(DateUtil.getStartOfDay(startDate)), new Timestamp(DateUtil.getEndOfDay(endDate))), result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createEntity(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Customer>> retrieveByRegistrationDate(Date startDate, Date endDate, String accountID) {
        final Promise<List<Customer>> promise = Futures.promise();
        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE (registrationDate BETWEEN $1 AND $2) AND account_id = $3";
        connectionPool.getConnection().query(query, asList(new Timestamp(DateUtil.getStartOfDay(startDate)), new Timestamp(DateUtil.getEndOfDay(endDate)), accountID), result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createEntity(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Customer>> retrieveByKYC(KYC kyc) {
        final Promise<List<Customer>> promise = Futures.promise();
        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE kyc=$1";
        connectionPool.getConnection().query(query, asList(kyc.toString()), result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createEntity(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Customer>> retrieveByKYC(KYC kyc, String accountID) {
        final Promise<List<Customer>> promise = Futures.promise();
        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE kyc=$1 and account_id = $2";
        connectionPool.getConnection().query(query, asList(kyc.toString(), accountID), result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createEntity(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Customer>> retrieveByEmail(String email) {
        final Promise<List<Customer>> promise = Futures.promise();
        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE email=$1";
        connectionPool.getConnection().query(query, asList(email), result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createEntity(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Customer>> retrieveByEmail(String email, String accountID) {
        final Promise<List<Customer>> promise = Futures.promise();
        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer WHERE email=$1 and account_id = $2";
        connectionPool.getConnection().query(query, asList(email, accountID), result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createEntity(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Customer>> retrieveAll() {

        final Promise<List<Customer>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createEntity(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Customer>> retrieveAll(String accountID) {

        final Promise<List<Customer>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".customer where account_id = $1";
        connectionPool.getConnection().query(query, asList(accountID), result -> {
            final ArrayList<Customer> customers = new ArrayList<>();
            result.forEach(row -> customers.add(createEntity(row)));
            promise.success(customers);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Customer> update(Customer entity) {

        final Promise<Customer> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() +
                ".customer SET title=$2, firstName=$3, lastName=$4, registrationDate=$5, dateBirth=$6, active=$7, address1=$8, address2=$9, postcode=$10, city=$11, email=$12, kyc=$13, password=$14, country_id=$15, temppassword=$16, houseNameNumber=$17, flat=$18, referral=$19, cdata=$20, cdata2=$21, cdata3=$22, phone2=$23 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getTitle(), entity.getFirstName(),
                entity.getLastName(), new Timestamp(entity.getRegistrationDate().getTime()), new Timestamp(entity.getDateBirth().getTime()), entity.getActive(), entity.getAddress1(), entity.getAddress2(), entity.getPostcode(), entity.getCity(), entity.getEmail(), entity.getKyc().toString(), entity.getPassword(), entity.getCountry_id(), entity.getTemppassword(), entity.getHouseNameNumber(), entity.getFlat(), entity.getReferral(), entity.getCdata(), entity.getCdata2(), entity.getCdata3(), entity.getPhone2()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }


    @Override
    public void delete(Customer entity) {
        //not required
    }

    public Future<Boolean> deleteCustomer(String phone) {
        final Promise<Boolean> promise = Futures.promise();

        String query = "DELETE from " + connectionPool.getSchemaName() + ".customer where id=$1";
        connectionPool.getConnection().query(query, asList(phone),
                result -> promise.success(true), promise::failure);

        return promise.future();
    }

    public Customer createEntity(Row row) {
        return new Customer(row.getString("id"), row.getTimestamp("registrationDate"), row.getString("title"), row.getString("firstname"), row.getString("lastname"), row.getString("address1"), row.getString("address2"), row.getString("postcode"), row.getString("city"), row.getString("email"), row.getTimestamp("dateBirth"), row.getBoolean("active"), KYC.valueOf(row.getString("kyc")), row.getString("password"), row.getString("country_id"), row.getBoolean("temppassword"), row.getString("houseNameNumber"), row.getString("flat"),row.getString("referral"), row.getString("cdata"), row.getString("cdata2"), row.getString("cdata3"), row.getString("phone2"), row.getString("account_id"));
    }
}
