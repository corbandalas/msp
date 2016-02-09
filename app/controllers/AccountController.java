package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import dto.Authentication;
import model.Account;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.AccountRepository;
import util.SecurityUtil;

/**
 * API account controller
 *
 * @author ra created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = "/api/account", description = "Operations to manage application accounts stored in DB")
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

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "Account was created successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Account request", required = true, dataType = "model.Account", paramType = "body")})
    public F.Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Account account = Json.fromJson(jsonNode, Account.class);

        //TODO: Validate account fields

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                account.getName(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.throwing(new Exception("Specified account does not exist or inactive"));
        }

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.create(account)).map(account1 -> ok(Json.toJson(createResponse("0", "account created successfully"))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("2", error.getMessage())));
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

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "Account was updated successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Account request", required = true, dataType = "model.Account", paramType = "body")})
    public F.Promise<Result> update() {
        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Account account = Json.fromJson(jsonNode, Account.class);

        //TODO: Validate account fields

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                account.getName(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.throwing(new Exception("Specified account does not exist or inactive"));
        }

        final F.Promise<Result> result = F.Promise.wrap(accountRepository.update(account)).map(account1 -> ok(Json.toJson(createResponse("0", "account created successfully"))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("2", error.getMessage())));
        });
    }
}
