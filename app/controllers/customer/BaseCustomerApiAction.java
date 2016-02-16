package controllers.customer;

import com.google.inject.Inject;
import dto.BaseAPIResponse;
import model.Customer;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

/**
 * This action validates customer authorization token and saves Customer entity in context for future use.
 *
 * @author ra created 15.02.2016.
 * @since 0.2.0
 */
public class BaseCustomerApiAction extends Action.Simple {
    @Inject
    CacheApi cache;

    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        final String token = ctx.request().getHeader("token");
        if (StringUtils.isBlank(token)) {
            Logger.error("Missing authorization token header");
            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("Missing authorization token header", "1"))));
        }

        final Customer customer = cache.get(token);
        if (customer == null) {
            Logger.error("Authorization token was not found");
            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("Authorization token was not found", "1"))));
        }

        ctx.args.put("customer", customer);

        return delegate.call(ctx);
    }
}