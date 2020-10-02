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
 *
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

            return getExchangeRates(currency, cardAccount, transferAccount, sourceCard, destinationCard).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.TRANSFER, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> sourceTransactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                cardAccount.getId(), transferAccount.getId(), sourceCard.getId(), null, rates._1._1, rates._1._2, rates._2._1, null, TransactionType.TRANSFER_FROM)));
                                final F.Promise<Transaction> destinationTransactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                transferAccount.getId(), cardAccount.getId(), null, destinationCard.getId(), rates._1._2, rates._1._1, null, rates._2._2, TransactionType.TRANSFER_TO)));

                                return F.Promise.sequence(sourceTransactionPromise, destinationTransactionPromise).map(trans -> new F.Tuple<>(operation, trans));
                            }));
        });
    }

    public F.Promise<F.Tuple<Operation, List<Transaction>>> createAccomplishTransferOperation(Card sourceCard, Card destinationCard, Long amount, Currency currency, String orderId, String description, Account account) {

            return getExchangeRates(currency, account, account, sourceCard, destinationCard).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.TRANSFER, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> sourceTransactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                account.getId(), account.getId(), sourceCard.getId(), null, rates._1._1, rates._1._2, rates._2._1, null, TransactionType.TRANSFER_FROM, new Date(), orderId)));
                                final F.Promise<Transaction> destinationTransactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                account.getId(), account.getId(), null, destinationCard.getId(), rates._1._2, rates._1._1, null, rates._2._2, TransactionType.TRANSFER_TO, new Date(), orderId)));

                                return F.Promise.sequence(sourceTransactionPromise, destinationTransactionPromise).map(trans -> new F.Tuple<>(operation, trans));
                            }));
    }

    public F.Promise<F.Tuple<Operation, Transaction>> createDepositOperation(Card card, Long amount, Currency currency, String orderId, String description) {
        final F.Promise<Optional<Account>> cardAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.card"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));
        final F.Promise<Optional<Account>> depositAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.deposit"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));

        return cardAccountPromise.zip(depositAccountPromise).flatMap(accounts -> {
            final Account cardAccount = accounts._1.orElseThrow(WrongAccountException::new);
            final Account depositAccount = accounts._2.orElseThrow(WrongAccountException::new);

            return getExchangeRates(currency, depositAccount, cardAccount, null, card).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.DEPOSIT, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> transactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                depositAccount.getId(), cardAccount.getId(), null, card.getId(), rates._1._1, rates._1._2, null, rates._2._2, TransactionType.DEPOSIT)));

                                return transactionPromise.map(trans -> new F.Tuple<>(operation, trans));
                            }));
        });
    }

    public F.Promise<F.Tuple<Operation, Transaction>> createAccomplishDepositOperation(Card card, Long amount, Currency currency, String orderId, String description, Account account) {
//        final F.Promise<Optional<Account>> cardAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.card"))
//                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));
        final F.Promise<Optional<Account>> depositAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.deposit"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));

        return depositAccountPromise.flatMap(accounts -> {
            final Account depositAccount = accounts.orElseThrow(WrongAccountException::new);

            return getExchangeRates(currency, depositAccount, account, null, card).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.DEPOSIT, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> transactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                depositAccount.getId(), account.getId(), null, card.getId(), rates._1._1, rates._1._2, null, rates._2._2, TransactionType.DEPOSIT, new Date(), orderId)));

                                return transactionPromise.map(trans -> new F.Tuple<>(operation, trans));
                            }));
        });
    }

    public F.Promise<F.Tuple<Operation, Transaction>> createWithdrawOperation(Card card, Long amount, Currency currency, String orderId, String description) {
        final F.Promise<Optional<Account>> cardAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.card"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));
        final F.Promise<Optional<Account>> withdrawAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.withdraw"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));

        return cardAccountPromise.zip(withdrawAccountPromise).flatMap(accounts -> {
            final Account cardAccount = accounts._1.orElseThrow(WrongAccountException::new);
            final Account withdrawAccount = accounts._2.orElseThrow(WrongAccountException::new);

            return getExchangeRates(currency, cardAccount, withdrawAccount, card, null).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.WITHDRAW, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> transactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                cardAccount.getId(), withdrawAccount.getId(), card.getId(), null,  rates._1._1, rates._1._2, rates._2._1, null, TransactionType.WITHDRAW)));

                                return transactionPromise.map(trans -> new F.Tuple<>(operation, trans));
                            }));
        });
    }

    public F.Promise<F.Tuple<Operation, Transaction>> createAccomplishWithdrawOperation(Card card, Long amount, Currency currency, String orderId, String description, Account account) {
//        final F.Promise<Optional<Account>> cardAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.card"))
//                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));
        final F.Promise<Optional<Account>> withdrawAccountPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.accounts.withdraw"))
                .flatMap(prop -> F.Promise.wrap(accountRepository.retrieveById(prop.orElseThrow(WrongPropertyException::new).getValue())));

        return withdrawAccountPromise.flatMap(accounts -> {
//            final Account cardAccount = accounts._1.orElseThrow(WrongAccountException::new);
            final Account withdrawAccount = accounts.orElseThrow(WrongAccountException::new);

            return getExchangeRates(currency, account, withdrawAccount, card, null).flatMap(rates ->
                    F.Promise.wrap(operationRepository.create(new Operation(null, OperationType.WITHDRAW, orderId, description, new Date())))
                            .flatMap(operation -> {
                                final F.Promise<Transaction> transactionPromise = F.Promise
                                        .wrap(transactionRepository.create(new Transaction(null, operation.getId(), amount, currency.getId(),
                                                account.getId(), withdrawAccount.getId(), card.getId(), null,  rates._1._1, rates._1._2, rates._2._1, null, TransactionType.WITHDRAW, new Date(), orderId)));

                                return transactionPromise.map(trans -> new F.Tuple<>(operation, trans));
                            }));
        });
    }

    public F.Promise<Double> getDepositSumByCard(Card card) {
        return F.Promise.wrap(transactionRepository.retrieveSumByToCardId(card.getId())).map(sum -> (sum != null) ? sum : Double.valueOf(0));
    }

    private F.Promise<F.Tuple<F.Tuple<Double, Double>, F.Tuple<Double, Double>>> getExchangeRates(Currency currency, Account fromAccount, Account toAccount,
                                                                                                  Card fromCard, Card toCard) {
        final F.Promise<Double> fromAccountExchangeRatePromise;
        if (fromAccount.getCurrencyId().equals(currency.getId()))
            fromAccountExchangeRatePromise = F.Promise.pure(1.0);
        else {
            fromAccountExchangeRatePromise = F.Promise.wrap(currencyRepository.retrieveById(fromAccount.getCurrencyId())).map(accCurrency ->
                    CurrencyUtil.getExchangeRate(currency, accCurrency.orElseThrow(WrongCurrencyException::new)).doubleValue());
        }

        final F.Promise<Double> toAccountExchangeRatePromise;
        if (toAccount.getCurrencyId().equals(currency.getId()))
            toAccountExchangeRatePromise = F.Promise.pure(1.0);
        else {
            toAccountExchangeRatePromise = F.Promise.wrap(currencyRepository.retrieveById(toAccount.getCurrencyId())).map(accCurrency ->
                    CurrencyUtil.getExchangeRate(currency, accCurrency.orElseThrow(WrongCurrencyException::new)).doubleValue());
        }

        final F.Promise<Double> fromCardExchangeRatePromise;
        if (fromCard != null)
            if (fromCard.getCurrencyId().equals(currency.getId()))
                fromCardExchangeRatePromise = F.Promise.pure(1.0);
            else
                fromCardExchangeRatePromise = F.Promise.wrap(currencyRepository.retrieveById(fromCard.getCurrencyId())).map(cardCurrency ->
                        CurrencyUtil.getExchangeRate(currency, cardCurrency.orElseThrow(WrongCurrencyException::new)).doubleValue());
        else
            fromCardExchangeRatePromise = F.Promise.pure(null);

        final F.Promise<Double> toCardExchangeRatePromise;
        if (toCard != null)
            if (toCard.getCurrencyId().equals(currency.getId()))
                toCardExchangeRatePromise = F.Promise.pure(1.0);
            else
                toCardExchangeRatePromise = F.Promise.wrap(currencyRepository.retrieveById(toCard.getCurrencyId())).map(cardCurrency ->
                        CurrencyUtil.getExchangeRate(currency, cardCurrency.orElseThrow(WrongCurrencyException::new)).doubleValue());
        else
            toCardExchangeRatePromise = F.Promise.pure(null);

        return fromAccountExchangeRatePromise.zip(toAccountExchangeRatePromise).zip(fromCardExchangeRatePromise.zip(toCardExchangeRatePromise));
    }
}
