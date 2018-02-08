package controllers.payroll;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import controllers.admin.BaseMerchantApiAction;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.payroll.*;
import model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.PayrollCardRepository;
import repository.PayrollRequestRepository;
import repository.PropertyRepository;
import util.SecurityUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import play.libs.F.Promise;

import static configs.ReturnCodes.*;

/**
 * Payroll card API controller
 *
 * @author corbandalas created 28.11.2017.
 * @since 0.7.0
 */
@Api(value = Constants.PAYROLL_API_PATH + "/card", description = "Payroll card processing functions")
public class PayrollCardController extends BaseController {


    @Inject
    PropertyRepository propertyRepository;

    @Inject
    PayrollCardRepository payrollCardRepository;

    @Inject
    PayrollRequestRepository payrollRequestRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "uploadCreateCard",
            value = "Upload payroll card request",
            notes = "Method allows to upload payroll cards request",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = PayrollCreateCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PayrollCreateCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create card request", required = true, dataType = "dto.payroll.PayrollCreateCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+description+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")
    })
    public F.Promise<Result> uploadCreateCard() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final PayrollCreateCardRequest createCard;

        try {

            createCard = Json.fromJson(jsonNode, PayrollCreateCardRequest.class);

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (
                StringUtils.isBlank(createCard.getDescription()) ||
                        (createCard.getCards() == null) ||
                        (createCard.getCards().size() == 0)
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(),
                createCard.getDescription(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        PayrollRequest payrollRequest = new PayrollRequest();

        payrollRequest.setAccountID(authData.getAccount().getId());
        payrollRequest.setCreateDate(new Date());
        payrollRequest.setDescription(createCard.getDescription());
        payrollRequest.setOrderId(authData.getOrderId());
        payrollRequest.setErrorStatus(PayrollRequestStatus.NOT_PROCESSED);

        F.Promise<PayrollRequest> payrollRequestPromise = F.Promise.wrap(payrollRequestRepository.create(payrollRequest));

        Promise<Optional<Property>> propertyPromise = Promise.wrap(propertyRepository.retrieveById("payroll.api.msp.account.settings." + authData.getAccount().getId()));
        Promise<Optional<Property>> ftpPropertyPromise = Promise.wrap(propertyRepository.retrieveById("payroll.api.msp.ftp.settings"));

        Promise<Result> result = payrollRequestPromise.flatMap(res -> Promise.sequence(createCard.getCards().parallelStream().map(t -> Promise.wrap(payrollCardRepository.create(new PayrollCard(1L, res.getId(), t.getAccno(), null, null, t.getTitle(), t.getLastName(), t.getFirstName(), t.getDob(), t.getEmail(), t.getMobtel(), t.getAddrl1(), t.getAddrl2(), t.getAddrl3(), t.getCity(), t.getPostcode(), t.getCountry(), t.getAmount(), t.getCurrency(), null, null, null, t.getIsLive(), null, PayrollCardStatus.REQUESTED, PayrollCardType.CARD_CREATION)))).collect(Collectors.toList()))).zip(ftpPropertyPromise).zip(propertyPromise).zip(payrollRequestPromise).map(ttt -> {

            Property property = ttt._1._2.get();

            String[] split = StringUtils.split(property.getValue(), "|");

            String crdProduct = split[0];
            String designRef = split[1];
            String producePin = split[2];
            String mccGroup = split[3];
            String permGrpoup = split[4];
            String carrierRef = split[5];
            String programManagerCode = split[6];


            Property ftpProperty = ttt._1._1._2.get();

            Logger.info("ftpProperty = " + ftpProperty.getValue());

            String[] ftpSplit = StringUtils.split(ftpProperty.getValue(), "|");

            String ftpHost = ftpSplit[0];
            Integer ftpPort = Integer.parseInt(ftpSplit[1]);
            String ftpUsername = ftpSplit[2];
            String ftpPassword = ftpSplit[3];


            String ftpXMLRequest = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?> <CRDREQ><HEADER>" +
                    "<order_ref>" + authData.getOrderId() + "</order_ref> " +
                    "</HEADER>" +
                    "";

            for (PayrollCard payrollCard : ttt._1._1._1) {
                ftpXMLRequest += "<CARD>" +
                        "<recid>" + payrollCard.getId() + "</recid>" +
                        "<action>" + ((Double.parseDouble(payrollCard.getAmount()) > 0) ? "2" : "1") + "</action>" +
                        "<crdproduct>" + crdProduct + "</crdproduct>" +
                        "<accno>" + payrollCard.getAccno() + "</accno>" +
                        "<pan/>" +
                        "<pubtoken/>" +
                        "<designref>" + designRef + "</designref>" +
                        "<title>" + payrollCard.getTitle() + "</title>" +
                        "<lastname>" + payrollCard.getLastName() + "</lastname>" +
                        "<firstname>" + payrollCard.getFirstName() + "</firstname>" +
                        "<dob>" + payrollCard.getDob() + "</dob>" +
                        "<sex/>" +
                        "<email>" + payrollCard.getEmail() + "</email>" +
                        "<tel/>" +
                        "<mobtel>" + payrollCard.getMobtel() + "</mobtel>" +
                        "<addrl1>" + payrollCard.getAddrl1() + "</addrl1>" +
                        "<addrl2>" + payrollCard.getAddrl2() + "</addrl2>" +
                        "<addrl3>" + payrollCard.getAddrl3() + "</addrl3>" +
                        "<city>" + payrollCard.getCity() + "</city>" +
                        "<county/>" +
                        "<postcode>" + payrollCard.getPostcode() + "</postcode>" +
                        "<country>" + payrollCard.getCountry() + "</country>" +
                        "<currcode>" + payrollCard.getCurrency() + "</currcode>" +
                        "<usrdata1/>" +
                        "<crdusrdata/>" +
                        "<statcode>02</statcode>" +
                        "<islive>" + payrollCard.getIsLive() + "</islive>" +
                        "<expdate/>" +
                        "<lang>1</lang>" +
                        "<producepin>" + producePin + "</producepin>" +
                        "<amtload>" + payrollCard.getAmount() + "</amtload>" +
                        "<loadsrc>14</loadsrc>" +
                        "<accesscode/>" +
                        "<cardname>" + payrollCard.getCardName() + "</cardname>" +
                        "<imageid/>" +
                        "<simplex_line4/>" +
                        "<thermal_line1/>" +
                        "<thermal_line2/>" +
                        "<delv_method>0</delv_method>" +
                        "<limitsgroup/>" +
//                        "<mccgroup>" + mccGroup + "</mccgroup>" +
                        "<permsgroup>" + permGrpoup + "</permsgroup>" +
                        "<carrierref>" + carrierRef + "</carrierref>" +
                        "<delv_code/>" +
                        "<delv_addrl1/>" +
                        "<delv_addrl2/>" +
                        "<delv_addrl3/>" +
                        "<delv_city/>" +
                        "<delv_county/>" +
                        "<delv_postcode/>" +
                        "<delv_country/>" +
                        "<fulfil1/>" +
                        "<fulfil1/>" +
                        "<logo_front_id/>" +
                        "<logo_back_id/></CARD>";

            }

            ftpXMLRequest += "</CRDREQ>";


            Logger.info("Constructed XML: " + ftpXMLRequest);

            FTPClient ftpClient = new FTPClient();


            try {

                ftpClient.connect(ftpHost, ftpPort);
                ftpClient.login(ftpUsername, ftpPassword);
                ftpClient.enterLocalPassiveMode();

                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                InputStream stream = new ByteArrayInputStream(ftpXMLRequest.getBytes(StandardCharsets.UTF_8.name()));

                String dateFormat = "yyMMdd";

                String fileName = programManagerCode + "-GPScrdreq" + (new SimpleDateFormat(dateFormat, Locale.ENGLISH)).format(new Date()) + ttt._2.getDaySequence() + ".xml";

                Logger.info("File name = " + fileName);

                boolean done = ftpClient.storeFile(fileName, stream);
                stream.close();
                if (done) {
                    Logger.info("The " + fileName + " file is uploaded successfully.");
                }


            } catch (IOException ex) {
                Logger.error("Error: " + ex.getMessage(), ex);
            } finally {
                try {
                    if (ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                } catch (IOException ex) {
                    Logger.error("Error: " + ex.getMessage(), ex);
                }
            }

            return ok(Json.toJson(new PayrollCreateCardResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), "" + ttt._2.getId())));
        });


        return returnRecover(result);
    }


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "uploadDepositCard",
            value = "Upload payroll deposit card request",
            notes = "Method allows to upload payroll cards request",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = PayrollCreateCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PayrollCreateCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Deposit card request", required = true, dataType = "dto.payroll.PayrollDepositCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+description+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")
    })
    public F.Promise<Result> depositCard() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final PayrollDepositCardRequest createCard;

        try {

            createCard = Json.fromJson(jsonNode, PayrollDepositCardRequest.class);

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (
                StringUtils.isBlank(createCard.getDescription()) ||
                        (createCard.getCards() == null) ||
                        (createCard.getCards().size() == 0)
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(),
                createCard.getDescription(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        PayrollRequest payrollRequest = new PayrollRequest();

        payrollRequest.setAccountID(authData.getAccount().getId());
        payrollRequest.setCreateDate(new Date());
        payrollRequest.setDescription(createCard.getDescription());
        payrollRequest.setOrderId(authData.getOrderId());
        payrollRequest.setErrorStatus(PayrollRequestStatus.NOT_PROCESSED);

        F.Promise<PayrollRequest> payrollRequestPromise = F.Promise.wrap(payrollRequestRepository.create(payrollRequest));

        Promise<Optional<Property>> propertyPromise = Promise.wrap(propertyRepository.retrieveById("payroll.api.msp.account.settings." + authData.getAccount().getId()));
        Promise<Optional<Property>> ftpPropertyPromise = Promise.wrap(propertyRepository.retrieveById("payroll.api.msp.ftp.settings"));

        Promise<Result> result = payrollRequestPromise.flatMap(res -> Promise.sequence(createCard.getCards().parallelStream().map(t -> Promise.wrap(payrollCardRepository.create(new PayrollCard(1L, res.getId(), t.getAccno(), t.getPubToken(), null, t.getTitle(), t.getLastName(), t.getFirstName(), t.getDob(), t.getEmail(), t.getMobtel(), t.getAddrl1(), t.getAddrl2(), t.getAddrl3(), t.getCity(), t.getPostcode(), t.getCountry(), t.getAmount(), t.getCurrency(), null, null, null, t.getIsLive(), null, PayrollCardStatus.REQUESTED, PayrollCardType.CARD_DEPOSIT)))).collect(Collectors.toList()))).zip(ftpPropertyPromise).zip(propertyPromise).zip(payrollRequestPromise).map(ttt -> {

            Property property = ttt._1._2.get();

            String[] split = StringUtils.split(property.getValue(), "|");

            String crdProduct = split[0];
            String designRef = split[1];
            String producePin = split[2];
            String mccGroup = split[3];
            String permGrpoup = split[4];
            String carrierRef = split[5];
            String programManagerCode = split[6];


            Property ftpProperty = ttt._1._1._2.get();

            Logger.info("ftpProperty = " + ftpProperty.getValue());

            String[] ftpSplit = StringUtils.split(ftpProperty.getValue(), "|");

            String ftpHost = ftpSplit[0];
            Integer ftpPort = Integer.parseInt(ftpSplit[1]);
            String ftpUsername = ftpSplit[2];
            String ftpPassword = ftpSplit[3];


            String ftpXMLRequest = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?> <CRDREQ><HEADER>" +
                    "<order_ref>" + authData.getOrderId() + "</order_ref> " +
                    "</HEADER>" +
                    "";

            for (PayrollCard payrollCard : ttt._1._1._1) {
                ftpXMLRequest += "<CARD>" +
                        "<recid>" + payrollCard.getId() + "</recid>" +
                        "<action>3</action>" +
                        "<crdproduct>" + crdProduct + "</crdproduct>" +
                        "<accno>" + payrollCard.getAccno() + "</accno>" +
                        "<pan/>" +
                        "<pubtoken>" + payrollCard.getPubtoken() + "</pubtoken>" +
                        "<designref>" + designRef + "</designref>" +
                        "<title>" + payrollCard.getTitle() + "</title>" +
                        "<lastname>" + payrollCard.getLastName() + "</lastname>" +
                        "<firstname>" + payrollCard.getFirstName() + "</firstname>" +
                        "<dob>" + payrollCard.getDob() + "</dob>" +
                        "<sex/>" +
                        "<email>" + payrollCard.getEmail() + "</email>" +
                        "<tel/>" +
                        "<mobtel>" + payrollCard.getMobtel() + "</mobtel>" +
                        "<addrl1>" + payrollCard.getAddrl1() + "</addrl1>" +
                        "<addrl2>" + payrollCard.getAddrl2() + "</addrl2>" +
                        "<addrl3>" + payrollCard.getAddrl3() + "</addrl3>" +
                        "<city>" + payrollCard.getCity() + "</city>" +
                        "<county/>" +
                        "<postcode>" + payrollCard.getPostcode() + "</postcode>" +
                        "<country>" + payrollCard.getCountry() + "</country>" +
                        "<currcode>" + payrollCard.getCurrency() + "</currcode>" +
                        "<usrdata1/>" +
                        "<crdusrdata/>" +
                        "<statcode>02</statcode>" +
                        "<islive>" + payrollCard.getIsLive() + "</islive>" +
                        "<expdate/>" +
                        "<lang>1</lang>" +
                        "<producepin>" + producePin + "</producepin>" +
                        "<amtload>" + payrollCard.getAmount() + "</amtload>" +
                        "<loadsrc>14</loadsrc>" +
                        "<accesscode/>" +
                        "<cardname>" + payrollCard.getCardName() + "</cardname>" +
                        "<imageid/>" +
                        "<simplex_line4/>" +
                        "<thermal_line1/>" +
                        "<thermal_line2/>" +
                        "<delv_method>0</delv_method>" +
                        "<limitsgroup/>" +
                        "<mccgroup>" + mccGroup + "</mccgroup>" +
                        "<permsgroup>" + permGrpoup + "</permsgroup>" +
                        "<carrierref>" + carrierRef + "</carrierref>" +
                        "<delv_code/>" +
                        "<delv_addrl1/>" +
                        "<delv_addrl2/>" +
                        "<delv_addrl3/>" +
                        "<delv_city/>" +
                        "<delv_county/>" +
                        "<delv_postcode/>" +
                        "<delv_country/>" +
                        "<fulfil1/>" +
                        "<fulfil1/>" +
                        "<logo_front_id/>" +
                        "<logo_back_id/></CARD>";

            }

            ftpXMLRequest += "</CRDREQ>";


            Logger.info("Constructed XML: " + ftpXMLRequest);

            FTPClient ftpClient = new FTPClient();


            try {

                ftpClient.connect(ftpHost, ftpPort);
                ftpClient.login(ftpUsername, ftpPassword);
                ftpClient.enterLocalPassiveMode();

                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                InputStream stream = new ByteArrayInputStream(ftpXMLRequest.getBytes(StandardCharsets.UTF_8.name()));

                String dateFormat = "yyMMdd";

                String fileName = programManagerCode + "-GPScrdreq" + (new SimpleDateFormat(dateFormat, Locale.ENGLISH)).format(new Date()) + ttt._2.getDaySequence();

                Logger.info("File name = " + fileName);

                boolean done = ftpClient.storeFile(fileName, stream);
                stream.close();
                if (done) {
                    Logger.info("The " + fileName + " file is uploaded successfully.");
                }


            } catch (IOException ex) {
                Logger.error("Error: " + ex.getMessage(), ex);
            } finally {
                try {
                    if (ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                } catch (IOException ex) {
                    Logger.error("Error: " + ex.getMessage(), ex);
                }
            }

            return ok(Json.toJson(new PayrollCreateCardResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), "" + ttt._2.getId())));
        });


        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "getPayrollRequestStatuses",
            value = "Retrieve payroll card request statuses",
            notes = "Method allows to retrieve payroll cards request statuses",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = PayrollRequestStatusesResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PayrollRequestStatusesResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Retrieve payroll status request", required = true, dataType = "dto.payroll.PayrollStatusRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")
    })
    public F.Promise<Result> getPayrollRequestsStatuses() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final PayrollStatusRequest payrollStatusRequest;

        try {

            payrollStatusRequest = Json.fromJson(jsonNode, PayrollStatusRequest.class);

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        Promise<Result> result = null;

        if (StringUtils.isBlank(payrollStatusRequest.getAccountID())) {
            result = Promise.wrap(payrollRequestRepository.retrieveAll()).map(list -> ok(Json.toJson(new PayrollRequestStatusesResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), list))));
        } else {
            result = Promise.wrap(payrollRequestRepository.retrieveAllByAccountID(Integer.parseInt(payrollStatusRequest.getAccountID()))).map(list -> ok(Json.toJson(new PayrollRequestStatusesResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), list))));
        }

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "getPayrollCardStatuses",
            value = "Retrieve payroll card  statuses",
            notes = "Method allows to retrieve payroll cards  statuses",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = PayrollRequestCardStatusesResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PayrollRequestCardStatusesResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Retrieve payroll card status request", required = true, dataType = "dto.payroll.PayrollStatusCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+payrollRequestId+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")
    })
    public F.Promise<Result> getPayrollCardStatuses() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final PayrollStatusCardRequest payrollStatusCardRequest;

        try {

            payrollStatusCardRequest = Json.fromJson(jsonNode, PayrollStatusCardRequest.class);

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(payrollStatusCardRequest.getPayrollRequestID())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), payrollStatusCardRequest.getPayrollRequestID(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        Promise<Result> result = Promise.wrap(payrollCardRepository.retrieveAllByRequestID(Long.parseLong(payrollStatusCardRequest.getPayrollRequestID()))).map(list -> ok(Json.toJson(new PayrollRequestCardStatusesResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), list))));

        return returnRecover(result);
    }

}
