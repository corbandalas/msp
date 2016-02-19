package util;

import exception.WrongCurrencyException;
import model.Currency;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Helper class to convert currencies
 *
 * @author corbandalas - created 11.02.2016
 * @since 0.1.0
 */
public class CurrencyUtil {

    private static int SCALE = 15;

    public static Long convert(Long amount, Optional<Currency> currencyFromOptional, Optional<Currency> currencyToOptional) throws WrongCurrencyException {

        Currency currencyFrom = currencyFromOptional.orElseThrow(WrongCurrencyException::new);
        Currency currencyTo = currencyToOptional.orElseThrow(WrongCurrencyException::new);

        BigDecimal exchangeRate = getExchangeRate(currencyFrom, currencyTo);

        final double tmp = Math.ceil(exchangeRate.multiply(
                new BigDecimal(amount)).doubleValue());

        return new Long(new Double(tmp).intValue());

    }

    public static BigDecimal getExchangeRate(Currency currencyFrom, Currency currencyTo) {
        BigDecimal euroIndexFrom = currencyFrom.getEuroIndex();
        BigDecimal euroIndexTo = currencyTo.getEuroIndex();

        return euroIndexTo.divide(euroIndexFrom, SCALE, BigDecimal.ROUND_DOWN);
    }


}
