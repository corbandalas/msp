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
import exception.CustomerAlreadyRegisteredException;
import exception.WrongCountryException;
import exception.WrongPhoneNumberException;
import model.*;
import model.Card;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.*;
import services.OperationService;
import services.PayrollService;
import sms.SmsGateway;
import util.CurrencyUtil;
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
import util.Utils;

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

    @Inject
    PayrollService payrollService;

    @Inject
    AccountRepository accountRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    SmsGateway smsGateway;

    @Inject
    CardRepository cardRepository;

    @Inject
    OperationService operationService;

    @Inject
    CurrencyRepository currencyRepository;



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
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+totalSum+currency+description+secret)",
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
                        StringUtils.isBlank(createCard.getCurrency()) ||
                        (createCard.getCards().size() == 0)) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(),
                "" + createCard.getTotalSum(),  createCard.getCurrency(), createCard.getDescription(), authData.getAccount().getSecret()))) {
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


        F.Promise<Optional<Currency>> payrollCurrencyPromise = F.Promise.wrap(currencyRepository.retrieveById(createCard.getCurrency()));
        Promise<F.Tuple<Double, Currency>> payrollAccountBalance = payrollService.getPayrollAccountBalance(authData.getAccount().getId());


        Promise<Result> result = payrollRequestPromise.flatMap(res -> Promise.sequence(createCard.getCards().parallelStream().map(t -> Promise.wrap(payrollCardRepository.create(new PayrollCard(1L, res.getId(), t.getAccno(), null, null, t.getTitle(), t.getLastName(), t.getFirstName(), t.getDob(), t.getEmail(), t.getMobtel(), t.getAddrl1(), t.getAddrl2(), t.getAddrl3(), t.getCity(), t.getPostcode(), t.getCountry(), t.getAmount(), t.getCurrency(), null, null, null, t.getIsLive(), null, PayrollCardStatus.REQUESTED, PayrollCardType.CARD_CREATION, authData.getAccount().getId())))).collect(Collectors.toList()))).zip(payrollAccountBalance).zip(ftpPropertyPromise).zip(payrollRequestPromise).zip(propertyPromise).zip(payrollCurrencyPromise).map(ttt -> {

            Currency payrollCurrency = ttt._2.get();

            F.Tuple<Double, Currency> walletBalance = ttt._1._1._1._1._2;

            Long convertedPayrollAmount = CurrencyUtil.convert(createCard.getTotalSum(), Optional.of(payrollCurrency), Optional.of(walletBalance._2));

            Logger.info("Total payroll amount " + createCard.getTotalSum() + " " + createCard.getCurrency() + " is " + convertedPayrollAmount + " " + walletBalance._2.getId());

            if (walletBalance._1.longValue() < convertedPayrollAmount) {
                Logger.error("Not enough funds error");
                return createNotEnoughFundsResponse();
            }

            Property property = ttt._1._1._1._2.get();
            Logger.info("Property = " + property.getValue());

            String[] split = StringUtils.split(property.getValue(), "|");

            String crdProduct = split[0];
            String designRef = split[1];
            String producePin = split[2];
            String mccGroup = split[3];
            String permGrpoup = split[4];
            String carrierRef = split[5];
            String programManagerCode = split[6];


            Property ftpProperty = ttt._1._2.get();

            Logger.info("ftpProperty = " + ftpProperty.getValue());

            String[] ftpSplit = StringUtils.split(ftpProperty.getValue(), "|");

            String ftpHost = ftpSplit[0];
            Integer ftpPort = Integer.parseInt(ftpSplit[1]);
            String ftpUsername = ftpSplit[2];
            String ftpPassword = ftpSplit[3];


            String ftpXMLRequest = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?> <CRDREQ><HEADER>" +
//                    "<order_ref>" + /*authData.getOrderId()*/ "NULL" + "</order_ref> " +
//                    "<order_value>NULL</order_value> " +
//                    "<account_number>NULL</account_number>" +
                    "</HEADER>" +
                    "";

            for (PayrollCard payrollCard : ttt._1._1._1._1._1) {
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

                String fileName = programManagerCode + "-GPScrdreq" + (new SimpleDateFormat(dateFormat, Locale.ENGLISH)).format(new Date()) + ttt._1._1._2.getDaySequence() + ".xml";

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

            return ok(Json.toJson(new PayrollCreateCardResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), "" + ttt._1._1._2.getId())));
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
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+totalSum+currency+description+secret)",
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
                        StringUtils.isBlank(createCard.getCurrency()) ||
                        (createCard.getCards().size() == 0)
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(),
                "" + createCard.getTotalSum(), createCard.getCurrency(), createCard.getDescription(), authData.getAccount().getSecret()))) {
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

        F.Promise<Optional<Currency>> payrollCurrencyPromise = F.Promise.wrap(currencyRepository.retrieveById(createCard.getCurrency()));
        Promise<F.Tuple<Double, Currency>> payrollAccountBalance = payrollService.getPayrollAccountBalance(authData.getAccount().getId());


        Promise<Result> result = payrollRequestPromise.flatMap(res -> Promise.sequence(createCard.getCards().parallelStream().map(t -> Promise.wrap(payrollCardRepository.create(new PayrollCard(1L, res.getId(), t.getAccno(), t.getPubToken(), null, t.getTitle(), t.getLastName(), t.getFirstName(), t.getDob(), t.getEmail(), t.getMobtel(), t.getAddrl1(), t.getAddrl2(), t.getAddrl3(), t.getCity(), t.getPostcode(), t.getCountry(), t.getAmount(), t.getCurrency(), null, null, null, t.getIsLive(), null, PayrollCardStatus.REQUESTED, PayrollCardType.CARD_DEPOSIT, authData.getAccount().getId())))).collect(Collectors.toList()))).zip(payrollAccountBalance).zip(ftpPropertyPromise).zip(payrollRequestPromise).zip(propertyPromise).zip(payrollCurrencyPromise).map(ttt -> {

            Currency payrollCurrency = ttt._2.get();

            F.Tuple<Double, Currency> walletBalance = ttt._1._1._1._1._2;

            Long convertedPayrollAmount = CurrencyUtil.convert(createCard.getTotalSum(), Optional.of(payrollCurrency), Optional.of(walletBalance._2));

            Logger.info("Total payroll amount " + createCard.getTotalSum() + " " + createCard.getCurrency() + " is " + convertedPayrollAmount + " " + walletBalance._2.getId());

            if (walletBalance._1.longValue() < convertedPayrollAmount) {
                Logger.error("Not enough funds error");
                return createNotEnoughFundsResponse();
            }


            Property property = ttt._1._1._1._2.get();
            Logger.info("Property = " + property.getValue());

            String[] split = StringUtils.split(property.getValue(), "|");

            String crdProduct = split[0];
            String designRef = split[1];
            String producePin = split[2];
            String mccGroup = split[3];
            String permGrpoup = split[4];
            String carrierRef = split[5];
            String programManagerCode = split[6];


            Property ftpProperty = ttt._1._2.get();

            Logger.info("ftpProperty = " + ftpProperty.getValue());

            String[] ftpSplit = StringUtils.split(ftpProperty.getValue(), "|");

            String ftpHost = ftpSplit[0];
            Integer ftpPort = Integer.parseInt(ftpSplit[1]);
            String ftpUsername = ftpSplit[2];
            String ftpPassword = ftpSplit[3];


            String ftpXMLRequest = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?> <CRDREQ><HEADER>" +
//                    "<order_ref>" + authData.getOrderId() + "</order_ref> " +
                    "</HEADER>" +
                    "";

            for (PayrollCard payrollCard : ttt._1._1._1._1._1) {
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

                String fileName = programManagerCode + "-GPScrdreq" + (new SimpleDateFormat(dateFormat, Locale.ENGLISH)).format(new Date()) + ttt._1._1._2.getDaySequence() + ".xml";

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

            return ok(Json.toJson(new PayrollCreateCardResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), "" + ttt._1._1._2.getId())));
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


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "getPayrollAccountBalance",
            value = "Retrieve payroll account balance",
            notes = "Method allows to retrieve payroll account balance",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = PayrollAccountBalanceResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PayrollAccountBalanceResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Retrieve payroll account balance request", required = true, dataType = "dto.payroll.PayrollAccountBalanceRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")
    })
    public F.Promise<Result> getPayrollAccountBalance() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        Promise<Result> result = payrollService.getPayrollAccountBalance(authData.getAccount().getId()).map(balance -> ok(Json.toJson(new PayrollAccountBalanceResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), balance._1, balance._2.getId()))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createPayrollAccount",
            value = "Create payroll account",
            notes = "Method allows to create payroll account",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = PayrollCreateAccountResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PayrollCreateAccountResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Retrieve payroll account balance request", required = true, dataType = "dto.payroll.PayrollCreateAccountRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+name+currency+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")
    })
    public F.Promise<Result> createPayrollAccount() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final PayrollCreateAccountRequest payrollCreateAccountRequest;

        try {

            payrollCreateAccountRequest = Json.fromJson(jsonNode, PayrollCreateAccountRequest.class);

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(payrollCreateAccountRequest.getName())
                || StringUtils.isBlank(payrollCreateAccountRequest.getCurrencyId())
                || StringUtils.isBlank(payrollCreateAccountRequest.getContactFirstName())
                || StringUtils.isBlank(payrollCreateAccountRequest.getContactLastName())
                || StringUtils.isBlank(payrollCreateAccountRequest.getPhoneNumber())
                || StringUtils.isBlank(payrollCreateAccountRequest.getCountry())
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), payrollCreateAccountRequest.getName(), payrollCreateAccountRequest.getCurrencyId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final String country = payrollCreateAccountRequest.getCountry();
        final String phone = payrollCreateAccountRequest.getPhoneNumber();

        final Promise<F.Tuple<Boolean, Boolean>> resultPromise = Promise.wrap(countryRepository.checkCountry(country)).zip(Promise.wrap(customerRepository.isRegistered(phone)));

        final Promise<Result> result = resultPromise.flatMap(rez -> {

            if (!rez._1) {
                Logger.error("Country is not exist");

                throw new WrongCountryException("Country is not exist or inactive");
            }

            if (rez._2) {
                Logger.error("Customer is already registered");

                throw new CustomerAlreadyRegisteredException("Customer is already registered");
            }

            final String password = RandomStringUtils.randomNumeric(4);


            if (!Utils.isValidPhoneNumber(phone, country)) {
                throw new WrongPhoneNumberException();
            }

            final Customer customer = new Customer();

            customer.setActive(true);
            customer.setCountry_id(country);
            customer.setKyc(KYC.NONE);
            customer.setPassword(SecurityUtil.generateKeyFromArray(password));
            customer.setId(phone);
            customer.setRegistrationDate(new Date());
            customer.setDateBirth(new Date());
            customer.setTemppassword(true);
            customer.setFirstName(payrollCreateAccountRequest.getContactFirstName());
            customer.setLastName(payrollCreateAccountRequest.getContactLastName());

            Card card = new Card();

            card.setActive(true);
            card.setAlias("alias");
            card.setBrand(CardBrand.WALLET);
            card.setCardDefault(true);
            card.setCreateDate(new Date());
            card.setCurrencyId("EUR");
            card.setCustomerId(phone);
            card.setDeliveryAddress1("address 1");
            card.setDeliveryAddress2("address 2");
            card.setDeliveryAddress3("address 3");
            card.setDeliveryCountry(country);
            card.setInfo("");
            card.setToken(SecurityUtil.generateKeyFromArray(phone, country, payrollCreateAccountRequest.getContactFirstName()));
            card.setType(CardType.VIRTUAL);


            return Promise.wrap(customerRepository.create(customer)).zip(Promise.wrap(cardRepository.create(card))).zip(Promise.pure(password));

        }).map(res -> {

            Account account = new Account();
            account.setActive(true);
            account.setCreateDate(new Date());
            account.setName(payrollCreateAccountRequest.getName());
            account.setCurrencyId(payrollCreateAccountRequest.getCurrencyId());
            account.setSecret(SecurityUtil.generateKeyFromArray(payrollCreateAccountRequest.getName(), payrollCreateAccountRequest.getCurrencyId()));
            account.setCardId(res._1._2.getId());

            accountRepository.create(account);


            smsGateway.sendSMS(phone, "Dear customer! Thank you for registration. Your temporary PIN code is " + res._2 + ". Please visit mysafepay.dk to complete registration.");

            return ok(Json.toJson(new PayrollCreateAccountResponse("" + SUCCESS_CODE, SUCCESS_TEXT)));
        });


        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "depositPayrollAccount",
            value = "Deposit payroll account",
            notes = "Method allows to deposit payroll account",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = PayrollAccountBalanceResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = PayrollDepositAccountResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = PayrollDepositAccountResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Deposit payroll account request", required = true, dataType = "dto.payroll.DepositPayrollAccountRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+amount+currency+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")
    })
    public F.Promise<Result> deposit() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        final PayrollDepositAccountRequest payrollDepositAccountRequest;

        try {

            payrollDepositAccountRequest = Json.fromJson(jsonNode, PayrollDepositAccountRequest.class);

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(payrollDepositAccountRequest.getCurrency())
                || payrollDepositAccountRequest.getAmount() == null
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), "" + payrollDepositAccountRequest.getAmount(), payrollDepositAccountRequest.getCurrency(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        Account account = authData.getAccount();

        Promise<Optional<Card>> cardPromise = Promise.wrap(cardRepository.retrieveById(account.getCardId()));
        Promise<Optional<Currency>> currencyPromise = Promise.wrap(currencyRepository.retrieveById(payrollDepositAccountRequest.getCurrency()));


        final Promise<Result> result = cardPromise.zip(currencyPromise).flatMap(res -> operationService.createDepositOperation(res._1.get(), payrollDepositAccountRequest.getAmount(), res._2.get(), payrollDepositAccountRequest.getOrderId(), payrollDepositAccountRequest.getDescription()).map(ttt -> ok(Json.toJson(new PayrollDepositAccountResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE))))));

        return returnRecover(result);
    }

}
