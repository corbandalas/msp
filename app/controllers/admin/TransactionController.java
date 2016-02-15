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

/**
 * API transaction controller
 *
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/transaction", description = "Methods to manage application transaction stored in DB")
public class TransactionController extends BaseController {

    @Inject
    private TransactionRepository transactionRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createTransaction",
            value = "Create transaction",
            notes = "Create transaction in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Transaction was created successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
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
        final Transaction transaction = Json.fromJson(jsonNode, Transaction.class);

        if (StringUtils.isBlank(transaction.getCurrencyId()) || transaction.getAmount() == null || transaction.getAmount() <= 0 ||
                transaction.getType() == null || transaction.getFromAccountId() == null || transaction.getToAccountId() == null
                || transaction.getFromExchangeRate() == null || transaction.getToExchangeRate() == null ||
                transaction.getOperationId() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                transaction.getCurrencyId(), transaction.getAmount().toString(), transaction.getFromAccountId().toString(),
                transaction.getToAccountId().toString(), transaction.getFromExchangeRate().toString(),
                transaction.getToExchangeRate().toString(), transaction.getType().name(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.create(transaction)).map(res ->
                ok(Json.toJson(new TransactionResponse("transaction created successfully", "0", res))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("2", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateOperation",
            value = "Update operation",
            notes = "update operation in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Operation was updated successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
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
        final Transaction transaction = Json.fromJson(jsonNode, Transaction.class);

        if (transaction.getId() == null || StringUtils.isBlank(transaction.getCurrencyId()) || transaction.getAmount() == null || transaction.getAmount() <= 0 ||
                transaction.getType() == null || transaction.getFromAccountId() == null || transaction.getToAccountId() == null
                || transaction.getFromExchangeRate() == null || transaction.getToExchangeRate() == null ||
                transaction.getOperationId() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                transaction.getId().toString(), transaction.getCurrencyId(), transaction.getAmount().toString(), transaction.getFromAccountId().toString(),
                transaction.getToAccountId().toString(), transaction.getFromExchangeRate().toString(),
                transaction.getToExchangeRate().toString(), transaction.getType().name(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.update(transaction)).map(account1 -> ok(Json.toJson(createResponse("0", "transaction updated successfully"))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("2", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve operation by ID",
            notes = "Get operation by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = OperationResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = TransactionResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
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
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.retrieveById(transactionID)).map(transaction -> ok(Json.toJson(new TransactionResponse("OK", "0", transaction))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("2", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllTransactions",
            value = "All transactions list",
            notes = "Obtain list of all transactions stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = TransactionListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = TransactionListResponse.class),
            @ApiResponse(code = 1, message = "DB error"),
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
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.retrieveAll()).map(transactions -> ok(Json.toJson(new TransactionListResponse("OK", "0", transactions))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("2", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listTransactionsByOperation",
            value = "Transactions list by operation",
            notes = "Obtain list of operation transactions stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = TransactionListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = TransactionListResponse.class),
            @ApiResponse(code = 1, message = "DB error"),
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
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(transactionRepository.retrieveByOperationId(operationID)).map(transactions -> ok(Json.toJson(new TransactionListResponse("OK", "0", transactions))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("2", error.getMessage())));
        });
    }
}
