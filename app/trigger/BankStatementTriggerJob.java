package trigger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import play.Logger;
import play.libs.F;
import repository.CustomerRepository;
import services.MailService;


/**
 * Bank statement trigger job
 *
 * @author corbandalas - created 19.09.2018
 * @since 0.7.0
 */

@Singleton
public class BankStatementTriggerJob implements Runnable {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private MailService mailService;

    @Override
    public void run() {

        Logger.info("////////////////////////////// BankStatementTriggerJob WORKS!!!!");


        F.Promise.wrap(customerRepository.retrieveAll()).map(res -> {
            res.parallelStream().forEach(customer -> mailService.sendBankStatementEmail("", customer.getEmail(), customer.getCountry_id(), customer.getFirstName() + " " + customer.getLastName()));

            return F.Promise.pure("OK");
        });
    }

}
