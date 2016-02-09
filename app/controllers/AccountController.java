package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import dto.Authentication;
import model.Account;
import org.apache.commons.lang3.StringUtils;
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
        final JsonNode jsonNode = request().body().asJson();

        final Authentication auth = Json.fromJson(jsonNode.get("auth"), Authentication.class);
        if (auth == null || auth.getAccountId() == null || StringUtils.isBlank(auth.getEnckey())) {
            Logger.error("Authentication data is missing");
            return F.Promise.pure(ok(Json.toJson(createResponse("Authentication data is missing", "1"))));
        }

        final Account account = Json.fromJson(jsonNode, Account.class);

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.retrieveById(auth.getAccountId())).flatMap(authAcc -> {
            if (authAcc == null || !authAcc.getActive()) {
                Logger.error("Specified account does not exist or inactive");
                return F.Promise.throwing(new Exception("Specified account does not exist or inactive"));
            }

            if (!auth.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authAcc.getId().toString(),
                    account.getName(), authAcc.getSecret()))) {
                Logger.error("Provided and calculated enckeys do not match");
                return F.Promise.throwing(new Exception("Specified account does not exist or inactive"));
            }

            return F.Promise.wrap(accountRepository.create(account));
        }).map(account1 -> ok(Json.toJson(createResponse("0", "account created successfully"))));


        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("1", error.getMessage())));
        });
    }
}
