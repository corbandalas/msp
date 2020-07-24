package controllers.admin;

import com.google.inject.Inject;
import configs.ReturnCodes;
import configs.ReturnCodesV2;
import dto.Authentication;
import dto.partnerV2.BaseAPIV2ErrorResponse;
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

        Logger.info("///// X-Api-Key (accountId) = " + accountId);

        if (!StringUtils.isNumeric(accountId)) {
            Logger.error("X-Api-Key header is missing or not numeric");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIV2ErrorResponse(ReturnCodesV2.INCORRECT_AUTHORIZATION_DATA_TEXT,
                    String.valueOf(ReturnCodesV2.INCORRECT_AUTHORIZATION_DATA_CODE), ReturnCodes.INCORRECT_AUTHORIZATION_DATA_TEXT, ""))));
        }

        final String enckey = ctx.request().getHeader("X-Request-Hash");

        Logger.info("///// X-Request-Hash (enckey) = " + enckey);

        if (StringUtils.isBlank(enckey)) {
            Logger.error("X-Request-Hash header is missing");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIV2ErrorResponse(ReturnCodesV2.INCORRECT_AUTHORIZATION_DATA_TEXT,
                    String.valueOf(ReturnCodesV2.INCORRECT_AUTHORIZATION_DATA_CODE), ReturnCodesV2.INCORRECT_AUTHORIZATION_DATA_TEXT, ""))));
        }

        final String orderId = ctx.request().getHeader("X-Request-Nonce");

        Logger.info("///// X-Request-Nonce(orderId) = " + orderId);

        if (StringUtils.isBlank(orderId)) {
            Logger.error("X-Request-Nonce header is missing");

            return F.Promise.pure(ok(Json.toJson(new BaseAPIV2ErrorResponse(ReturnCodesV2.INCORRECT_AUTHORIZATION_DATA_TEXT,
                    String.valueOf(ReturnCodesV2.INCORRECT_AUTHORIZATION_DATA_CODE), ReturnCodesV2.INCORRECT_AUTHORIZATION_DATA_TEXT, ""))));
        }


        final F.Promise<Result> result = F.Promise.wrap(accountRepository.retrieveById(Integer.parseInt(accountId))).flatMap(authAccountOptional -> {

            if (!authAccountOptional.isPresent() || !authAccountOptional.get().getActive()) {
                Logger.error("Specified account does not exist or inactive");

                return F.Promise.pure(ok(Json.toJson(new BaseAPIV2ErrorResponse(ReturnCodesV2.INACTIVE_ACCOUNT_TEXT,
                        String.valueOf(ReturnCodesV2.INACTIVE_ACCOUNT_CODE), ReturnCodesV2.INACTIVE_ACCOUNT_TEXT, ""))));
            }

            Account authAccount = authAccountOptional.get();


            String sh1 = SecurityUtil.generateSH1(orderId + authAccount.getSecret());

            Logger.error("Generated SH1:" +  sh1);

            String generatedEnckey = SecurityUtil.encodeString(sh1);

            Logger.error("Generated enckey:" +  generatedEnckey);

            if (!generatedEnckey.equalsIgnoreCase(enckey)) {
                return F.Promise.pure(ok(Json.toJson(new BaseAPIV2ErrorResponse(ReturnCodesV2.WRONG_REQUEST_ENCKEY_TEXT,
                        String.valueOf(ReturnCodesV2.WRONG_REQUEST_ENCKEY_CODE), ReturnCodesV2.WRONG_REQUEST_ENCKEY_TEXT, ""))));
            }

            final Authentication authData = new Authentication(authAccount, enckey, orderId);

            ctx.args.put("authData", authData);

            return delegate.call(ctx);
        });

        return result.recover(throwable -> {

            Logger.error("Error: ", throwable);

            return ok(Json.toJson(new BaseAPIV2ErrorResponse(ReturnCodesV2.GENERAL_ERROR_TEXT, String.valueOf(ReturnCodesV2.GENERAL_ERROR_CODE),
                    ReturnCodesV2.GENERAL_ERROR_TEXT, "")));
        });
    }
}
