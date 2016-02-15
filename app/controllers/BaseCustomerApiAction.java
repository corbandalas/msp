package controllers;

import com.google.inject.Inject;
import dto.BaseAPIResponse;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import repository.CustomerRepository;

/**
 * This action validates customer authorization token and saves Customer entity in context for future use.
 *
 * @author ra created 15.02.2016.
 * @since 0.2.0
 */
public class BaseCustomerApiAction extends Action.Simple {
    @Inject
    CacheApi cache;

    @Inject
    CustomerRepository customerRepository;

    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        final String token = ctx.request().getHeader("token");
        if (StringUtils.isBlank(token)) {
            Logger.error("Missing authorization token header");
            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("Missing authorization token header", "1"))));
        }

        final String phone = cache.get(token);
        if (StringUtils.isBlank(phone)) {
            Logger.error("Authorization token was not found");
            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("Authorization token was not found", "1"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.retrieveById(phone)).flatMap(customer -> {
            if (!customer.getActive()) {
                Logger.error("Customer for specified token is not active");
                return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse("Customer for specified token is not active", "1"))));
            }
            ctx.args.put("customer", customer);
            return delegate.call(ctx);
        });

        return result.recover(throwable -> {
            Logger.error("Error: ",throwable);
            return ok(Json.toJson(new BaseAPIResponse(throwable.getMessage(), "2")));
        });
    }
}
