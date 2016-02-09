package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import dto.Authentication;
import dto.BaseAPIResponse;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import repository.AccountRepository;

/**
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
public class BaseMerchantApiAction extends Action.Simple {

    @Inject
    protected AccountRepository accountRepository;

    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        final JsonNode jsonNode = ctx.request().body().asJson();
        final Authentication authData = Json.fromJson(jsonNode.get("authData"), Authentication.class);

        if (authData == null || authData.getAccountId() == null || StringUtils.isBlank(authData.getEnckey())) {
            Logger.error("Authentication data is missing");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("Authentication data is missing", "1"))));
        }

        return F.Promise.wrap(accountRepository.retrieveById(authData.getAccountId())).flatMap(authAccount -> {
            if(authAccount==null || ! authAccount.getActive()) {
                Logger.error("Specified account does not exist or inactive");

                return F.Promise.throwing(new Exception("Specified account does not exist or inactive"));
            }

            ctx.args.put("authAccount",authAccount);
            ctx.args.put("authData",authData);
            ctx.args.put("jsonBody",jsonNode);

            return delegate.call(ctx);
        });
    }
}
