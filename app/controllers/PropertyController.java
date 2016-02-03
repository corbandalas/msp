package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.mvc.Result;
import repository.PropertyRepository;

import model.Property;
import play.libs.F.Promise;
import play.libs.Json;

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


    @ApiOperation(
            nickname = "createProperty",
            value = "Create new property",
            notes = "Store new application property in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = dto.BaseAPIResponse.class
    )

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "Property was created successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Property request", required = true, dataType = "model.Property", paramType = "body")})


    public Promise<Result> create() {

        final JsonNode jsonNode = request().body().asJson();

        Property property = null;

        try {
            property = Json.fromJson(jsonNode, Property.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        final Promise<Property> propertyPromise = Promise.wrap(propertyRepository.create(property));

        Promise<Result> result = propertyPromise.map(res -> ok(Json.toJson(createResponse("0", "Property was created successfully"))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }


    @ApiOperation(
            nickname = "updateProperty",
            value = "Update existed property",
            notes = "Update existed application property in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = dto.BaseAPIResponse.class
    )

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "Property was updated successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Property request", required = true, dataType = "model.Property", paramType = "body")})


    public Promise<Result> update() {

        final JsonNode jsonNode = request().body().asJson();

        Property property = null;

        try {
            property = Json.fromJson(jsonNode, Property.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        final Promise<Property> propertyPromise = Promise.wrap(propertyRepository.update(property));

        Promise<Result> result = propertyPromise.map(res -> ok(Json.toJson(createResponse("0", "Property was updated successfully"))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }


    @ApiOperation(
            nickname = "listAllProperty",
            value = "All property list",
            notes = "Obtain list of all application properties stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.PropertyListResponse.class
    )

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "OK", response = dto.PropertyListResponse.class),
            @ApiResponse(code = 1, message = "DB error"),
    })
    public Promise<Result> retrieveAll() {

        final Promise<List<Property>> propertyPromise = Promise.wrap(propertyRepository.retrieveAll());

        Promise<Result> result = propertyPromise.map((List<Property> list) -> ok(Json.toJson(createResponse("0", "OK", list))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("1", error.getMessage())));

                }
        );
    }


    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve property by ID",
            notes = "Get property by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.PropertyListResponse.class
    )

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "OK", response = dto.PropertyResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "propertyID", value = "Property ID to retrieve", required = true, dataType = "string", paramType = "path")
    })
    public Promise<Result> retrieveByID(String propertyID) {

        if (StringUtils.isBlank(propertyID)) {

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
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
