package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.*;
import model.Transaction;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.TransactionRepository;
import util.SecurityUtil;

import static configs.ReturnCodes.*;

/**
 * API transaction controller
 *
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/transaction", description = "Allows to manage transactions created for administration use.")
public class TransactionController extends BaseController {

    @Inject
    private TransactionRepository transactionRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createTransaction",
            value = "Create transaction",
            notes = "Method allows to create transaction in admin system",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = TransactionResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = TransactionResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Transaction request", required = true, dataType = "model.Transaction", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+transaction.currencyId+transaction.amount+transaction.fromAccountId+" +
                    "transactionToAccountId+transaction.fromExchangeRate+transaction.toExchangeRate+transaction.type+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Transaction transaction;
        try {
            transaction = Json.fromJson(jsonNode, Transaction.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(transaction.getCurrencyId()) || transaction.getAmount() == null || transaction.getAmount() <= 0 ||
                transaction.getType() == null || transaction.getFromAccountId() == null || transaction.getToAccountId() == null
                || transaction.getFromAccountExchangeRate() == null || transaction.getToAccountExchangeRate() == null ||
                transaction.getOperationId() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                transaction.getCurrencyId(), transaction.getAmount().toString(), transaction.getFromAccountId().toString(),
                transaction.getToAccountId().toString(), transaction.getFromAccountExchangeRate().toString(),
                transaction.getToAccountExchangeRate().toString(), transaction.getType().name(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.create(transaction)).map(res ->
                ok(Json.toJson(new TransactionResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateTransaction",
            value = "Update transaction",
            notes = "Method allows to update transaction in admin system",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Operation request", required = true, dataType = "model.Operation", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+transaction.id+transaction.currencyId+transaction.amount+transaction.fromAccountId+" +
                    "transactionToAccountId+transaction.fromExchangeRate+transaction.toExchangeRate+transaction.type+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> update() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Transaction transaction;
        try {
            transaction = Json.fromJson(jsonNode, Transaction.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (transaction.getId() == null || StringUtils.isBlank(transaction.getCurrencyId()) || transaction.getAmount() == null || transaction.getAmount() <= 0 ||
                transaction.getType() == null || transaction.getFromAccountId() == null || transaction.getToAccountId() == null
                || transaction.getFromAccountExchangeRate() == null || transaction.getToAccountExchangeRate() == null ||
                transaction.getOperationId() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                transaction.getId().toString(), transaction.getCurrencyId(), transaction.getAmount().toString(), transaction.getFromAccountId().toString(),
                transaction.getToAccountId().toString(), transaction.getFromAccountExchangeRate().toString(),
                transaction.getToAccountExchangeRate().toString(), transaction.getType().name(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.update(transaction)).map(account1 -> ok(
                Json.toJson(createResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Get transaction by ID",
            notes = "Method allows to get transaction by ID in admin system",
            produces = "application/json",
            httpMethod = "GET",
            response = TransactionResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = TransactionResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INCORRECT_TRANSACTION_CODE, message = INCORRECT_TRANSACTION_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "transactionID", value = "transaction ID to retrieve", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+transactionID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> retrieveById(Integer transactionID) {
        final Authentication authData = (Authentication) ctx().args.get("authData");
        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                transactionID.toString(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.retrieveById(transactionID)).map(transactionOpt
                -> transactionOpt.map(transaction -> ok(Json.toJson(new TransactionResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), transaction))))
                .orElse(ok(Json.toJson(createResponse(String.valueOf(INCORRECT_TRANSACTION_CODE), INCORRECT_TRANSACTION_TEXT)))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllTransactions",
            value = "All transactions list",
            notes = "Method allows to get list of all transactions in admin system",
            produces = "application/json",
            httpMethod = "GET",
            response = TransactionListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = TransactionListResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> retrieveAll() {
        final Authentication authData = (Authentication) ctx().args.get("authData");

        boolean admin = authData.getAccount().isAdmin();

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(admin?transactionRepository.retrieveAll(): transactionRepository.retrieveAll(authData.getAccount().getId())).map(transactions ->
                ok(Json.toJson(new TransactionListResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), transactions))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listTransactionsByOperation",
            value = "Transactions list by operation",
            notes = "Method allows to get list of operation transactions in admin system",
            produces = "application/json",
            httpMethod = "GET",
            response = TransactionListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = TransactionListResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operationID", value = "operation ID to retrieve", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+operationID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> retrieveByOperationId(Long operationID) {
        final Authentication authData = (Authentication) ctx().args.get("authData");
        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                operationID.toString(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.retrieveByOperationId(operationID)).map(transactions ->
                ok(Json.toJson(new TransactionListResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), transactions))));

        return returnRecover(result);
    }



}
