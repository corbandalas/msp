package services;

import com.google.inject.Inject;
import exception.WrongAccountException;
import exception.WrongCurrencyException;
import exception.WrongPropertyException;
import model.*;
import model.enums.OperationType;
import model.enums.TransactionType;
import play.libs.F;
import repository.*;
import util.CurrencyUtil;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Operation serviice
 * @author ra created 24.05.2016.
 * @since 0.3.0
 */
public class OperationService {

    @Inject
    AccountRepository accountRepository;

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    private PropertyRepository propertyRepository;

    @Inject
    TransactionRepository transactionRepository;

    @Inject
    OperationRepository operationRepository;

    public F.Promise<F.Tuple<Operation, List<Transaction>>> createTransferOperation(Card sourceCard, Card destinationCard, Long amount, Currency currency, String orderId, String description) {
        final F.Promise<Optional<Account>> cardAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.card"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));
        final F.Promise<Optional<Account>> transferAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.transfer"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));

        return cardAccountPromise.zip(transferAccountPromise).flatMap(accounts -> {
            final Account cardAccount = accounts._1.orElseThrow(WrongAccountException::new);
            final Account transferAccount = accounts._2.orElseThrow(WrongAccountException::new);

            return getExchangeRates(currency, cardAccount, transferAccount).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.TRANSFER, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> sourceTransactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                cardAccount.getId(), transferAccount.getId(), sourceCard.getId(), rates._1, rates._2, TransactionType.TRANSFER_FROM)));
                                final F.Promise<Transaction> destinationTransactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                transferAccount.getId(), cardAccount.getId(), destinationCard.getId(), rates._2, rates._1, TransactionType.TRANSFER_FROM)));

                                return F.Promise.sequence(sourceTransactionPromise, destinationTransactionPromise).map(trans -> new F.Tuple<>(operation, trans));
                            }));
        });
    }

    public F.Promise<F.Tuple<Operation, Transaction>> createDepositOperation(Card card, Long amount, Currency currency, String orderId, String description) {
        final F.Promise<Optional<Account>> cardAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.card"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));
        final F.Promise<Optional<Account>> depositAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.deposit"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));

        return cardAccountPromise.zip(depositAccountPromise).flatMap(accounts -> {
            final Account cardAccount = accounts._1.orElseThrow(WrongAccountException::new);
            final Account depositAccount = accounts._2.orElseThrow(WrongAccountException::new);

            return getExchangeRates(currency, cardAccount, depositAccount).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.DEPOSIT, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> transactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                cardAccount.getId(), depositAccount.getId(), card.getId(), rates._1, rates._2, TransactionType.TRANSFER_FROM)));

                                return transactionPromise.map(trans -> new F.Tuple<>(operation, trans));
                            }));
        });
    }

    private F.Promise<F.Tuple<Double, Double>> getExchangeRates(Currency currency, Account fromAccount, Account toAccount) {
        final F.Promise<Double> cardAccountExchangeRatePromise;
        if (fromAccount.getCurrencyId().equals(currency.getId()))
            cardAccountExchangeRatePromise = F.Promise.pure(1.0);
        else {
            cardAccountExchangeRatePromise = F.Promise.wrap(currencyRepository.retrieveById(fromAccount.getCurrencyId())).map(accCurrency ->
                    CurrencyUtil.getExchangeRate(currency, accCurrency.orElseThrow(WrongCurrencyException::new)).doubleValue());
        }

        final F.Promise<Double> transferAccountExchangeRatePromise;
        if (toAccount.getCurrencyId().equals(currency.getId()))
            transferAccountExchangeRatePromise = F.Promise.pure(1.0);
        else {
            transferAccountExchangeRatePromise = F.Promise.wrap(currencyRepository.retrieveById(toAccount.getCurrencyId())).map(accCurrency ->
                    CurrencyUtil.getExchangeRate(currency, accCurrency.orElseThrow(WrongCurrencyException::new)).doubleValue());
        }

        return cardAccountExchangeRatePromise.zip(transferAccountExchangeRatePromise);
    }
}
