package repository;

import akka.dispatch.Futures;
import com.github.pgasync.Row;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import model.Card;
import model.Country;
import model.enums.CardBrand;
import model.enums.CardType;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Card CRUD repository
 *
 * @author nihilist - created 04.02.2016
 * @since 0.1.0
 */
@Singleton
public class CardRepository implements BaseCRUDRepository<Card> {

    @Inject
    private ConnectionPool connectionPool;

    @Override
    public Future<Card> create(Card entity) {

        final Promise<Card> promise = Futures.promise();

        connectionPool.getConnection().query("select nextval('" + connectionPool.getSchemaName() + ".card_seq')",
                idResult -> {
                    final Long id = idResult.row(0).getLong(0);

                    final String query = "INSERT INTO " + connectionPool.getSchemaName() + ".card (id, token, cardtype, brand, createDate, is_default, active, customer_id, alias, info, deliveryAddress1, deliveryAddress2, deliveryAddress3, deliveryCountry, currency_id) VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9, $10, $11, $12, $13, $14, $15)";

                    connectionPool.getConnection().query(query,
                            asList(id, entity.getToken(), entity.getType().toString(),
                                    entity.getBrand().toString(), new Timestamp(entity.getCreateDate().getTime()), entity.getCardDefault(), entity.getActive(), entity.getCustomerId(), entity.getAlias(), entity.getInfo(), entity.getDeliveryAddress1(), entity.getDeliveryAddress2(), entity.getDeliveryAddress3(), entity.getDeliveryCountry(), entity.getCurrencyId()),
                            result -> {
                                entity.setId(idResult.row(0).getLong(0));
                                promise.success(entity);
                            }, promise::failure);
                }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Card> retrieveById(Object id) {

        final Promise<Card> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".card WHERE id=$1";
        connectionPool.getConnection().query(query, asList(id), result -> promise.success(createCard(result.row(0))), promise::failure);

        return promise.future();
    }

    @Override
    public Future<List<Card>> retrieveAll() {

        final Promise<List<Card>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".card";
        connectionPool.getConnection().query(query, result -> {
            final ArrayList<Card> cards = new ArrayList<>();
            result.forEach(row -> cards.add(createCard(row)));
            promise.success(cards);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Card>> retrieveListByCardBrand(CardBrand cardBrand) {

        final Promise<List<Card>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".card where brand=$1";
        connectionPool.getConnection().query(query, asList(cardBrand.toString()), result -> {
            final ArrayList<Card> cards = new ArrayList<>();
            result.forEach(row -> cards.add(createCard(row)));
            promise.success(cards);
        }, promise::failure);

        return promise.future();
    }


    public Future<List<Card>> retrieveListByCardType(CardType cardType) {

        final Promise<List<Card>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".card where cardtype=$1";
        connectionPool.getConnection().query(query, asList(cardType.toString()), result -> {
            final ArrayList<Card> cards = new ArrayList<>();
            result.forEach(row -> cards.add(createCard(row)));
            promise.success(cards);
        }, promise::failure);

        return promise.future();
    }

    public Future<List<Card>> retrieveListByCustomerId(String customerID) {

        final Promise<List<Card>> promise = Futures.promise();

        final String query = "SELECT * FROM " + connectionPool.getSchemaName() + ".card where customer_id=$1";
        connectionPool.getConnection().query(query, asList(customerID), result -> {
            final ArrayList<Card> cards = new ArrayList<>();
            result.forEach(row -> cards.add(createCard(row)));
            promise.success(cards);
        }, promise::failure);

        return promise.future();
    }

    @Override
    public Future<Card> update(Card entity) {

        final Promise<Card> promise = Futures.promise();

        final String query = "UPDATE " + connectionPool.getSchemaName() +
                ".card SET token=$2, cardtype=$3, brand=$4, createDate=$5, is_default=$6, active=$7, customer_id=$8, alias=$9, info=$10, deliveryAddress1=$11, deliveryAddress2=$12, deliveryAddress3=$13, deliveryCountry=$14, currency_id=$15 WHERE id=$1";
        connectionPool.getConnection().query(query, asList(entity.getId(), entity.getToken(), entity.getType().toString(),
                entity.getBrand().toString(), new Timestamp(entity.getCreateDate().getTime()), entity.getCardDefault(), entity.getActive(), entity.getCustomerId(), entity.getAlias(), entity.getInfo(), entity.getDeliveryAddress1(), entity.getDeliveryAddress2(), entity.getDeliveryAddress3(), entity.getDeliveryCountry(), entity.getCurrencyId()), result -> promise.success(entity), promise::failure);

        return promise.future();
    }

    @Override
    public void delete(Card entity) {

    }

    private Card createCard(Row row) {

        return new Card(row.getLong("id"), row.getString("token"), row.getString("customer_id"), CardType.valueOf(row.getString("cardtype")),
                CardBrand.valueOf(row.getString("brand")), row.getBoolean("is_default"), row.getTimestamp("createDate"), row.getString("alias"), row.getBoolean("active"), row.getString("info"), row.getString("currency_id"), row.getString("deliveryAddress1"), row.getString("deliveryAddress2"), row.getString("deliveryAddress3"), row.getString("deliveryCountry"));
    }
}
