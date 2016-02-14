package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import dto.Authentication;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.mvc.Result;
import play.mvc.With;
import repository.PropertyRepository;

import model.Property;
import play.libs.F.Promise;
import play.libs.Json;
import util.SecurityUtil;

import java.util.List;


/**
 * API property controller
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */

@Api(value = "/api/property", description = "Operations to manage application properties stored in DB")
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
            response = dto.BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Property was created successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
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

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (StringUtils.isBlank(property.getId()) || StringUtils.isBlank(property.getDescription())
                || StringUtils.isBlank(property.getValue()) || property.getCategory() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString()
                , property.getId(), property.getValue(), property.getDescription(), property.getCategory().name(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        final Promise<Property> propertyPromise = Promise.wrap(propertyRepository.create(property));

        Promise<Result> result = propertyPromise.map(res -> ok(Json.toJson(createResponse("0", "Property was created successfully"))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateProperty",
            value = "Update existed property",
            notes = "Update existed application property in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = dto.BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Property was updated successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
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

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (StringUtils.isBlank(property.getId()) || StringUtils.isBlank(property.getDescription())
                || StringUtils.isBlank(property.getValue()) || property.getCategory() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString()
                , property.getId(), property.getValue(), property.getDescription(), property.getCategory().name(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        final Promise<Property> propertyPromise = Promise.wrap(propertyRepository.update(property));

        Promise<Result> result = propertyPromise.map(res -> ok(Json.toJson(createResponse("0", "Property was updated successfully"))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllProperty",
            value = "All property list",
            notes = "Obtain list of all application properties stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.PropertyListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = dto.PropertyListResponse.class),
            @ApiResponse(code = 1, message = "DB error"),
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
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        final Promise<List<Property>> propertyPromise = Promise.wrap(propertyRepository.retrieveAll());

        Promise<Result> result = propertyPromise.map((List<Property> list) -> ok(Json.toJson(createResponse("0", "OK", list))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("1", error.getMessage())));

                }
        );
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve property by ID",
            notes = "Get property by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.PropertyListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = dto.PropertyResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
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

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString()
                , propertyID, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        Promise<Property> propertyPromise = Promise.wrap(propertyRepository.retrieveById(propertyID));

        Promise<Result> result = propertyPromise.map(res -> ok(Json.toJson(createResponse("0", "OK", res))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }


}
