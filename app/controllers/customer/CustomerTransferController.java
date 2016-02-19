package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.wordnik.swagger.annotations.Api;
import configs.Constants;
import controllers.BaseController;
import dto.customer.TransferOwnCards;
import model.Customer;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;

/**
 * API customer transfer controller
 * @author ra created 19.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/transfer", description = "Customer transfer methods")
public class CustomerTransferController extends BaseController {

    @With(BaseCustomerApiAction.class)
    public F.Promise<Result> transferOwnCards() {
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
