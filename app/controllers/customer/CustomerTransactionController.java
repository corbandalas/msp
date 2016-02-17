package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import dto.customer.CustomerTransaction;
import dto.customer.CustomerTransactionFilter;
import dto.customer.CustomerTransactionResponse;
import exception.WrongCardException;
import model.Card;
import model.Customer;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import provider.dto.CardTransactionListResponse;
import repository.CardRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = BaseAPIResponse.class),
            @ApiResponse(code = 1, message = "Missing parameters"),
            @ApiResponse(code = 2, message = "Wrong request format"),
            @ApiResponse(code = 4, message = "Specified card does not exist"),
            @ApiResponse(code = 5, message = "Specified card doesn't belong for authorized customer cards"),
            @ApiResponse(code = 6, message = "General error")
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
            return F.Promise.pure(ok(Json.toJson(createResponse("2", "Wrong request format"))));
        }

        if (transactionFilter.getCardId() == null) {
            Logger.error("Missing parameter, cardId is not specified");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing parameter, cardId is not specified"))));
        }

        final Date parsedFromDate;
        final Date parsedToDate;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            parsedFromDate = simpleDateFormat.parse(transactionFilter.getFromDate());
            parsedToDate = simpleDateFormat.parse(transactionFilter.getToDate());
        } catch (ParseException e) {
            return F.Promise.pure(badRequest(Json.toJson(createResponse("2", "Wrong request format"))));
        }

        final F.Promise<List<Card>> cardListPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final F.Promise<Optional<Card>> cardPromise = F.Promise.wrap(cardRepository.retrieveById(transactionFilter.getCardId()));

        final F.Promise<Result> result = cardPromise.zip(cardListPromise).flatMap(data -> {
            Card card = data._1.orElseThrow(WrongCardException::new);
            if (!data._2.stream().map(Card::getId).anyMatch(id -> id.equals(card.getId()))) {
                return F.Promise.pure(badRequest(Json.toJson(createResponse("5", "Specified card doesn't belong for authorized customer cards"))));
            }

            return cardProvider.getCardTransactions(card, parsedFromDate, parsedToDate).map(transactionListResponse
                    -> ok(Json.toJson(new CustomerTransactionResponse("OK", "0", transactionListResponse.getList().stream()
                    .map(CustomerTransaction::new).collect(Collectors.toList())))));
        });

        return result.recover(throwable ->

                {
                    Logger.error("Error: ", throwable);

                    if (throwable instanceof WrongCardException) {
                        return ok(Json.toJson(createResponse("4", "Specified card does not exist")));
                    }

                    return ok(Json.toJson(createResponse("6", "General error")));
                }

        );
    }
}
