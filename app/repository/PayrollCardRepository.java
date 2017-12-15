package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.PayrollCard;
import model.PayrollCardStatus;
import model.PayrollCardType;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;

/**
 * Payroll card CRUD repository
 *
 * @author corbandalas - created 27.11.2017
 * @since 0.7.0
 */
@Singleton
public class PayrollCardRepository implements BaseCRUDRepository<PayrollCard> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<PayrollCard> create(PayrollCard entity) {

        final Promise<PayrollCard> promise = Futures.promise();

        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".payroll_card_seq')",
                idResult -> {

                    final Long id = idResult.row(0).getLong(0);

                    final String query = "INSERT INTO " + connectionPool.getSchemaName() + ".payroll_card (id, payrollrequestid," +
                            "accno, pubtoken, pan, title, lastname, firstname, dob, email, mobtel, addrl1, addrl2, addrl3, city, postcode, country, amount, currency, cardname, expdate, cvv, islive, error, payrollcardstatus, payrollcardtype) VALUES ($1, $2, $3, $4, $5, $6, " +
                            "$7, $8, $9, $10, $11, $12, $13, $14, $15, $16, $17, $18, $19, $20, $21, $22, $23, $24, $25, $26)";
                    connectionPool.getConnection().query(query, asList(id, entity.getPayrollRequestId(), entity.getAccno(), entity.getPubtoken(), entity.getPan(), entity.getTitle(), entity.getLastName(), entity.getFirstName(), entity.getDob(), entity.getEmail(), entity.getMobtel(),
                            entity.getAddrl1(), entity.getAddrl2(), entity.getAddrl3(), entity.getCity(), entity.getPostcode(), entity.getCountry(), entity.getAmount(), entity.getCurrency(), entity.getCardName(), entity.getExpDate(), entity.getCvv(), entity.getIsLive(), entity.getError(), entity.getPayrollCardStatus().name(), entity.getPayrollCardType().name()),
                            result -> {
                                entity.setId(idResult.row(0).getLong(0));
                                promise.success(entity);
                            }, promise::failure);

                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Optional<PayrollCard>> retrieveById(Object id) {

        final Promise<Optional<PayrollCard>> promise = Futures.promise();

        final String query = "Select * FROM " + connectionPool.getSchemaName() + ".payroll_card WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createEntity(result))
                , promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<PayrollCard>> retrieveAll() {

        final Promise<List<PayrollCard>> promise = Futures.promise();

        final String query = "Select * FROM " + connectionPool.getSchemaName() + ".payroll_card";
        connectionPool.getConnection().query(query, result -> {
            promise.success(StreamSupport.stream(result.spliterator(), true).map(row ->
                    createEntity(row)).collect(Collectors.toList()));
        }, promise::failure);

        return promise.future();
    }

    public Future<List<PayrollCard>> retrieveAllByRequestID(Long requestID) {

        final Promise<List<PayrollCard>> promise = Futures.promise();

        final String query = "Select * FROM " + connectionPool.getSchemaName() + ".payroll_card where payrollrequestid=$1";
        connectionPool.getConnection().query(query, asList(requestID), result -> {
            promise.success(StreamSupport.stream(result.spliterator(), true).map(row ->
                    createEntity(row)).collect(Collectors.toList()));
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<PayrollCard> update(PayrollCard entity) {

        final Promise<PayrollCard> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() + ".payroll_card SET pan=$2, pubtoken=$3," +
                " pan=$4, cardname=$5, expdate=$6, cvv=$7, error=$8, payrollcardstatus=$9 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getPan(), entity.getPubtoken(), entity.getPan(), entity.getCardName(), entity.getExpDate(), entity.getCvv(), entity.getError(),
                entity.getPayrollCardStatus().name()),
                result -> promise.success(entity), promise::failure);

        return promise.future();
    }


    @Override
    public void delete(PayrollCard entity) {
        //not required
    }

    public PayrollCard createEntity(Row row) {
        return new PayrollCard(row.getLong("id"), row.getLong("payrollrequestid"), row.getString("accno"), row.getString("pubtoken"), row.getString("pan"), row.getString("title"), row.getString("lastname"), row.getString("firstname"), row.getString("dob"), row.getString("email"), row.getString("mobtel"), row.getString("addrl1"), row.getString("addrl2"), row.getString("addrl3"), row.getString("city"), row.getString("postcode"), row.getString("country"), row.getString("amount"), row.getString("currency"), row.getString("cardname"), row.getString("expdate"), row.getString("cvv"), row.getString("islive"), row.getString("error") ,PayrollCardStatus.valueOf(row.getString("payrollcardstatus")), PayrollCardType.valueOf(row.getString("payrollcardtype")));
    }

}
