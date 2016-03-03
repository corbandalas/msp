package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.customer.CustomerTransaction;
import dto.customer.CustomerTransactionFilter;
import dto.customer.CustomerTransactionResponse;
import model.Card;
import model.Customer;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.CardRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static configs.ReturnCodes.*;


/**
 * Customer transaction api controller
 *
 * @author ra created 17.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/transaction", description = "Customer transactions methods")
public class CustomerTransactionController extends BaseController {
    @Inject
    CardProvider cardProvider;

    @Inject
    CardRepository cardRepository;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "listCustomerTransactions",
            value = "Get customer transactions by card",
            notes = "Allows customer to retrieve card transactions",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerTransactionResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerTransactionResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "transactions request", required = true, dataType = "dto.customer.CustomerTransactionFilter", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> retrieveByCard() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerTransactionFilter transactionFilter;
        try {
            transactionFilter = Json.fromJson(jsonNode, CustomerTransactionFilter.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (transactionFilter.getCardId() == null) {
            Logger.error("Missing parameter, cardId is not specified");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final Date parsedFromDate;
        final Date parsedToDate;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            parsedFromDate = simpleDateFormat.parse(transactionFilter.getFromDate());
            parsedToDate = simpleDateFormat.parse(transactionFilter.getToDate());
        } catch (ParseException e) {
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final F.Promise<List<Card>> cardListPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final F.Promise<Optional<Card>> cardPromise = F.Promise.wrap(cardRepository.retrieveById(transactionFilter.getCardId()));

        final F.Promise<Result> result = cardPromise.zip(cardListPromise).flatMap(data -> {
            final Card card;
            if (data._1.isPresent())
                card = data._1.get();
            else
                return F.Promise.pure(createWrongCardResponse());

            if (!data._2.stream().map(Card::getId).anyMatch(id -> id.equals(card.getId()))) {
                return F.Promise.pure(createWrongCardResponse());
            }

            return cardProvider.getCardTransactions(card, parsedFromDate, parsedToDate).map(transactionListResponse
                    -> ok(Json.toJson(new CustomerTransactionResponse(SUCCESS_TEXT, "" + SUCCESS_CODE,
                    (transactionListResponse.getList() != null) ? transactionListResponse.getList().stream()
                            .map(CustomerTransaction::new).collect(Collectors.toList()) : new ArrayList<>()))));
        });

        return returnRecover(result);
    }
}
