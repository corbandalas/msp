package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import dto.Authentication;
import model.Account;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import repository.AccountRepository;
import util.SecurityUtil;

/**
 * API account controller
 *
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
public class AccountController extends BaseController {

    @Inject
    private AccountRepository accountRepository;

    public F.Promise<Result> create() {
        final JsonNode jsonBody = (JsonNode) ctx().args.get("jsonBody");
        final Account authAccount = (Account) ctx().args.get("authAccount");
        final Authentication authData = (Authentication) ctx().args.get("authData");

        final Account account = Json.fromJson(jsonBody, Account.class);

        //TODO: Validate account fields

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authAccount.getId().toString(),
                account.getName(), authAccount.getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.throwing(new Exception("Specified account does not exist or inactive"));
        }

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.create(account)).map(account1 -> ok(Json.toJson(createResponse("0", "account created successfully"))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("1", error.getMessage())));
        });
    }
}
