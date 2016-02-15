package controllers;

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
 * This action validates merchant authorization headers and saves its in context for future use.
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
public class BaseMerchantApiAction extends Action.Simple {

    @Inject
    protected AccountRepository accountRepository;

    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        final String accountId = ctx.request().getHeader("accountId");
        if (!StringUtils.isNumeric(accountId)) {
            Logger.error("accountId header is missing or not numeric");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("accountId header is missing", "1"))));
        }

        final String enckey = ctx.request().getHeader("enckey");
        if (StringUtils.isBlank(enckey)) {
            Logger.error("enckey header is missing");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("enckey header is missing", "1"))));
        }

        final String orderId = ctx.request().getHeader("orderId");
        if (StringUtils.isBlank(orderId)) {
            Logger.error("orderId header is missing");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("enckey header is missing", "1"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.retrieveById(Integer.parseInt(accountId))).flatMap(authAccount -> {
            if (authAccount == null || !authAccount.getActive()) {
                Logger.error("Specified account does not exist or inactive");

                return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("Specified account does not exist or inactive", "1"))));
            }

            final Authentication authData = new Authentication(authAccount, enckey, orderId);

            ctx.args.put("authData", authData);

            return delegate.call(ctx);
        });

        return result.recover(throwable -> {
            Logger.error("Error: ",throwable);
            return ok(Json.toJson(new BaseAPIResponse(throwable.getMessage(), "2")));
        });
    }
}
