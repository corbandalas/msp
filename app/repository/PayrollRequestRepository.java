package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.PayrollRequest;
import model.PayrollRequestStatus;
import play.libs.F;
import scala.concurrent.Future;
import scala.concurrent.Promise;
import util.DateUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Arrays.asList;

/**
 * Payroll request CRUD repository
 *
 * @author corbandalas - created 25.11.2017
 * @since 0.7.0
 */
@Singleton
public class PayrollRequestRepository implements BaseCRUDRepository<PayrollRequest> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<PayrollRequest> create(PayrollRequest entity) {

        final Promise<PayrollRequest> promise = Futures.promise();

        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".payroll_request_seq')",
                idResult -> {
                    final Long id = idResult.row(0).getLong(0);

                    F.Promise<Long> getPayrollSequencePromise = F.Promise.wrap(getPayrollSequenceValue());

                    getPayrollSequencePromise.map(sequence -> {


                        String daySequence = "";

                        if (sequence < 10) {
                            daySequence = "0" + sequence;
                        } else {
                            daySequence = "" + daySequence;
                        }


                        final String query = "INSERT INTO " + connectionPool.getSchemaName() + ".payroll_request (id, orderid," +
                                " description, createdate, daysequence, accountid, payrollrequeststatus) VALUES ($1, $2, $3, $4, $5, $6, $7)";
                        final String finalDaySequence = daySequence;
                        connectionPool.getConnection().query(query, asList(id, entity.getOrderId(), entity.getDescription(),
                                new Timestamp(entity.getCreateDate().getTime()), daySequence, entity.getAccountID(), entity.getPayrollRequestStatus().name()),
                                result -> {
                                    entity.setId(idResult.row(0).getLong(0));
                                    entity.setDaySequence(finalDaySequence);
                                    promise.success(entity);
                                }, promise::failure);

                        return sequence;
                    });


                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Optional<PayrollRequest>> retrieveById(Object id) {

        final Promise<Optional<PayrollRequest>> promise = Futures.promise();

        final String query = "Select * FROM " + connectionPool.getSchemaName() + ".payroll_request WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createEntity(result))
                , promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<PayrollRequest>> retrieveAll() {

        final Promise<List<PayrollRequest>> promise = Futures.promise();

        final String query = "Select * FROM " + connectionPool.getSchemaName() + ".payroll_request";
        connectionPool.getConnection().query(query, result -> {
            promise.success(StreamSupport.stream(result.spliterator(), true).map(row ->
                    createEntity(row)).collect(Collectors.toList()));
        }, promise::failure);

        return promise.future();
    }

    public Future<List<PayrollRequest>> retrieveAllByAccountID(Integer accountID) {

        final Promise<List<PayrollRequest>> promise = Futures.promise();

        final String query = "Select * FROM " + connectionPool.getSchemaName() + ".payroll_request where accountid=$1";
        connectionPool.getConnection().query(query, asList(accountID), result -> {
            promise.success(StreamSupport.stream(result.spliterator(), true).map(row ->
                    createEntity(row)).collect(Collectors.toList()));
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<PayrollRequest> update(PayrollRequest entity) {

        final Promise<PayrollRequest> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() + ".payroll_request SET description=$2, daysequence=$3," +
                " payrollrequeststatus=$4 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getDescription(), entity.getDaySequence(),
                entity.getPayrollRequestStatus().name()),
                result -> promise.success(entity), promise::failure);

        return promise.future();
    }


    @Override
    public void delete(PayrollRequest entity) {
        //not required
    }

    public Future<Long> getPayrollSequenceValue() {

        final Promise<Long> promise = Futures.promise();

        final Date currentDate = new Date();
        final Date startTodayDate = DateUtil.getStartDateOfDay(currentDate);

        connectionPool.getConnection().query("select * from " + connectionPool.getSchemaName() + ".payroll_request_sequence where lastdate > $1 and lastdate < $2", asList(new Timestamp(startTodayDate.getTime()), new Timestamp(currentDate.getTime())),
                idResult -> {

                    if (idResult != null && idResult.size() > 0) {
                        long currentSequenceValue = idResult.row(0).getLong("currentvalue") + 1;
                        long id = idResult.row(0).getLong("id");

                        final String query = "UPDATE " + connectionPool.getSchemaName() + ".payroll_request_sequence SET currentvalue=$2, lastdate=$3 WHERE id=$1";
                        connectionPool.getConnection().query(query, asList(id, currentSequenceValue, new Timestamp(currentDate.getTime())),
                                result -> promise.success(currentSequenceValue), promise::failure);


                    } else {

                        final String query = "INSERT INTO " + connectionPool.getSchemaName() + ".payroll_request_sequence (id, lastdate, currentvalue) VALUES ($1, $2, $3)";

                        connectionPool.getConnection().query(query, asList(currentDate.getTime(), new Timestamp(currentDate.getTime()), 1L),
                                result -> promise.success(1L), promise::failure);
                    }

                }, promise::failure);

        return promise.future();
    }

    public PayrollRequest createEntity(Row row) {
        return new PayrollRequest(row.getLong("id"), row.getString("orderid"), row.getString("description"), row.getTimestamp("createdate"), row.getString("daysequence"), row.getInt("accountid"),  PayrollRequestStatus.valueOf(row.getString("payrollrequeststatus")));
    }

}
