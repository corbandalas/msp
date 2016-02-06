package repository;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import dto.CurrencyExchangeRatesResponse;
import model.BaseEntity;
import model.Currency;
import model.ExchangeRateHistory;
import play.Logger;
import scala.concurrent.Future;
import scala.concurrent.Promise;
import scala.tools.cmd.gen.AnyVals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Currency CRUD repository
 *
 * @author ra - created 04.02.2016
 * @since 0.1.0
 */
@Singleton
public class CurrencyRepository implements BaseCRUDRepository<Currency> {

    @Inject
    private ConnectionPool connectionPool;

    @Inject
    private ExchangeRateHistoryRepository exchangeRateHistoryRepository;

    @Override
    public Future<Currency> create(Currency entity) {

        final Promise<Currency> promise = Futures.promise();

        final String query = "INSERT INTO " + connectionPool.getSchemaName() +
                ".currency(id, displaytext, code, active, euroindex) VALUES ($1, $2, $3, $4, $5)";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getDisplayText(), entity.getCode(),
                entity.getActive(), entity.getEuroIndex()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public Future<Currency> retrieveById(Object id) {

        final Promise<Currency> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".currency where id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(
                createCurrency(result.row(0))), promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Currency>> retrieveAll() {

        final Promise<List<Currency>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".currency";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Currency> currencies = new ArrayList<>();
            result.forEach(row->{
                currencies.add(createCurrency(row));
            });
            promise.success(currencies);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Currency> update(Currency entity) {

        final Promise<Currency> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() +
                ".currency SET displaytext=$2, code=$3, active=$4, euroindex=$5 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getDisplayText(), entity.getCode(),
                entity.getActive(), entity.getEuroIndex()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Currency entity) {
        //not required implemented yet
    }

    private Currency createCurrency(Row row) {
        return new Currency(row.getString("id"), row.getShort("code"), row.getString("displaytext"),
                row.getDouble("euroindex"), row.getBoolean("active"));
    }



    public Future<CurrencyExchangeRatesResponse> updateCurrencyExchangeRates(final List<Currency> currencies, String url, String apiKey) {

        final String query = url + "?access_key=" + apiKey + "&currencies=" + currencies.parallelStream().map(BaseEntity::getId).collect(Collectors.joining(","));

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<CurrencyExchangeRatesResponse> promise = Futures.promise();


        asyncHttpClient.prepareGet(query).execute(new AsyncCompletionHandler<CurrencyExchangeRatesResponse>(){

            @Override
            public CurrencyExchangeRatesResponse onCompleted(Response response) throws Exception {

                String responseBody = response.getResponseBody();
                Logger.info("///Obtained currencies: " + responseBody);

                ObjectMapper mapper = new ObjectMapper();
                CurrencyExchangeRatesResponse ratesResponse = mapper.readValue(responseBody, CurrencyExchangeRatesResponse.class);


                for (Currency c: currencies) {
                    final BigDecimal rate = ratesResponse.getQuotes().get(ratesResponse.getSource() + c.getId());

                    if (rate != null) {
                        double oldIndex = c.getEuroIndex();

                        exchangeRateHistoryRepository.create(new ExchangeRateHistory(0L, oldIndex, new Date(), c.getId()));
                        update(new Currency(c.getId(), c.getCode(), c.getDisplayText(), c.getEuroIndex(), c.getActive()));
                    }
                }


                promise.success(ratesResponse);


                return ratesResponse;
            }

            @Override
            public void onThrowable(Throwable t){
                Logger.error("/////Error while retrieving currencies from API", t);

                promise.failure(t);
            }
        });

        return promise.future();

    }
}
