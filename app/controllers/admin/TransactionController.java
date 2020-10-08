package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.*;
import dto.TransactionResponse;
import dto.partnerV2.*;
import model.Transaction;
import model.WalletTransaction;
import model.enums.OperationType;
import model.enums.TransactionType;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.TransactionRepository;
import repository.WalletTransactionRepository;
import util.SecurityUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Inject
    WalletTransactionRepository walletTransactionRepository;

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
            nickname = "listFilteredTransactions",
            value = "Filtered transactions list",
            notes = "Method allows to get list of filtered transactions in admin system",
            produces = "application/json",
            httpMethod = "GET",
            response = TransactionListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = TransactionListResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+dateFrom+dateTo+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId"),
            @ApiImplicitParam(value = "Filter object with restriction params", required = true, dataType = "dto.TransactionFilter", paramType = "body")})
    public F.Promise<Result> retrieveFiltered() {
        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final TransactionFilter filter;
        try {
            filter = Json.fromJson(jsonNode, TransactionFilter.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        boolean admin = authData.getAccount().isAdmin();

        Date parsedFromDate;
        Date parsedToDate;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            parsedFromDate = simpleDateFormat.parse(filter.getDateFrom());
            parsedToDate = simpleDateFormat.parse(filter.getDateTo());
        } catch (ParseException e) {
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final TransactionType operationType;
        if (StringUtils.isNotBlank(filter.getType())) {
            operationType = TransactionType.valueOf(filter.getType());
            if (operationType == null) {
                Logger.error("Specified operation type does not exist");
                return F.Promise.pure(createWrongRequestFormatResponse());
            }
        } else operationType = null;

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                filter.getDateFrom(), filter.getDateTo(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(admin? transactionRepository.retrieveByDateAndType(parsedFromDate, parsedToDate,
                operationType, filter.getLimit(), filter.getOffset(), filter.getOrderID()): transactionRepository.retrieveByDateAndType(authData.getAccount().getId(), parsedFromDate, parsedToDate,
                operationType, filter.getLimit(), filter.getOffset(), filter.getOrderID()))
                .map(operations -> ok(Json.toJson(new TransactionListResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), operations))));

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


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "getWalletTransactions",
            value = "Get mini wallet transactions",
            notes = "Method allows to get mini wallet transaction",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = AdminMiniWalletTransactionResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = AdminMiniWalletTransactionResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId"),
            @ApiImplicitParam(value = "Filter object with restriction params", required = true, dataType = "dto.AdminMiniWalletTransactionRequest", paramType = "body")})
    public F.Promise<Result> getWalletTransactions() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final AdminMiniWalletTransactionRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, AdminMiniWalletTransactionRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

//        if (StringUtils.isBlank(createCard.getUuid())
//                ) {
//            Logger.error("Missing params");
//            return F.Promise.pure(createWrongRequestFormatResponse());
//        }
//
        F.Promise<List<WalletTransaction>> wrap = (
                F.Promise.wrap(walletTransactionRepository.retrieveFiltered(createCard.getUuid(), Long.parseLong(createCard.getDateEnd()) / 1000, Long.parseLong(createCard.getDateStart()) / 1000, createCard.getSourceToken(), createCard.getDestToken())));

        final F.Promise<Result> result = wrap.map(card -> {

            AdminMiniWalletTransactionResponse response = new AdminMiniWalletTransactionResponse();

            response.setUuid(createCard.getUuid());

            ArrayList<Transaction2> transaction2s = new ArrayList<>();

            for (WalletTransaction walletTransaction : card) {
                Transaction2 transaction2 = new Transaction2();
                transaction2.setAmount((double) walletTransaction.getAmount_cts() / 100);
                transaction2.setCurrency(walletTransaction.getCurrency());
                transaction2.setDate(walletTransaction.getDate_added() * 1000);
                transaction2.setDescription(walletTransaction.getDescription());
                transaction2.setReceiver(walletTransaction.getDest_token());
                transaction2.setToken(walletTransaction.getSrc_token());
                transaction2.setType(walletTransaction.getType());

                transaction2s.add(transaction2);
            }

            response.setTransactions(transaction2s);


            return ok(Json.toJson(response));
        });

        return returnRecover(result);
    }


}
