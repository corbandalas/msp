package controllers.customer;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import dto.Authentication;
import dto.BaseAPIResponse;
import exception.CustomerNotRegisteredException;
import model.Customer;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import repository.CustomerRepository;
import services.CacheProvider;

import static configs.ReturnCodes.*;

/**
 * This action validates customer authorization token and saves Customer entity in context for future use.
 *
 * @author ra created 15.02.2016.
 * @since 0.2.0
 */
public class BaseCustomerApiAction extends Action.Simple {

    @Inject
    CustomerRepository customerRepository;

    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        final String token = ctx.request().getHeader("token");
        if (StringUtils.isBlank(token)) {
            Logger.error("Missing authorization token header");
            return F.Promise.pure(createWrongAuthDataResponse());
        }

        final String phone = (String)CacheProvider.getInstance().getObject(token);

        Integer accountID = (Integer)CacheProvider.getInstance().getObject("account_" + phone);

        if (StringUtils.isBlank(phone)) {
            Logger.error("Authorization token was not found");
            return F.Promise.pure(createWrongAuthDataResponse());
        }

        if (accountID == null) {
            Logger.error("Authorization token was not found");
            return F.Promise.pure(createWrongAuthDataResponse());
        }



        final F.Promise<Result> result = F.Promise.wrap(customerRepository.retrieveById(phone)).flatMap(customerOptional -> {

            Customer customer = customerOptional.orElseThrow(CustomerNotRegisteredException::new);

            if (!customer.getActive()) {
                Logger.error("Customer for specified token is not active");
                return F.Promise.pure(createWrongCustomerAccountResponse());
            }
            ctx.args.put("customer", customer);

            Config conf = ConfigFactory.load();

            String sessionTimeOut = conf.getString("cache.customer.session.timeout");

            //Store token to cache with expiration time out
            CacheProvider.getInstance().putObject(token, customer.getId()/*, Integer.parseInt(sessionTimeOut) * 60*/);

            CacheProvider.getInstance().putObject("account_" + customer.getId(), accountID/*, Integer.parseInt(sessionTimeOut) * 60*/);


            return delegate.call(ctx);
        });

        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return createGeneralErrorResponse();
        });
    }

    private Results.Status createWrongAuthDataResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_AUTHORIZATION_DATA_TEXT, "" + INCORRECT_AUTHORIZATION_DATA_CODE)));
    }

    private Results.Status createWrongCustomerAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(WRONG_CUSTOMER_ACCOUNT_TEXT, "" + WRONG_CUSTOMER_ACCOUNT_CODE)));
    }

    private Results.Status createGeneralErrorResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(GENERAL_ERROR_TEXT, "" + GENERAL_ERROR_CODE)));
    }
}