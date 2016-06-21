package provider;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import model.Card;
import model.Currency;
import model.Customer;
import model.enums.KYC;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import play.libs.F;
import provider.dto.*;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Global processing card provider test
 *
 * @author corbandalas created 09.02.2016.
 * @since 0.1.0
 */

public class GlobalProcessingCardProviderTest extends BaseCardProviderTest {

    private PropertyRepository propertyRepository;

    private GlobalProcessingCardProvider globalProcessingCardProvider;

    private CurrencyRepository currencyRepository;


    private final long WS_TIMEOUT = 10000000L;

    @Before
    public void setup() {

        Config conf = ConfigFactory.load();

        propertyRepository = application.injector().instanceOf(PropertyRepository.class);
        globalProcessingCardProvider = application.injector().instanceOf(GlobalProcessingCardProvider.class);
        currencyRepository = application.injector().instanceOf(CurrencyRepository.class);
        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load("conf/properties.json", dispatcher);


    }


    @Test
    public void issuePrepaidVirtualCard() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 1000;

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, getCurrency());

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void convertVirtualToPlastic() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 1000;

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, getCurrency());

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            Calendar instance = Calendar.getInstance();

            instance.add(Calendar.DAY_OF_YEAR, 720);


            card.setToken(cardCreationResponse.getToken());

            ConvertVirtualToPlasticResponse convertVirtualToPlasticResponse = globalProcessingCardProvider.convertVirtualToPlastic(card, new Date(), false, instance.getTime()).get(WS_TIMEOUT);

            assertNotNull(convertVirtualToPlasticResponse);
            assertEquals(convertVirtualToPlasticResponse.getActionCode(), "000");

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void convertVirtualToPlasticAndActivate() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 1000;

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card2", amount, getCurrency());

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            Calendar instance = Calendar.getInstance();

            instance.add(Calendar.DAY_OF_YEAR, 720);


            card.setToken(cardCreationResponse.getToken());

            ConvertVirtualToPlasticResponse convertVirtualToPlasticResponse = globalProcessingCardProvider.convertVirtualToPlastic(card, new Date(), false, instance.getTime()).get(WS_TIMEOUT);

            assertNotNull(convertVirtualToPlasticResponse);
            assertEquals(convertVirtualToPlasticResponse.getActionCode(), "000");


            PlasticCardActivateResponse plasticCardActivateResponse = globalProcessingCardProvider.activatePlasticCard(card).get(WS_TIMEOUT);

            assertNotNull(plasticCardActivateResponse);
            assertEquals(plasticCardActivateResponse.getActionCode(), "000");

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void issueEmptyVirtualCard() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 0;

            CardCreationResponse cardCreationResponse = getEmptyVirtualCard(createCustomer(), "My card", getCurrency());

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }

    @Test
    public void issuePlasticCard() throws Exception {

        Thread.currentThread().sleep(1000);


        try {

            long amount = 0;

            CardCreationResponse cardCreationResponse = getEmptyVirtualCard(createCustomer(), "My card", getCurrency());

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            card.setToken(cardCreationResponse.getToken());


            Calendar instance = Calendar.getInstance();

            instance.add(Calendar.YEAR, 4);

            ConvertVirtualToPlasticResponse convertVirtualToPlasticResponse = globalProcessingCardProvider.convertVirtualToPlastic(card, new Date(), false, instance.getTime()).get(WS_TIMEOUT);

            assertNotNull(convertVirtualToPlasticResponse);

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void getVirtualCardBalance() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 1000;

            Currency currency = getCurrency();

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, currency);

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            card.setToken(cardCreationResponse.getToken());

            CardBalanceResponse cardBalanceResponse = globalProcessingCardProvider.getVirtualCardBalance(card).get(WS_TIMEOUT);

            assertNotNull(cardBalanceResponse);
            assertEquals(cardBalanceResponse.getAvailableBalance(), (double) amount / 100, 0.0001);
            assertEquals(currency.getId(), cardBalanceResponse.getCurrency());

            card.setToken("msp");

            try {
                cardBalanceResponse = globalProcessingCardProvider.getVirtualCardBalance(card).get(WS_TIMEOUT);
                fail();
            } catch (Exception e) {

            }


        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void getVirtualCardDetails() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 1000;

            Currency currency = getCurrency();

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, currency);

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            card.setToken(cardCreationResponse.getToken());

            CardDetailsResponse cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);

            assertNotNull(cardDetailsResponse);
            assertEquals(cardDetailsResponse.getBal(), (double) amount / 100, 0.0001);
            assertEquals(cardDetailsResponse.getCurrency(), currency.getId());
            assertNotNull(cardDetailsResponse.getPan());
            assertNotNull(cardDetailsResponse.getExpDate());
            assertEquals("00", cardDetailsResponse.getStatCode());


            card.setToken("msp");

            try {
                cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);
                fail();
            } catch (Exception e) {

            }


        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void loadVirtualFromBank() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 1000;

            Currency currency = getCurrency();

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, currency);

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            card.setToken(cardCreationResponse.getToken());
            card.setCurrencyId(currency.getId());

            long loadAmount = 5000;

            CardLoadResponse cardLoadResponse = globalProcessingCardProvider.loadVirtualCardFromBank(card, loadAmount, currency, "Test deposit from bank").get(WS_TIMEOUT);

            assertNotNull(cardLoadResponse);

            CardDetailsResponse cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);

            assertNotNull(cardDetailsResponse);
            assertEquals(cardDetailsResponse.getBal(), (double) (amount + loadAmount) / 100, 0.0001);
            assertEquals("00", cardDetailsResponse.getStatCode());

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void loadVirtualFromCard() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 1000;

            Currency currency = getCurrency();

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, currency);

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            card.setToken(cardCreationResponse.getToken());
            card.setCurrencyId(currency.getId());

            long loadAmount = 5000;

            CardLoadResponse cardLoadResponse = globalProcessingCardProvider.loadVirtualCardFromCard(card, loadAmount, currency, "Test deposit from card").get(WS_TIMEOUT);

            assertNotNull(cardLoadResponse);

            CardDetailsResponse cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);

            assertNotNull(cardDetailsResponse);
            assertEquals(cardDetailsResponse.getBal(), (double) (amount + loadAmount) / 100, 0.0001);
            assertEquals("00", cardDetailsResponse.getStatCode());

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void unloadVirtualCard() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 5000;

            Currency currency = getCurrency();

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, currency);

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            card.setToken(cardCreationResponse.getToken());
            card.setCurrencyId(currency.getId());

            long unloadAmount = 10000;

            try {

                globalProcessingCardProvider.unloadVirtualCard(card, unloadAmount, currency, "Test deposit from card").get(WS_TIMEOUT);

                fail();
            } catch (Exception e) {

            }

            unloadAmount = 1000;

            CardUnloadResponse cardUnloadResponse = globalProcessingCardProvider.unloadVirtualCard(card, unloadAmount, currency, "Test withdraw from card").get(WS_TIMEOUT);

            assertNotNull(cardUnloadResponse);

            CardDetailsResponse cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);

            assertNotNull(cardDetailsResponse);
            assertEquals(cardDetailsResponse.getBal(), (double) (amount - unloadAmount) / 100, 0.0001);
            assertEquals("00", cardDetailsResponse.getStatCode());

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }

    @Test
    public void transferBetweenCards() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 5000;

            Currency currency = getCurrency();

            Customer customer1 = createCustomer();

            CardCreationResponse cardCreationResponse1 = getPrepaidVirtualCard(customer1, "My card1", amount, currency);
            CardCreationResponse cardCreationResponse2 = getPrepaidVirtualCard(customer1, "My card2", amount, currency);


            assertNotNull(cardCreationResponse1);
            assertNotNull(cardCreationResponse1.getToken());
            assertEquals(cardCreationResponse1.getLoadValue(), (double) amount / 100, 0.0001);

            assertNotNull(cardCreationResponse2);
            assertNotNull(cardCreationResponse2.getToken());
            assertEquals(cardCreationResponse2.getLoadValue(), (double) amount / 100, 0.0001);

            Card card1 = new Card();

            card1.setToken(cardCreationResponse1.getToken());
            card1.setCurrencyId(currency.getId());


            Card card2 = new Card();

            card2.setToken(cardCreationResponse2.getToken());
            card2.setCurrencyId(currency.getId());

            long transferAmount = 1000;


            CardTransferBalanceResponse cardTransferBalanceResponse = globalProcessingCardProvider.transferBetweenCards(card1, card2, transferAmount, currency, "Test transfer between cards").get(WS_TIMEOUT);

            assertNotNull(cardTransferBalanceResponse);

            CardDetailsResponse cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card1).get(WS_TIMEOUT);

            assertNotNull(cardDetailsResponse);
            assertEquals(cardDetailsResponse.getBal(), (double) (amount - transferAmount) / 100, 0.0001);
            assertEquals("00", cardDetailsResponse.getStatCode());


            cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card2).get(100000L);

            assertNotNull(cardDetailsResponse);
            assertEquals(cardDetailsResponse.getBal(), (double) (amount + transferAmount) / 100, 0.0001);
            assertEquals("00", cardDetailsResponse.getStatCode());

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void getTransactions() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 6000;

            Currency currency = getCurrency();

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, currency);

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            card.setToken(cardCreationResponse.getToken());
            card.setCurrencyId(currency.getId());

            long unloadAmount = 1000;

            CardUnloadResponse cardUnloadResponse = globalProcessingCardProvider.unloadVirtualCard(card, unloadAmount, currency, "Test withdraw from card").get(WS_TIMEOUT);

            assertNotNull(cardUnloadResponse);

            cardUnloadResponse = globalProcessingCardProvider.unloadVirtualCard(card, unloadAmount, currency, "Test withdraw from card").get(WS_TIMEOUT);


            CardTransactionListResponse cardTransactionListResponse = globalProcessingCardProvider.getCardTransactions(card, new Date(), new Date()).get(WS_TIMEOUT);

            assertNotNull(cardTransactionListResponse);
            assertEquals(4, cardTransactionListResponse.getList().size());

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }

    @Test
    public void changeCardStatus() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            long amount = 6000;

            Currency currency = getCurrency();

            CardCreationResponse cardCreationResponse = getPrepaidVirtualCard(createCustomer(), "My card", amount, currency);

            assertNotNull(cardCreationResponse);
            assertNotNull(cardCreationResponse.getToken());
            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

            Card card = new Card();

            card.setToken(cardCreationResponse.getToken());
            card.setCurrencyId(currency.getId());

           globalProcessingCardProvider.blockCard(card, "Fraud case").get(WS_TIMEOUT);


            CardDetailsResponse cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);

            assertNotNull(cardDetailsResponse);
            assertEquals("05", cardDetailsResponse.getStatCode());

            globalProcessingCardProvider.activateCard(card, "Fraud case").get(WS_TIMEOUT);

            cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);

            assertNotNull(cardDetailsResponse);
            assertEquals("00", cardDetailsResponse.getStatCode());

            globalProcessingCardProvider.reportCardLost(card, "Fraud case").get(WS_TIMEOUT);

            cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);

            assertNotNull(cardDetailsResponse);
            assertEquals("41", cardDetailsResponse.getStatCode());

