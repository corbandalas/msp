package controllers.admin;

import com.google.inject.Inject;
import configs.ReturnCodes;
import dto.Authentication;
import dto.BaseAPIResponse;
import model.Account;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import repository.AccountRepository;
import util.SecurityUtil;

/**
 * This action validates merchant authorization headers and saves them in context for future use.
 *
 * @author tar created 08.07.2020.
 * @since 0.1.0
 */
public class BaseMerchantApiV2Action extends Action.Simple {

    @Inject
    protected AccountRepository accountRepository;

    @Override
    public F.Promise<Result> call(Http.Context ctx) throws Throwable {
        final String accountId = ctx.request().getHeader("X-Api-Key");
        if (!StringUtils.isNumeric(accountId)) {
            Logger.error("X-Api-Key header is missing or not numeric");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse(ReturnCodes.INCORRECT_AUTHORIZATION_DATA_TEXT,
                    String.valueOf(ReturnCodes.INCORRECT_AUTHORIZATION_DATA_CODE)))));
        }

        final String enckey = ctx.request().getHeader("X-Request-Hash");
        if (StringUtils.isBlank(enckey)) {
            Logger.error("X-Request-Hash header is missing");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse(ReturnCodes.INCORRECT_AUTHORIZATION_DATA_TEXT,
                    String.valueOf(ReturnCodes.INCORRECT_AUTHORIZATION_DATA_CODE)))));
        }

        final String orderId = ctx.request().getHeader("X-Request-Nonce");
        if (StringUtils.isBlank(orderId)) {
            Logger.error("X-Request-Nonce header is missing");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse(ReturnCodes.INCORRECT_AUTHORIZATION_DATA_TEXT,
                    String.valueOf(ReturnCodes.INCORRECT_AUTHORIZATION_DATA_CODE)))));
        }


        if (StringUtils.isBlank(orderId)) {
            Logger.error("X-Request-Nonce header is missing");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse(ReturnCodes.INCORRECT_AUTHORIZATION_DATA_TEXT,
                    String.valueOf(ReturnCodes.INCORRECT_AUTHORIZATION_DATA_CODE)))));
        }

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.retrieveById(Integer.parseInt(accountId))).flatMap(authAccountOptional -> {

            if (!authAccountOptional.isPresent() || !authAccountOptional.get().getActive()) {
                Logger.error("Specified account does not exist or inactive");

                return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse(ReturnCodes.INACTIVE_ACCOUNT_TEXT,
                        String.valueOf(ReturnCodes.INACTIVE_ACCOUNT_CODE)))));
            }

            Account authAccount = authAccountOptional.get();

            String generatedEnckey = SecurityUtil.generateSH1(SecurityUtil.encodeString(orderId + authAccount.getSecret()));

            if (!generatedEnckey.equalsIgnoreCase(enckey)) {
                return F.Promise.pure(ok(Json.toJson(new BaseAPIResponse(ReturnCodes.WRONG_REQUEST_ENCKEY_TEXT,
                        String.valueOf(ReturnCodes.WRONG_REQUEST_ENCKEY_CODE)))));
            }

            final Authentication authData = new Authentication(authAccount, enckey, orderId);

            ctx.args.put("authData", authData);

            return delegate.call(ctx);
        });

        return result.recover(throwable -> {

            Logger.error("Error: ", throwable);

            return ok(Json.toJson(new BaseAPIResponse(ReturnCodes.GENERAL_ERROR_TEXT, String.valueOf(ReturnCodes.GENERAL_ERROR_CODE))));
        });
    }
}
