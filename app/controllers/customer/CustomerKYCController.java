package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.customer.CustomerKYCCheck;
import dto.customer.CustomerKYCCheckResponse;
import dto.customer.CustomerKYCResponse;
import dto.customer.KYCServiceResult;
import model.Card;
import model.Customer;
import model.enums.KYC;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_Resources.ServiceTransactionInformation;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.CardRepository;
import repository.CustomerRepository;
import services.W2GlobaldataService;

import java.util.ArrayList;
import java.util.List;

import static configs.ReturnCodes.*;


/**
 * Customer card list API controller
 *
 * @author corbandalas - created 17.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/kyc", description = "Customer KYC check UK")
public class CustomerKYCController extends BaseController {

    @Inject
    W2GlobaldataService w2GlobaldataService;

    @Inject
    CacheApi cache;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CardRepository cardRepository;

    @Inject
    CardProvider cardProvider;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "kyc/checkUK",
            value = "Check kyc for UK",
            notes = "Allow check kyc by present data",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CustomerKYCCheckResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerKYCCheckResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_COUNTRY_CODE, message = INCORRECT_COUNTRY_TEXT)
    })

    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Check KYC request", required = true, dataType = "dto.customer.CustomerKYCCheck", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public Promise<Result> kycCheck() {

        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerKYCCheck request;
        final String bundleName;
        try {
            request = Json.fromJson(jsonNode, CustomerKYCCheck.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return F.Promise.pure(createWrongRequestFormatResponse());
        }
        if (request.getKycType().equalsIgnoreCase("FDD")) {
            bundleName = "KYC_UK_SafePay_FDD";
        } else {
            bundleName = "KYC_UK_SafePay_SDD";
        }

        final Promise<Result> result = w2GlobaldataService.kycCheckCommon(request.getNameQuery(), request.getForename(), request.getMiddleNames(), request.getSurname(), request.getDateOfBirth()).flatMap(details -> {
            if (details.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue().equalsIgnoreCase("Pass")) {


                if (request.getCountry().equalsIgnoreCase("GBR")) {
                    return w2GlobaldataService.kycCheckUK(request.getForename(), request.getMiddleNames(), request.getSurname(), request.getDateOfBirth(), request.getHouseNameNumber(), request.getPostcode(), request.getFlat(), request.getStreet(), request.getCountry(), request.getCity(), request.getPhoneNumber(), bundleName).flatMap(
                            details2 -> {

                                List<KYCServiceResult> kycServiceResults2 = new ArrayList<KYCServiceResult>();

                                for (ServiceTransactionInformation serviceTransactionInformation : details2.getProcessRequestResult().getTransactionInformation().getServiceTransactions()) {
                                    kycServiceResults2.add(new KYCServiceResult(serviceTransactionInformation.getService().getValue(), serviceTransactionInformation.getServiceInterpretResult().getValue(), serviceTransactionInformation.getServiceTransactionResultMessage()));
                                }

                                if (details2.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue().equalsIgnoreCase("Pass")) {
                                    if (request.getKycType().equalsIgnoreCase("FDD")) {
                                        customer.setKyc(KYC.FULL_DUE_DILIGENCE);
                                    } else {
                                        customer.setKyc(KYC.SIMPLIFIED_DUE_DILIGENCE);
                                    }
                                }

                                return Promise.wrap(customerRepository.update(customer)).zip(Promise.pure(details2)).zip(Promise.pure(kycServiceResults2));

                            }).map(res -> {

                        changeCardGroup(customer);

                        return ok(Json.toJson(
                                new CustomerKYCCheckResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res._1._2.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue(), res._2, null, res._1._2.getProcessRequestResult().getTransactionInformation().getServiceCallReference())));
                    });
                } else if (request.getCountry().equalsIgnoreCase("SWE") || request.getCountry().equalsIgnoreCase("DNK") || request.getCountry().equalsIgnoreCase("NOR")) {

                    Boolean skipScandiBankId = null;

                    if (request.getKycType().equalsIgnoreCase("SDD")) {
                        skipScandiBankId = true;
                    }

                    return w2GlobaldataService.scandyService(request.getForename(), request.getSurname(), request.getDateOfBirth(), request.getHouseNameNumber(), request.getPostcode(), request.getStreet(), request.getCountry(), request.getCity(), request.getScandyTestdatanumber(), skipScandiBankId).flatMap(
                            details2 -> {

                                List<KYCServiceResult> kycServiceResults2 = new ArrayList<KYCServiceResult>();

                                for (ServiceTransactionInformation serviceTransactionInformation : details2.getProcessRequestResult().getTransactionInformation().getServiceTransactions()) {
                                    kycServiceResults2.add(new KYCServiceResult(serviceTransactionInformation.getService().getValue(), serviceTransactionInformation.getServiceInterpretResult().getValue(), serviceTransactionInformation.getServiceTransactionResultMessage()));
                                }

/*                                if (details2.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue().equalsIgnoreCase("Pass")) {
                                    if (request.getKycType().equalsIgnoreCase("SDD")) {
                                        customer.setKyc(KYC.SIMPLIFIED_DUE_DILIGENCE);
                                    }
                                }*/

                                cache.set(details2.getProcessRequestResult().getTransactionInformation().getServiceCallReference(), customer.getId().concat("|").concat(request.getKycType()), 24 * 60 * 60);

                                return Promise.wrap(customerRepository.update(customer)).zip(Promise.pure(details2)).zip(Promise.pure(kycServiceResults2));

                            }).map(res -> {

                        String url = null;

                        if (res._1._2.getProcessRequestResult().getServiceResult().getW2DataEkycScandi025Result() != null)
                            url = res._1._2.getProcessRequestResult().getServiceResult().getW2DataEkycScandi025Result().getBankIdFormUrl();

                        return ok(Json.toJson(
                                new CustomerKYCCheckResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res._1._2.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue(), res._2, url, res._1._2.getProcessRequestResult().getTransactionInformation().getServiceCallReference())));
                    });
                } else {
                    return F.Promise.pure(createIncorrectCountryResponse());
                }

            } else {

                List<KYCServiceResult> kycServiceResults = new ArrayList<KYCServiceResult>();

                for (ServiceTransactionInformation serviceTransactionInformation : details.getProcessRequestResult().getTransactionInformation().getServiceTransactions()) {
                    kycServiceResults.add(new KYCServiceResult(serviceTransactionInformation.getService().getValue(), serviceTransactionInformation.getServiceInterpretResult().getValue(), serviceTransactionInformation.getServiceTransactionResultMessage()));
                }

                return F.Promise.pure(ok(Json.toJson(
                        new CustomerKYCCheckResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), details.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue(), kycServiceResults, null, details.getProcessRequestResult().getTransactionInformation().getServiceCallReference()))));
            }

        });
        return returnRecover(result);
