package util;

import model.Currency;

import java.math.BigDecimal;

/**
 * Helper class to convert currencies
 *
 * @author corbandalas - created 11.02.2016
 * @since 0.1.0
 */
public class CurrencyUtil {

    private static int SCALE = 15;

    public static Long convert(Long amount, Currency currencyFrom, Currency currencyTo) {
        BigDecimal euroIndexFrom = currencyFrom.getEuroIndex();
        BigDecimal euroIndexTo = currencyTo.getEuroIndex();

        BigDecimal exchangeRate = euroIndexTo.divide(euroIndexFrom, SCALE, BigDecimal.ROUND_DOWN);

        final double tmp = Math.ceil(exchangeRate.multiply(
                new BigDecimal(amount)).doubleValue());

        return new Long(new Double(tmp).intValue());

    }

}
