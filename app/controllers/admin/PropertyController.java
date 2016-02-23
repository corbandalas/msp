package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.PropertyListResponse;
import dto.PropertyResponse;
import model.Property;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.PropertyRepository;
import util.SecurityUtil;

import java.util.List;

import static configs.ReturnCodes.*;


/**
 * API property controller
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */

@Api(value = Constants.ADMIN_API_PATH + "/property", description = "Operations to manage application properties stored in DB")
public class PropertyController extends BaseController {

    @Inject
    private PropertyRepository propertyRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createProperty",
            value = "Create new property",
            notes = "Store new application property in DB",
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
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Property request", required = true, dataType = "model.Property", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+property.id+property.value+property.description+property.category+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})


    public Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        Property property = null;

        try {
            property = Json.fromJson(jsonNode, Property.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(property.getId()) || StringUtils.isBlank(property.getDescription())
                || StringUtils.isBlank(property.getValue()) || property.getCategory() == null) {
            Logger.error("Missing params");
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString()
                , property.getId(), property.getValue(), property.getDescription(), property.getCategory().name(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final Promise<Property> propertyPromise = Promise.wrap(propertyRepository.create(property));

        Promise<Result> result = propertyPromise.map(res -> ok(Json.toJson(createResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateProperty",
            value = "Update existed property",
            notes = "Update existed application property in DB",
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
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Property request", required = true, dataType = "model.Property", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+property.id+property.value+property.description+property.category+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})


    public Promise<Result> update() {
        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        Property property = null;

        try {
            property = Json.fromJson(jsonNode, Property.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(property.getId()) || StringUtils.isBlank(property.getDescription())
                || StringUtils.isBlank(property.getValue()) || property.getCategory() == null) {
            Logger.error("Missing params");
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString()
                , property.getId(), property.getValue(), property.getDescription(), property.getCategory().name(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final Promise<Property> propertyPromise = Promise.wrap(propertyRepository.update(property));

        Promise<Result> result = propertyPromise.map(res -> ok(Json.toJson(createResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllProperty",
            value = "All property list",
            notes = "Obtain list of all application properties stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = PropertyListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PropertyListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })

    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveAll() {
        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString()
                , authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final Promise<List<Property>> propertyPromise = Promise.wrap(propertyRepository.retrieveAll());

        Promise<Result> result = propertyPromise.map((List<Property> list) -> ok(Json.toJson(createResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT, list))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve property by ID",
            notes = "Get property by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = PropertyResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PropertyResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INCORRECT_PROPERTY_CODE, message = INCORRECT_PROPERTY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "propertyID", value = "Property ID to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+propertyID+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")

    })
    public Promise<Result> retrieveByID(String propertyID) {
        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(propertyID)) {

            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString()
                , propertyID, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        Promise<Result> result = Promise.wrap(propertyRepository.retrieveById(propertyID)).map(res -> res.map(prop
                -> ok(Json.toJson(createResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT, prop)))).orElse(
                ok(Json.toJson(createResponse(String.valueOf(INCORRECT_PROPERTY_CODE), INCORRECT_PROPERTY_TEXT)))));

        return returnRecover(result);
    }
}
