package controllers;

import dto.BaseAPIResponse;
import dto.PropertyListResponse;
import dto.PropertyResponse;
import exception.*;
import model.*;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;
import provider.CardProvider;
import provider.dto.CardCreationResponse;
import provider.dto.CardLoadResponse;
import provider.dto.CardUnloadResponse;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import repository.PropertyRepository;
import services.OperationService;
import util.CurrencyUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static configs.ReturnCodes.*;

/**
 * Base Play controller
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */

public class BaseController extends play.mvc.Controller {

    protected Results.Status createKycLimitResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(KYC_RESTRICTION_TEXT, "" + KYC_RESTRICTION_CODE)));
    }


    protected Results.Status createIncorrectCurrencyResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_CURRENCY_TEXT, "" + INCORRECT_CURRENCY_CODE)));
    }

    protected Results.Status createIncorrectCountryResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_COUNTRY_TEXT, "" + INCORRECT_COUNTRY_CODE)));
    }

    protected Results.Status createAlreadyRegisteredCustomerAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(ALREADY_REGISTERED_CUSTOMER_ACCOUNT_TEXT, "" + ALREADY_REGISTERED_CUSTOMER_ACCOUNT_CODE)));
    }

    protected Results.Status createWrongCardResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_CARD_TEXT, "" + INCORRECT_CARD_CODE)));
    }

    protected Results.Status createWrongKYCResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_KYC_TEXT, "" + INCORRECT_KYC_CODE)));
    }

    protected Results.Status createLimitsExceededResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(LIMITS_EXCEEDED_TEXT, "" + LIMITS_EXCEEDED_CODE)));
    }

    protected Results.Status createGeneralErrorResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(GENERAL_ERROR_TEXT, "" + GENERAL_ERROR_CODE)));
    }

    protected Results.Status createWrongCustomerAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(WRONG_CUSTOMER_ACCOUNT_TEXT, "" + WRONG_CUSTOMER_ACCOUNT_CODE)));
    }

    protected Results.Status createPasswordMismatchResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(PASSWORD_MISMATCH_TEXT, "" + PASSWORD_MISMATCH_CODE)));
    }

    protected Results.Status createPasswordEqualsToExistedResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(PASSWORD_EQUALS_TO_EXISTED_TEXT, "" + PASSWORD_EQUALS_TO_EXISTED_CODE)));
    }


    protected Results.Status createWrongRequestFormatResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(WRONG_REQUEST_FORMAT_TEXT, "" + WRONG_REQUEST_FORMAT_CODE)));
    }

    protected Results.Status createWrongPhoneNumberResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_PHONE_NUMBER_TEXT, "" + INCORRECT_PHONE_NUMBER_CODE)));
    }

    protected Results.Status createPasswordExceededResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(PASSWORD_ATTEMPTS_EXCEEDED_TEXT, "" + PASSWORD_ATTEMPTS_EXCEEDED_CODE)));
    }

    protected Result createRedirect(String url) {
        return redirect(url);
    }

    protected Results.Status createWrongEncKeyResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(WRONG_REQUEST_ENCKEY_TEXT, "" + WRONG_REQUEST_ENCKEY_CODE)));
    }


    protected BaseAPIResponse createResponse(String code, String text) {
        return new BaseAPIResponse(text, code);
    }

    protected PropertyListResponse createResponse(String code, String text, List<Property> propertyList) {
        return new PropertyListResponse(text, code, propertyList);
    }

    protected PropertyResponse createResponse(String code, String text, Property property) {
        return new PropertyResponse(text, code, property);
    }

    protected Results.Status createIncorrectAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_ACCOUNT_TEXT, "" + INCORRECT_ACCOUNT_CODE)));
    }

    protected F.Promise<Result> returnRecover(F.Promise<Result> result) {
        return result.recover(throwable -> {
                    Logger.error("Error: ", throwable);

                    if (throwable instanceof WrongCardException) {
                        return createWrongCardResponse();
                    }

                    if (throwable instanceof WrongCountryException) {
                        return createIncorrectCountryResponse();
                    }

                    if (throwable instanceof CustomerAlreadyRegisteredException) {
                        return createAlreadyRegisteredCustomerAccountResponse();
                    }

                    if (throwable instanceof CustomerNotRegisteredException) {
                        return createWrongCustomerAccountResponse();
                    }

                    if (throwable instanceof WrongPhoneNumberException) {
                        return createWrongPhoneNumberResponse();
                    }

                    return createGeneralErrorResponse();
                }

        );
    }


    protected F.Promise<F.Tuple<Operation, Transaction>> makePayment(String phone, long amount, String currencyCode, boolean isBankDeposit, Long cardID,
                                                                     CustomerRepository customerRepository, CurrencyRepository currencyRepository,
                                                                     CardProvider cardProvider, CardRepository cardRepository, OperationService operationService) {

        final F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(phone));

        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(currencyCode));

        return customerPromise.zip(currencyPromise).flatMap(data -> {

            if (!data._1.isPresent()) {
                Logger.error("Couldn't find customer for specified phone");
                //TODO: need some action here
                return F.Promise.throwing(new CustomerNotRegisteredException());
            }

            final Customer customer = data._1.get();

            if (!data._2.isPresent()) {
                Logger.error("Couldn't find currency for specified code");
                return F.Promise.throwing(new WrongCurrencyException());
            }

            final Currency currency = data._2.get();

            if (customer.getKyc().equals(KYC.NONE)) {
                Logger.error("Specified customer is NONE KYC");
                return F.Promise.throwing(new WrongKYCException());
            }

            return F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId())).flatMap(cards -> {
                final Card card;

                if (cardID == null) {
                    if (cards.size() > 0) {
                        if (customer.getKyc().equals(KYC.SIMPLIFIED_DUE_DILIGENCE)) {
                            Logger.error("Specified SIMPLIFIED_DUE_DILIGENCE customer already has card");
                            return F.Promise.throwing(new WrongKYCException());
                        }

                        final Optional<Card> defaultCardOpt = StreamSupport.stream(cards.spliterator(), true).filter(Card::getCardDefault).findFirst();

                        if (!defaultCardOpt.isPresent()) {
                            Logger.error("Couldn't find default card for specified phone");
                            return F.Promise.throwing(new WrongCardException());
                        }

                        card = defaultCardOpt.get();
                    } else {
                        return cardProvider.issuePrepaidVirtualCard(customer, "new card", amount, currency).flatMap(cardCreationResponse ->
                                F.Promise.wrap(cardRepository.create(new Card(0L, cardCreationResponse.getToken(), customer.getId(),
                                        CardType.VIRTUAL, CardBrand.VISA, true, new Date(), "alias", true, "info", currency.getId(),
                                        "deliveryAddress1", "deliveryAddress2", "deliveryAddress3", "deliveryCountry"))))
                                .flatMap(crd -> {
                                    cardProvider.regenerateCardDetails(crd);
                                    return operationService.createDepositOperation(crd, amount, currency, "", "Debit card deposit");
                                });
                    }
                } else {
                    final Optional<Card> cardOpt = cards.stream().filter(itm -> itm.getId().equals(cardID)).findFirst();

                    if (!cardOpt.isPresent()) {
                        Logger.error("Couldn't find card for specified ID");
                        return F.Promise.throwing(new WrongCardException());
                    }

                    card = cardOpt.get();
                }


                final F.Promise<CardLoadResponse> cardLoadPromise;
                if (card.getType().equals(CardType.VIRTUAL)) {

                    if (isBankDeposit) {
                        cardLoadPromise = cardProvider.loadVirtualCardFromBank(card, amount, currency, "Debit card deposit");
                    } else {
                        cardLoadPromise = cardProvider.loadVirtualCardFromCard(card, amount, currency, "Debit card deposit");
                    }

                } else {

                    if (isBankDeposit) {
                        cardLoadPromise = cardProvider.loadPlasticCardFromBank(card, amount, currency, "Debit card deposit");
                    } else {
                        cardLoadPromise = cardProvider.loadPlasticCardFromCard(card, amount, currency, "Debit card deposit");
                    }
                }

                return cardLoadPromise.flatMap(cardLoadResponse -> operationService.createDepositOperation(card,
                        amount, currency, "" + System.currentTimeMillis(), "Debit card deposit"));
            });
        });
    }

    protected F.Promise<F.Tuple<Operation, Transaction>> makeWithdraw(long amount, Currency currency, Card cardFrom, String description,
                                                                      CardProvider cardProvider, OperationService operationService) {


        final F.Promise<CardUnloadResponse> cardUnloadPromise;

        if (cardFrom.getType().equals(CardType.VIRTUAL)) {

            cardUnloadPromise = cardProvider.unloadVirtualCard(cardFrom, amount, currency, description);

        } else {

            cardUnloadPromise = cardProvider.unloadPlasticCard(cardFrom, amount, currency, description);
        }

        return cardUnloadPromise.flatMap(cardLoadResponse -> operationService.createWithdrawOperation(cardFrom,
                amount, currency, "" + System.currentTimeMillis(), description));
    }


    protected F.Promise<F.Tuple<Card, CardCreationResponse>> cardPurchase(String phone, long amount, String currencyCode, CardType cardType, CustomerRepository customerRepository, CurrencyRepository currencyRepository, CardProvider cardProvider, CardRepository cardRepository) {

        final F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(phone));

        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(currencyCode));

        return customerPromise.zip(currencyPromise).flatMap(data -> {

            if (!data._1.isPresent()) {
                Logger.error("Couldn't find customer for specified phone");
                //TODO: need some action here
                return F.Promise.throwing(new CustomerNotRegisteredException());
            }

            final Customer customer = data._1.get();

            if (!data._2.isPresent()) {
                Logger.error("Couldn't find currency for specified code");
                return F.Promise.throwing(new WrongCurrencyException());
            }

            final Currency currency = data._2.get();

            F.Promise<F.Tuple<Card, CardCreationResponse>> cardPromise = null;

            if (amount > 0) {

                if (cardType.equals(CardType.VIRTUAL)) {

                    cardPromise = cardProvider.issuePrepaidVirtualCard(customer, "Virtual card", amount, currency).flatMap(cardCreationResponse ->
                            F.Promise.wrap(cardRepository.create(new Card(0L, cardCreationResponse.getToken(), customer.getId(),
                                    CardType.VIRTUAL, CardBrand.VISA, true, new Date(), "alias", true, "info", currency.getId(),
                                    customer.getAddress1(), customer.getAddress2(), customer.getAddress2(), customer.getCountry_id()))).zip(F.Promise.pure(cardCreationResponse)));

                } else {

                    Calendar instance = Calendar.getInstance();

                    instance.add(Calendar.DAY_OF_YEAR, 720);

                    cardPromise = cardProvider.issuePrepaidVirtualCard(customer, "Plastic card", amount, currency).flatMap(cardCreationResponse ->
                            F.Promise.wrap(cardRepository.create(new Card(0L, cardCreationResponse.getToken(), customer.getId(),
                                    CardType.PLASTIC, CardBrand.VISA, true, new Date(), "alias", true, "info", currency.getId(),
                                    customer.getAddress1(), customer.getAddress2(), customer.getAddress2(), customer.getCountry_id()))).zip(F.Promise.pure(cardCreationResponse)));

                    cardPromise.map(card -> {
                        cardProvider.convertVirtualToPlastic(customer, card._1, new Date(), false, instance.getTime());
                        return card;
                    });

                }

            } else {
                if (cardType.equals(CardType.VIRTUAL)) {
                    cardPromise = cardProvider.issueEmptyVirtualCard(customer, "Virtual card", currency).flatMap(cardCreationResponse ->
                            F.Promise.wrap(cardRepository.create(new Card(0L, cardCreationResponse.getToken(), customer.getId(),
                                    CardType.VIRTUAL, CardBrand.VISA, true, new Date(), "alias", true, "info", currency.getId(),
                                    customer.getAddress1(), customer.getAddress2(), customer.getAddress2(), customer.getCountry_id()))).zip(F.Promise.pure(cardCreationResponse)));
                } else {

                    Calendar instance = Calendar.getInstance();

                    instance.add(Calendar.DAY_OF_YEAR, 720);

                    cardPromise = cardProvider.issueEmptyVirtualCard(customer, "Plastic card", currency).flatMap(cardCreationResponse ->
                            F.Promise.wrap(cardRepository.create(new Card(0L, cardCreationResponse.getToken(), customer.getId(),
                                    CardType.PLASTIC, CardBrand.VISA, true, new Date(), "alias", true, "info", currency.getId(),
                                    customer.getAddress1(), customer.getAddress2(), customer.getAddress2(), customer.getCountry_id()))).zip(F.Promise.pure(cardCreationResponse)));

                    cardPromise.flatMap(card -> cardProvider.convertVirtualToPlastic(customer, card._1, new Date(), false, instance.getTime()));

                }
            }


            cardPromise.flatMap(card -> cardProvider.regenerateCardDetails(card._1));

            return cardPromise;


        });
    }


    protected F.Promise<Boolean> checkDeposit(Customer customer, Card card, long amount, Optional<Currency> currency, PropertyRepository propertyRepository, CurrencyRepository currencyRepository, OperationService operationService) {


        final F.Promise<Optional<Currency>> limitCurrencyPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.currency")).flatMap(rez -> F.Promise.wrap(currencyRepository.retrieveById(rez.get().getValue())));
        final F.Promise<Double> depositSumPromise = operationService.getDepositSumByCard(card);
        final F.Promise<Optional<Currency>> cardCurrencyPromise = F.Promise.wrap(currencyRepository.retrieveById(card.getCurrencyId()));
        final F.Promise<Optional<Property>> limitAmountPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.kyc." + customer.getKyc().name()));


        return depositSumPromise.zip(cardCurrencyPromise).zip(limitCurrencyPromise).zip(limitAmountPromise).map(res -> {

            final Double depositSum = res._1._1._1;
            final Optional<Currency> limitCurrency = res._1._1._2;
            final Optional<Currency> cardCurrency = res._1._2;

            final Property property = res._2.orElseThrow(WrongPropertyException::new);

            final long convertedDepositAmount = CurrencyUtil.convert(amount, currency, cardCurrency);
            final long convertedLimitAmount = CurrencyUtil.convert(Long.parseLong(property.getValue()), limitCurrency, cardCurrency);

            return depositSum.longValue() + convertedDepositAmount < convertedLimitAmount;

        });
    }

    protected F.Promise<Boolean> checkDepositToNew(Customer customer, long amount, Optional<Currency> currency, CurrencyRepository currencyRepository, PropertyRepository propertyRepository) {


        final F.Promise<Optional<Currency>> limitCurrencyPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.currency")).flatMap(rez -> F.Promise.wrap(currencyRepository.retrieveById(rez.get().getValue())));
        final F.Promise<Optional<Property>> limitAmountPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.worldpay.deposit.card.kyc." + customer.getKyc().name()));


        return limitCurrencyPromise.zip(limitAmountPromise).map(res -> {

            final Optional<Currency> limitCurrency = res._1;

            final Property property = res._2.orElseThrow(WrongPropertyException::new);

            final long convertedDepositAmount = CurrencyUtil.convert(amount, currency, limitCurrency);
            final long convertedLimitAmount = Long.parseLong(property.getValue());

            return convertedDepositAmount < convertedLimitAmount;

        });
    }


    protected F.Promise<Boolean> checkCardNumberAndDepositSum(Customer customer, CardType cardType, long amount, Optional<Currency> currency, CurrencyRepository currencyRepository, CardRepository cardRepository, PropertyRepository propertyRepository) {
        return checkDepositToNew(customer, amount, currency, currencyRepository, propertyRepository).zip(checkCardPurchaseNumber(customer, cardType, cardRepository, propertyRepository)).map(rez -> rez._1 && rez._2);
    }


    protected F.Promise<Boolean> checkCardPurchaseNumber(Customer customer, CardType cardType, CardRepository cardRepository, PropertyRepository propertyRepository) {


        final F.Promise<Long> virtualCardNumberPromise = F.Promise.wrap(cardRepository.countCardsByType(customer.getId(), CardType.VIRTUAL));
        final F.Promise<Long> plasticCardNumberPromise = F.Promise.wrap(cardRepository.countCardsByType(customer.getId(), CardType.PLASTIC));

        F.Promise<Optional<Property>> cardLimitNumberPromise = null;

        if (customer.getKyc().equals(KYC.SIMPLIFIED_DUE_DILIGENCE)) {
            cardLimitNumberPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.msp.card.SIMPLIFIED_DUE_DILIGENCE"));
        } else {
            cardLimitNumberPromise = F.Promise.wrap(propertyRepository.retrieveById("limits.msp.card.FULL_DUE_DILIGENCE." + cardType.name()));
        }

        return virtualCardNumberPromise.zip(plasticCardNumberPromise).zip(cardLimitNumberPromise).map(res -> {

            long virtualCardNumber = res._1._1;
            long plasticCardNumber = res._1._2;

            long cardLimit = Long.parseLong(res._2.get().getValue());

            if (customer.getKyc().equals(KYC.SIMPLIFIED_DUE_DILIGENCE)) {
                return virtualCardNumber + 1 <= cardLimit && plasticCardNumber + 1 <= cardLimit;
            } else {
                if (cardType.equals(CardType.VIRTUAL)) {
                    return virtualCardNumber + 1 <= cardLimit;
                } else if (cardType.equals(CardType.PLASTIC)) {
                    return plasticCardNumber + 1 <= cardLimit;
                }
            }

            return false;
        });

    }


}
