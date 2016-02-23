package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.*;
import model.Operation;
import model.enums.OperationType;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.OperationRepository;
import util.SecurityUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static configs.ReturnCodes.*;

/**
 * API operation controller
 *
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/operation", description = "Methods to manage application operation stored in DB")
public class OperationController extends BaseController {

    @Inject
    private OperationRepository operationRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createOperation",
            value = "Create operation",
            notes = "Create operation in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = OperationResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = OperationResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Operation request", required = true, dataType = "model.Operation", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+operation.orderId+operation.description+operation.type+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Operation operation;
        try {
            operation = Json.fromJson(jsonNode, Operation.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(operation.getDescription()) || StringUtils.isBlank(operation.getOrderId()) ||
                operation.getType() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                operation.getOrderId(), operation.getDescription(), operation.getType().name(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        if (operation.getCreateDate() == null) operation.setCreateDate(new Date());

        final F.Promise<Result> result = F.Promise.wrap(operationRepository.create(operation)).map(res ->
                ok(Json.toJson(new OperationResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
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
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Operation request", required = true, dataType = "model.Operation", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+operation.id+operation.orderId+operation.description+operation.type+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> update() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Operation operation;
        try {
            operation = Json.fromJson(jsonNode, Operation.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (operation.getId() == null || StringUtils.isBlank(operation.getDescription()) || StringUtils.isBlank(operation.getOrderId()) ||
                operation.getType() == null || operation.getCreateDate() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                operation.getId().toString(), operation.getOrderId(), operation.getDescription(), operation.getType().name(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(operationRepository.update(operation)).map(account1 -> ok(Json.toJson(
                createResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT))));

        return returnRecover(result);
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
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = OperationResponse.class),
            @ApiResponse(code = INCORRECT_OPERATION_CODE, message = INCORRECT_OPERATION_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "operationID", value = "operation ID to retrieve", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+operationID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> retrieveById(Integer operationID) {
        final Authentication authData = (Authentication) ctx().args.get("authData");
        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                operationID.toString(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(operationRepository.retrieveById(operationID)).map(operationOpt
                -> operationOpt.map(operation -> ok(Json.toJson(new OperationResponse("OK", "0", operation))))
                .orElse(ok(Json.toJson(createResponse(String.valueOf(INCORRECT_OPERATION_CODE), INCORRECT_OPERATION_TEXT)))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllOperations",
            value = "All operations list",
            notes = "Obtain list of all operations stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = OperationListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = OperationListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+dateFrom+dateTo+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId"),
            @ApiImplicitParam(value = "Filter object with restriction params", required = true, dataType = "dto.OperationFilter", paramType = "body")})
    public F.Promise<Result> retrieveFiltered() {
        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final OperationFilter filter;
        try {
            filter = Json.fromJson(jsonNode, OperationFilter.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        Date parsedFromDate;
        Date parsedToDate;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            parsedFromDate = simpleDateFormat.parse(filter.getDateFrom());
            parsedToDate = simpleDateFormat.parse(filter.getDateTo());
        } catch (ParseException e) {
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final OperationType operationType;
        if (StringUtils.isNotBlank(filter.getType())) {
            operationType = OperationType.valueOf(filter.getType());
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

        final F.Promise<Result> result = F.Promise.wrap(operationRepository.retrieveByDateAndType(parsedFromDate, parsedToDate,
                operationType, filter.getLimit(), filter.getOffset()))
                .map(operations -> ok(Json.toJson(new OperationListResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), operations))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllOperationsByDate",
            value = "All accounts list",
            notes = "Obtain list of all accounts stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = OperationListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = OperationListResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
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
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(operationRepository.retrieveAll()).map(operations ->
                ok(Json.toJson(new OperationListResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), operations))));

        return returnRecover(result);
    }
}
