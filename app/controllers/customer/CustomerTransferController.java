package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.customer.CustomerTransferOwnCards;
import dto.customer.CustomerTransferResponse;
import dto.customer.TransferToAnotherCard;
import exception.CustomerNotRegisteredException;
import exception.WrongCardException;
import exception.WrongCurrencyException;
import model.Card;
import model.Currency;
import model.Customer;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import services.OperationService;

import java.util.List;
import java.util.Optional;

import static configs.ReturnCodes.*;


/**
 * API customer transfer controller
 *
 * @author ra created 19.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/transfer", description = "Card to card transfer methods")
public class CustomerTransferController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    CardProvider cardProvider;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    OperationService operationService;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "transferOwnCards",
            value = "Transfer between own cards",
            notes = "Method allows cardholder to transfer funds between his/her own cards",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerTransferResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerTransferResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.CustomerTransferOwnCards", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> transferOwnCards() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerTransferOwnCards request;
        try {
            request = Json.fromJson(jsonNode, CustomerTransferOwnCards.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getCardFrom() == null || request.getCardTo() == null || request.getAmount() == null
                || StringUtils.isBlank(request.getCurrency()) || StringUtils.isBlank(request.getDescription())
                || StringUtils.isBlank(request.getOrderId())) {

            Logger.error("Missing parameters");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getAmount() <= 0) {
            Logger.error("Negative amount format");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getCardFrom().equals(request.getCardTo())) {
            Logger.error("Specified cards is the same");
            return F.Promise.pure(createWrongCardResponse());
        }

        final F.Promise<List<Card>> cardsPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(request.getCurrency()));

        final F.Promise<Result> result = cardsPromise.zip(currencyPromise).flatMap(data -> {
            if (!data._2.isPresent()) {
                Logger.error("Specified currency doesn't exist");
                return F.Promise.pure(createIncorrectCurrencyResponse());
            }

            final Optional<Card> cardFrom = data._1.stream().filter(itm -> itm.getId().equals(request.getCardFrom())).findFirst();
            if (!cardFrom.isPresent()) {
                Logger.error("Specified cardFrom doesn't belong to customer");
                return F.Promise.pure(createWrongCardResponse());
            }

            final Optional<Card> cardTo = data._1.stream().filter(itm -> itm.getId().equals(request.getCardTo())).findFirst();
            if (!cardTo.isPresent()) {
                Logger.error("Specified cardTo doesn't belong to customer");
                return F.Promise.pure(createWrongCardResponse());
            }

            return cardProvider.transferBetweenCards(cardFrom.get(), cardTo.get(), request.getAmount(), data._2.get(),
                    request.getDescription()).flatMap(providerResponse -> operationService.createTransferOperation(cardFrom.get(),
                    cardTo.get(), request.getAmount(), data._2.get(), request.getOrderId(), request.getDescription())
                    .map(res -> ok(Json.toJson(new CustomerTransferResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res._1.getId())))));
        });

        return returnRecover(result);
    }


    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "transferToAnotherCustomer",
            value = "Transfer to another registered cardholder default card",
            notes = "Method allows cardholder to transfer funds to another registered cardholder default card",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerTransferResponse.class
    )
    @ApiResponses(value = {

            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerTransferResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = KYC_RESTRICTION_CODE, message = KYC_RESTRICTION_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.TransferToAnotherCard", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> transferToAnotherCard() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final TransferToAnotherCard request;
        try {
            request = Json.fromJson(jsonNode, TransferToAnotherCard.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getCardFrom() == null || request.getAmount() == null
                || StringUtils.isBlank(request.getCurrency()) || StringUtils.isBlank(request.getDescription())
                || StringUtils.isBlank(request.getOrderId()) || StringUtils.isBlank(request.getPhone())) {
            Logger.error("Missing parameters");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getAmount() <= 0) {
            Logger.error("Negative amount");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final F.Promise<Optional<Customer>> receiverCustomerPromise = F.Promise.wrap(customerRepository.retrieveById(request.getPhone()));
        final F.Promise<Optional<Card>> receiverCardPromise = F.Promise.wrap(cardRepository.retrieveDefaultCard(request.getPhone()));

        final F.Promise<List<Card>> senderCardsPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(request.getCurrency()));


        final F.Promise<Result> result = receiverCustomerPromise.zip(receiverCardPromise).zip(senderCardsPromise).zip(currencyPromise).flatMap(data -> {

            final Customer receiverCustomer = data._1._1._1.orElseThrow(CustomerNotRegisteredException::new);

            if (!receiverCustomer.getActive()) {
                throw new CustomerNotRegisteredException("Receiver account is not active");
            }

            final Card cardTo = data._1._1._2.orElseThrow(WrongCardException::new);

            final List<Card> senderCards = data._1._2;
            final Currency currency = data._2.orElseThrow(WrongCurrencyException::new);


            final Optional<Card> cardFrom = senderCards.stream().filter(itm -> itm.getId().equals(request.getCardFrom())).findFirst();
            if (!cardFrom.isPresent()) {
                Logger.error("Specified cardFrom doesn't belong to customer");
                return F.Promise.pure(createWrongCardResponse());
            }

            if (!receiverCustomer.getKyc().equals(KYC.FULL_DUE_DILIGENCE)) {
                Logger.error("Receiver is not allowed to get funds due to KYC restrictions");
                return F.Promise.pure(createKycLimitResponse());
            }

            return cardProvider.transferBetweenCards(cardFrom.get(), cardTo, request.getAmount(), currency,
                    request.getDescription()).flatMap(providerResponse -> operationService.createTransferOperation(cardFrom.get(),
                    cardTo, request.getAmount(), currency, request.getOrderId(), request.getDescription())
                    .map(res -> ok(Json.toJson(new CustomerTransferResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res._1.getId())))));


        });

        return returnRecover(result);

    }
}