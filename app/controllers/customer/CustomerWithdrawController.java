package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.customer.*;
import model.Card;
import model.Currency;
import model.Customer;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import repository.PropertyRepository;
import services.OperationService;
import services.PaylikePaymentService;

import java.util.List;
import java.util.Optional;

import static configs.ReturnCodes.*;


/**
 * API customer withdraw controller
 *
 * @author corbandalas created 19.04.2017.
 * @since 0.5.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/card/withdraw", description = "Withdraw payment methods")
public class CustomerWithdrawController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CardProvider cardProvider;

    @Inject
    PropertyRepository propertyRepository;

    @Inject
    PaylikePaymentService paylikePaymentService;

    @Inject
    OperationService operationService;

    @Inject
    CacheApi cache;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "cardWithdraw",
            value = "Card customer withdraw method",
            notes = "Allows to withdraw funds from specified card",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerWithdrawResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerWithdrawResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = INCORRECT_KYC_CODE, message = INCORRECT_KYC_TEXT),
            @ApiResponse(code = LIMITS_EXCEEDED_CODE, message = LIMITS_EXCEEDED_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.CustomerWithdraw", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> cardWithdraw() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerWithdraw request;
        try {
            request = Json.fromJson(jsonNode, CustomerWithdraw.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getAmount() == null
                || StringUtils.isBlank(request.getCurrency())
                || request.getCardFrom() == null
                || StringUtils.isBlank(request.getOrderId())
                || StringUtils.isBlank(request.getDescription())
                ) {

            Logger.error("Missing parameters");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getAmount() <= 0) {
            Logger.error("Negative amount format");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final F.Promise<List<Card>> cardsPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(request.getCurrency()));

        final F.Promise<Result> result = cardsPromise.zip(currencyPromise).flatMap(data -> {

            final Optional<Currency> currency = data._2;

            final List<Card> cards = data._1;

            if (!currency.isPresent()) {
                Logger.error("Specified currency doesn't exist");
                return F.Promise.pure(createIncorrectCurrencyResponse());
            }


            final Optional<Card> cardFrom = cards.stream().filter(itm -> itm.getId().equals(request.getCardFrom())).findFirst();

            if (!cardFrom.isPresent()) {
                Logger.error("Specified cardTo doesn't belong to customer");
                return F.Promise.pure(createWrongCardResponse());
            }

            if (customer.getKyc().equals(KYC.NONE)) {
                Logger.error("Incorrect KYC level");
                return F.Promise.pure(createWrongKYCResponse());
            }

            return makeWithdraw(request.getAmount(),
                    currency.get(), cardFrom.get(), request.getDescription(), cardProvider, operationService).map(res -> ok(Json.toJson(new CustomerWithdrawResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res._1.getId()))));

        });

        return returnRecover(result);
    }

}