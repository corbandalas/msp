package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.AccountListResponse;
import dto.AccountResponse;
import dto.Authentication;
import dto.BaseAPIResponse;
import model.Account;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.AccountRepository;
import util.DateUtil;
import util.SecurityUtil;

import java.util.Date;

/**
 * API account controller
 *
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/account", description = "Operations to manage application accounts stored in DB")
public class AccountController extends BaseController {

    @Inject
    private AccountRepository accountRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createAccount",
            value = "Create account",
            notes = "Create account in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = dto.BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Account was created successfully"),
            @ApiResponse(code = 1, message = "Missing parameters"),
            @ApiResponse(code = 2, message = "Wrong request format"),
            @ApiResponse(code = 3, message = "Wrong enckey"),
            @ApiResponse(code = 6, message = "General error")
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Account request", required = true, dataType = "model.Account", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+account.id+account.name+account.currencyId+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Account account;
        try {
            account = Json.fromJson(jsonNode, Account.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(ok(Json.toJson(createResponse("2", "Wrong request format"))));
        }

        if (account.getId() == null || account.getActive() == null || StringUtils.isBlank(account.getCurrencyId()) ||
                StringUtils.isBlank(account.getName()) || StringUtils.isBlank(account.getSecret())) {
            Logger.error("Missing params");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                account.getId().toString(), account.getName(), account.getCurrencyId(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("3", "Provided and calculated enckeys do not match"))));
        }

        if (account.getCreateDate() == null) account.setCreateDate(new Date());

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.create(account)).map(account1 -> ok(Json.toJson(createResponse("0", "account created successfully"))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("6", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateAccount",
            value = "Update account",
            notes = "update account in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = dto.BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Account was updated successfully"),
            @ApiResponse(code = 1, message = "Missing parameters"),
            @ApiResponse(code = 2, message = "Wrong request format"),
            @ApiResponse(code = 3, message = "Wrong enckey"),
            @ApiResponse(code = 6, message = "General error")
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Account request", required = true, dataType = "model.Account", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+account.name+account.currencyId+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> update() {
        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Account account;
        try {
            account = Json.fromJson(jsonNode, Account.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(ok(Json.toJson(createResponse("2", "Wrong request format"))));
        }

        if (account.getId() == null || account.getActive() == null || StringUtils.isBlank(account.getCurrencyId()) ||
                StringUtils.isBlank(account.getName()) || StringUtils.isBlank(account.getSecret()) || account.getCreateDate() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                account.getName(), account.getCurrencyId(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("3", "Provided and calculated enckeys do not match"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.update(account)).map(account1 -> ok(Json.toJson(createResponse("0", "account created successfully"))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("6", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve account by ID",
            notes = "Get account by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = AccountResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = AccountResponse.class),
            @ApiResponse(code = 3, message = "Wrong enckey"),
            @ApiResponse(code = 4, message = "Specified account does not exist"),
            @ApiResponse(code = 6, message = "General error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accountID", value = "account ID to retrieve", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+accountIdPathParam+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> retrieveById(Integer accountId) {
        final Authentication authData = (Authentication) ctx().args.get("authData");
        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                accountId.toString(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("3", "Provided and calculated enckeys do not match"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.retrieveById(accountId)).map(accountOpt
                -> accountOpt.map(account -> ok(Json.toJson(account))).orElse(ok(Json.toJson(createResponse("4", "Specified account does not exist")))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("6", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllAccounts",
            value = "All accounts list",
            notes = "Obtain list of all accounts stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = AccountListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = AccountListResponse.class),
            @ApiResponse(code = 3, message = "Wrong enckey"),
            @ApiResponse(code = 6, message = "General error"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> retrieveAll() {
        final Authentication authData = (Authentication) ctx().args.get("authData");
        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("3", "Provided and calculated enckeys do not match"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.retrieveAll()).map(accounts -> ok(Json
                .toJson(new AccountListResponse("OK", "0", accounts))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("6", error.getMessage())));
        });
    }
}
