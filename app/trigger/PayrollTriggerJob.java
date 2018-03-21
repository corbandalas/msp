package trigger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.payroll.Card;
import dto.payroll.PayrollErrorResponseBean;
import dto.payroll.response.CardCreationResponse;
import dto.payroll.response.RECORD;
import model.*;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import play.Logger;
import play.libs.F;
import repository.*;
import sms.SmsGateway;
import util.SecurityUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Payroll trigger job
 *
 * @author corbandalas - created 03.12.2017
 * @since 0.7.0
 */

@Singleton
public class PayrollTriggerJob implements Runnable {

    @Inject
    private CurrencyRepository currencyRepository;

    @Inject
    private PropertyRepository propertyRepository;

    @Inject
    private PayrollRequestRepository payrollRequestRepository;

    @Inject
    private PayrollCardRepository payrollCardRepository;

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private CountryRepository countryRepository;

    @Inject
    private SmsGateway smsGateway;

    @Inject
    private CardRepository cardRepository;

    @Override
    public void run() {

        Logger.info("////////////////////////////// Payroll trigger job WORKS!!!!");


        F.Promise<Optional<Property>> ftpPropertyPromise = F.Promise.wrap(propertyRepository.retrieveById("payroll.api.msp.ftp.settings"));

        ftpPropertyPromise.map(ftpSettings -> {


            String[] ftpSplit = StringUtils.split(ftpSettings.get().getValue(), "|");

            String ftpHost = ftpSplit[0];
            Integer ftpPort = Integer.parseInt(ftpSplit[1]);
            String ftpUsername = ftpSplit[2];
            String ftpPassword = ftpSplit[3];


            FTPClient ftpClient = new FTPClient();

            try {

                ftpClient.connect(ftpHost, ftpPort);
                ftpClient.login(ftpUsername, ftpPassword);
                ftpClient.enterLocalPassiveMode();

                FTPFile[] ftpFiles = ftpClient.listFiles();

                for (FTPFile file : ftpFiles) {

                    Logger.info("Found " + file.getName() + " file");


                    //ERROR RESPONSE PARSING

                    if (file.getName().contains("error")) {
                        Logger.info("Found error file. Get Date and sequence number from " + file.getName());

                        String dateAndSequence = StringUtils.substringBetween(file.getName(), "crdreq", ".xml.error.xml");

                        Logger.info("DateAndSequence for file " + file.getName() + " is " + dateAndSequence);

                        F.Promise.wrap(payrollRequestRepository.retrieveNotProcessedByDateAndSequence(dateAndSequence)).map(request -> {

                            if (request.isPresent()) {
                                try {
                                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                                    ftpClient.retrieveFile(file.getName(), outputStream);
                                    InputStream inputstream = new ByteArrayInputStream(outputStream.toByteArray());

                                    JAXBContext jaxbContext = JAXBContext.newInstance(PayrollErrorResponseBean.class);

                                    PayrollErrorResponseBean payrollErrorResponse = (PayrollErrorResponseBean) jaxbContext.createUnmarshaller().unmarshal(inputstream);

                                    outputStream.close();
                                    inputstream.close();


                                    for (Card card : payrollErrorResponse.getCard()) {
                                        F.Promise.wrap(payrollCardRepository.retrieveById(Long.parseLong(card.getRecid()))).map(cardEntry -> {
                                            if (cardEntry.isPresent()) {
                                                PayrollCard payrollCard = cardEntry.get();

                                                payrollCard.setPayrollCardStatus(PayrollCardStatus.CANCELED);
                                                payrollCard.setError(card.getErrmsg());

                                                payrollCardRepository.update(payrollCard);
                                            }
                                            return cardEntry;
                                        });
                                    }

                                    PayrollRequest payrollRequest = request.get();

                                    payrollRequest.setErrorStatus(PayrollRequestStatus.PROCESSED);

                                    payrollRequestRepository.update(payrollRequest);

                                } catch (JAXBException e) {
                                    Logger.error("XML parsing error", e);
                                } catch (IOException e) {
                                    Logger.error("FTP file reading error", e);
                                }

                            }

                            return request;
                        });


                    } else if (file.getName().contains("SafePayApS_76100G")) {
                        Logger.info("Found success file. Get Date and sequence number from " + file.getName());


                        try {
                            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                            ftpClient.retrieveFile(file.getName(), outputStream);
                            InputStream inputstream = new ByteArrayInputStream(outputStream.toByteArray());

                            JAXBContext jaxbContext = JAXBContext.newInstance(CardCreationResponse.class);

                            CardCreationResponse payrollSuccessResponse = (CardCreationResponse) jaxbContext.createUnmarshaller().unmarshal(inputstream);

                            outputStream.close();
                            inputstream.close();

                            List<RECORD> records = payrollSuccessResponse.getCARDGEN().getPRODUCT().getRECORD();


                            for (RECORD record : records) {


                                F.Promise.wrap(payrollCardRepository.retrieveById(Long.parseLong(record.getUID()))).map(cardEntry -> {
                                    if (cardEntry.isPresent() && cardEntry.get().getPayrollCardStatus() == PayrollCardStatus.REQUESTED) {
                                        PayrollCard payrollCard = cardEntry.get();

                                        if (payrollCard.getPayrollCardType().equals(PayrollCardType.CARD_CREATION)) {

                                            payrollCard.setPubtoken(record.getCARD().getTRACK3());
                                            payrollCard.setExpDate(record.getCARD().getEMBOSSEXPIRY());
                                        }

                                        payrollCard.setPayrollCardStatus(PayrollCardStatus.COMPLETED);

                                        payrollCardRepository.update(payrollCard);

                                        F.Promise<Optional<Customer>> isRegisteredPromise = F.Promise.wrap(customerRepository.retrieveById(payrollCard.getAccno()));

                                        F.Promise<Optional<Country>> countryPromise = F.Promise.wrap(countryRepository.retrieveByCode(payrollCard.getCountry()));

                                        isRegisteredPromise.zip(countryPromise).map(res -> {

                                            Customer customer = new Customer();

                                            boolean isRegistered = true;

                                            if (res._1 != null && res._1.get() != null) {
                                                customer = res._1.get();
                                            } else {
                                                isRegistered = false;
                                            }

                                            Country country = res._2.get();

                                            if (!isRegistered) {


                                                final String password = RandomStringUtils.randomNumeric(4);

                                                customer.setActive(true);
                                                customer.setCountry_id(country.getId());
                                                customer.setKyc(KYC.NONE);
                                                customer.setPassword(SecurityUtil.generateKeyFromArray(password));
                                                customer.setId(payrollCard.getAccno());
                                                customer.setRegistrationDate(new Date());
                                                customer.setDateBirth(new Date());
                                                customer.setTemppassword(true);

                                                smsGateway.sendSMS(payrollCard.getAccno(), "Dear customer! Thank you for registration. Your temporary PIN code is " + password + ". Please visit mysafepay.dk to complete registration.");

                                                F.Promise.wrap(customerRepository.create(customer));
                                            }

                                            F.Promise.wrap(cardRepository.create(new model.Card(0L, payrollCard.getPubtoken(), customer.getId(),
                                                    CardType.VIRTUAL, CardBrand.VISA, true, new Date(), "alias", true, "info", payrollCard.getCurrency(),
                                                    payrollCard.getAddrl1(), payrollCard.getAddrl2(), payrollCard.getAddrl3(), payrollCard.getCountry())));



                                            return true;
                                        });
                                    }
                                    return cardEntry;
                                });
                            }

                        } catch (JAXBException e) {
                            Logger.error("XML parsing error", e);
                        } catch (IOException e) {
                            Logger.error("FTP file reading error", e);
                        }


                    }


                }

            } catch (Exception e) {
                Logger.error("Error: " + e.getMessage(), e);
            } finally {
                try {
                    if (ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                } catch (IOException e) {
                    Logger.error("Error: " + e.getMessage(), e);
                }
            }

            return ftpSettings;
        });

    }
}