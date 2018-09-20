package services;

import com.google.inject.Inject;
import model.Account;
import model.Card;
import model.Currency;
import play.Logger;
import play.libs.F;
import repository.AccountRepository;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.TransactionRepository;

import java.util.Optional;

/**
 * Payroll Service
 *
 * @author corbandalas created 11.09.2018.
 * @since 0.5.0
 */
public class PayrollService {

    @Inject
    TransactionRepository transactionRepository;

    @Inject
    AccountRepository accountRepository;

    @Inject
    CardRepository cardRepository;

    @Inject
    CurrencyRepository currencyRepository;

    public F.Promise<F.Tuple<Double, Currency>> getPayrollAccountBalance(int accountID) {

        F.Promise<Optional<Account>> accountPromise = F.Promise.wrap(accountRepository.retrieveById(accountID));

        return accountPromise.flatMap(account -> {

            F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(cardRepository.retrieveById(account.get().getCardId())).flatMap(c -> F.Promise.wrap(currencyRepository.retrieveById(c.get().getCurrencyId())));

            F.Promise<Double> totalSumFromCard = F.Promise.wrap(transactionRepository.retrieveSumByFromCardId(account.get().getCardId()));
            F.Promise<Double> totalSumToCard = F.Promise.wrap(transactionRepository.retrieveSumByToCardId(account.get().getCardId()));

            return currencyPromise.zip(totalSumFromCard.zip(totalSumToCard)).map(res -> {


                Double totalSumFrom = res._2._1;
                Double totalSumTo = res._2._2;
                Logger.error("Total sum from: " + totalSumFrom);
                Logger.error("Total sum to: " + totalSumTo);

                return new F.Tuple(totalSumTo - totalSumFrom, res._1.get());
            });

        });

    }

}
