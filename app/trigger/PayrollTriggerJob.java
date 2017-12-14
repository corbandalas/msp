package trigger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.payroll.Card;
import dto.payroll.PayrollErrorResponseBean;
import model.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import play.Logger;
import play.libs.F;
import repository.CurrencyRepository;
import repository.PayrollCardRepository;
import repository.PayrollRequestRepository;
import repository.PropertyRepository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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


                    }


                }

            } catch (Exception e) {
                Logger.error("Error: " + e.getMessage(), e);
            }

            finally {
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