package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.CountryListResponse;
import dto.CountryResponse;
import model.Country;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CountryRepository;
import util.SecurityUtil;

/**
 * API country controller
 *
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/country", description = "Operations to manage application countries stored in DB")
public class CountryController extends BaseController {

    @Inject
    CountryRepository countryRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllCountries",
            value = "All countries list",
            notes = "Obtain list of all countries stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = CountryListResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = CountryListResponse.class),
            @ApiResponse(code = 1, message = "DB error"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveAll() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        final Promise<Result> result = Promise.wrap(countryRepository.retrieveAll()).map(countries -> ok(Json.toJson(new CountryListResponse("0", "OK", countries))));

        return result.recover(error -> {
            Logger.error("Error:", error);
            return ok(Json.toJson(createResponse("1", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve country by ID",
            notes = "Get country by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = CountryResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = CountryResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "countryID", value = "Country ID to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+countryID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByID(String countryID) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                countryID, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        if (StringUtils.isBlank(countryID)) {

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        Promise<Country> countryPromise = Promise.wrap(countryRepository.retrieveById(countryID));

        Promise<Result> result = countryPromise.map(res -> ok(Json.toJson(new CountryResponse("0", "OK", res))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateCountry",
            value = "Update existed country",
            notes = "Update existed application country in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Country was updated successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Country request", required = true, dataType = "model.Country", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+country.code+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> update() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        Country country = null;

        try {
            country = Json.fromJson(jsonNode, Country.class);

            if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                    country.getCode(), authData.getOrderId(), authData.getAccount().getSecret()))) {
                Logger.error("Provided and calculated enckeys do not match");
                return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
            }

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        final Promise<Country> countryPromise = Promise.wrap(countryRepository.update(country));

        Promise<Result> result = countryPromise.map(res -> ok(Json.toJson(createResponse("0", "Country was updated successfully"))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }

}