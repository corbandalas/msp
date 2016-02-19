package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import dto.customer.CustomerTransactionResponse;
import dto.customer.TransferOwnCards;
import exception.WrongAccountException;
import exception.WrongCurrencyException;
import exception.WrongPropertyException;
import model.*;
import model.enums.OperationType;
import model.enums.TransactionType;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.*;
import util.CurrencyUtil;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * API customer transfer controller
 *
 * @author ra created 19.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/transfer", description = "Customer transfer methods")
public class CustomerTransferController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    TransactionRepository transactionRepository;

    @Inject
    OperationRepository operationRepository;

    @Inject
    CardProvider cardProvider;

    @Inject
    AccountRepository accountRepository;

    @Inject
    PropertyRepository propertyRepository;


    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "transferOwnCards",
            value = "customer transfer between own cards",
            notes = "Allows customer to transfer funds between own cards",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = TransferOwnCards.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = BaseAPIResponse.class),
            @ApiResponse(code = 1, message = "Missing parameters"),
            @ApiResponse(code = 2, message = "Wrong request format"),
            @ApiResponse(code = 4, message = "Specified cards is the same"),
            @ApiResponse(code = 5, message = "Specified currency doesn't exist"),
            @ApiResponse(code = 6, message = "General error"),
            @ApiResponse(code = 7, message = "Specified card doesn't belong to customer")
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.CustomerTransactionFilter", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> transferOwnCards() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final TransferOwnCards request;
        try {
            request = Json.fromJson(jsonNode, TransferOwnCards.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(ok(Json.toJson(createResponse("2", "Wrong request format"))));
        }

        if (request.getCardFrom() == null || request.getCardTo() == null || request.getAmount() == null
                || StringUtils.isBlank(request.getCurrency()) || StringUtils.isBlank(request.getDescription())
                || StringUtils.isBlank(request.getOrderId())) {
            Logger.error("Missing parameters");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing parameters"))));
        }

        if (request.getAmount() <= 0) {
            Logger.error("Wrong request format");
            return F.Promise.pure(ok(Json.toJson(createResponse("2", "negative amount"))));
        }

        if (request.getCardFrom().equals(request.getCardTo())) {
            Logger.error("Specified cards is the same");
            return F.Promise.pure(ok(Json.toJson(createResponse("4", "Specified cards is the same"))));
        }

        final F.Promise<List<Card>> cardsPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(request.getCurrency()));

        final F.Promise<Result> result = cardsPromise.zip(currencyPromise).flatMap(data -> {
            if (!data._2.isPresent()) {
                Logger.error("Specified currency doesn't exist");
                return F.Promise.pure(ok(Json.toJson(createResponse("5", "Specified currency doesn't exist"))));
            }

            final Optional<Card> cardFrom = data._1.stream().filter(itm -> itm.getId().equals(request.getCardFrom())).findFirst();
            if (!cardFrom.isPresent()) {
                Logger.error("Specified cardFrom doesn't belong to customer");
                return F.Promise.pure(ok(Json.toJson(createResponse("7", "Specified cardFrom doesn't belong to customer"))));
            }

            final Optional<Card> cardTo = data._1.stream().filter(itm -> itm.getId().equals(request.getCardTo())).findFirst();
            if (!cardTo.isPresent()) {
                Logger.error("Specified cardTo doesn't belong to customer");
                return F.Promise.pure(ok(Json.toJson(createResponse("7", "Specified cardTo doesn't belong to customer"))));
            }

            return cardProvider.transferBetweenCards(cardFrom.get(), cardTo.get(), request.getAmount(), data._2.get(), request.getDescription()).map(providerResponse -> {
                createTransferOperation(cardFrom.get(), cardTo.get(), request.getAmount(), data._2.get(), request.getOrderId(), request.getDescription());

                return ok(Json.toJson(createResponse("0", "Transfer was completed successfully")));
            });

        });

        return result.recover(throwable -> {
            Logger.error("General error: ", throwable);

            return ok(Json.toJson(createResponse("6", "General error")));
        });
    }

    private F.Promise createTransferOperation(Card sourceCard, Card destinationCard, Long amount, Currency currency, String orderId, String description) {
        final F.Promise<Optional<Account>> cardAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.card"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getId())));
        final F.Promise<Optional<Account>> transferAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.transfer"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));

        return cardAccountPromise.zip(transferAccountPromise).flatMap(accounts -> {
            final Account cardAccount = accounts._1.orElseThrow(WrongAccountException::new);
            final Account transferAccount = accounts._2.orElseThrow(WrongAccountException::new);

            return getExchangeRates(currency, cardAccount, transferAccount).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.TRANSFER, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> sourceTransactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                cardAccount.getId(), transferAccount.getId(), sourceCard.getId(), rates._1, rates._2, TransactionType.TRANSFER_FROM)));
                                final F.Promise<Transaction> destinationTransactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                transferAccount.getId(), cardAccount.getId(), destinationCard.getId(), rates._2, rates._1, TransactionType.TRANSFER_FROM)));

                                return F.Promise.sequence(sourceTransactionPromise, destinationTransactionPromise).map(trans -> new F.Tuple(operation, trans));
                            }));
        });
    }

    private F.Promise<F.Tuple<Double, Double>> getExchangeRates(Currency currency, Account cardAccount, Account transferAccount) {
        final F.Promise<Double> cardAccountExchangeRatePromise;
        if (cardAccount.getCurrencyId().equals(currency.getId()))
            cardAccountExchangeRatePromise = F.Promise.pure(1.0);
        else {
            cardAccountExchangeRatePromise = F.Promise.wrap(currencyRepository.retrieveById(cardAccount.getCurrencyId())).map(accCurrency ->
                    CurrencyUtil.getExchangeRate(currency, accCurrency.orElseThrow(WrongCurrencyException::new)).doubleValue());
        }

        final F.Promise<Double> transferAccountExchangeRatePromise;
        if (transferAccount.getCurrencyId().equals(currency.getId()))
            transferAccountExchangeRatePromise = F.Promise.pure(1.0);
        else {
            transferAccountExchangeRatePromise = F.Promise.wrap(currencyRepository.retrieveById(transferAccount.getCurrencyId())).map(accCurrency ->
                    CurrencyUtil.getExchangeRate(currency, accCurrency.orElseThrow(WrongCurrencyException::new)).doubleValue());
        }

        return cardAccountExchangeRatePromise.zip(transferAccountExchangeRatePromise);
    }



    @With(BaseCustomerApiAction.class)
    public F.Promise<Result> transferToAnotherCard() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final TransferOwnCards request;
        try {
            request= Json.fromJson(jsonNode,TransferOwnCards.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ",e);
            return F.Promise.pure(ok(Json.toJson(createResponse("2","Wrong request format"))));
        }

        if(request.getCardFrom().equals(request.getCardTo())) {
            Logger.error("Specified cards is the same");
        }

        return null;
    }




}