/*
        final Promise<Result> result = w2GlobaldataService.kycCheckUK(request.getForename(), request.getMiddleNames(), request.getSurname(), request.getDateOfBirth(), request.getHouseNameNumber(), request.getPostcode(), request.getFlat(), request.getStreet(), request.getCountry(), request.getCity(), request.getPhoneNumber(), bundleName).flatMap(details ->
        {


            List<KYCServiceResult> kycServiceResults = new ArrayList<KYCServiceResult>();

            for (ServiceTransactionInformation serviceTransactionInformation : details.getProcessRequestResult().getTransactionInformation().getServiceTransactions()) {
                kycServiceResults.add(new KYCServiceResult(serviceTransactionInformation.getService().getValue(), serviceTransactionInformation.getServiceInterpretResult().getValue(), serviceTransactionInformation.getServiceTransactionResultMessage()));
            }

            if (details.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue().equalsIgnoreCase("Pass")) {
                if (request.getKycType().equalsIgnoreCase("FDD")) {
                    customer.setKyc(KYC.FULL_DUE_DILIGENCE);
                } else {
                    customer.setKyc(KYC.SIMPLIFIED_DUE_DILIGENCE);
                }
            }

            return Promise.wrap(customerRepository.update(customer)).zip(Promise.pure(details)).zip(Promise.pure(kycServiceResults));
        }).map(res -> {
            return ok(Json.toJson(
                    new CustomerKYCCheckResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res._1._2.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue(), res._2)));
        });
        return returnRecover(result);*/

    }


    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "kyc/status",
            value = "Obtain customer KYC level",
            notes = "Allow to obtain current KYC level",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CustomerKYCResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerKYCCheckResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public Promise<Result> getKYC() {

        final Customer customer = (Customer) ctx().args.get("customer");

        return Promise.pure(ok(Json.toJson(
                new CustomerKYCResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), customer.getKyc().name()))));

    }


    private void changeCardGroup(Customer customer) {

        final F.Promise<List<Card>> cardsPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));

        cardsPromise.map(res -> res.stream().map(card -> cardProvider.changeCardGroup(customer, card)));
    }


}