//            globalProcessingCardProvider.reportCardStolen(card, "Fraud case").get(WS_TIMEOUT);
//
//            cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);
//
//            assertNotNull(cardDetailsResponse);
//            assertEquals("43", cardDetailsResponse.getStatCode());


//            globalProcessingCardProvider.reportCardDamaged(card, "Fraud case").get(WS_TIMEOUT);
//
//            cardDetailsResponse = globalProcessingCardProvider.getVirtualCardDetails(card).get(WS_TIMEOUT);
//
//            assertNotNull(cardDetailsResponse);
//            assertEquals("83", cardDetailsResponse.getStatCode());

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }

    @Test
    public void obtainPIN() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            Card card = new Card();
            card.setToken("800882124");


            ChangePINResponse changePINResponse = globalProcessingCardProvider.obtainPIN(card).get(WS_TIMEOUT);

            assertNotNull(changePINResponse);


        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }





    private CardCreationResponse getPrepaidVirtualCard(Customer customer, String cardName, long amount, Currency currency) {
        return globalProcessingCardProvider.issuePrepaidVirtualCard(customer, cardName, amount, currency).get(WS_TIMEOUT);
    }

    private CardCreationResponse getEmptyVirtualCard(Customer customer, String cardName, Currency currency) {
        return globalProcessingCardProvider.issueEmptyVirtualCard(customer, cardName, currency).get(WS_TIMEOUT);
    }

    private CardCreationResponse getPrepaidPlasticCard(Customer customer, String cardName, long amount, Currency currency) {
        return globalProcessingCardProvider.issuePrepaidPlasticCard(customer, cardName, amount, currency).get(WS_TIMEOUT);
    }


    private Customer createCustomer() {
        return new Customer("4921142172244", new Date(), "Mr", "Corban", "Dallas",
                "adress1", "adress2", "83004", "Berlin", "me@corbandalas.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "DE");
    }


    private Currency getCurrency() throws Exception {
        return Await.result(currencyRepository.retrieveById("EUR"), Duration.apply("1000 ms")).get();
    }

    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property;", resultSet -> {
        }, throwable -> {
            throwable.printStackTrace();
        });
    }
}
