package util;


import model.FeeInterval;
import model.enums.FeeDestinationType;
import model.enums.FeeIntervalType;
import model.enums.OperationType;
import play.libs.F;
import repository.FeeIntervalRepository;
import repository.FeeRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to calculate transaction fees
 *
 * @author corbandalas - created 11.05.2017
 * @since 0.4.0
 */
public class FeeUtil {


    public static F.Promise<Long> getTotalSumWithFee(Integer accountID, Long amount, String currency, OperationType operationType, FeeDestinationType feeDestinationType, FeeRepository feeRepository, FeeIntervalRepository feeIntervalRepository) {


        return F.Promise.wrap(feeRepository.retrieveAppropriateFee(accountID, operationType, amount, currency)).flatMap(res -> {
            if (res.isPresent()) {
                return F.Promise.wrap(feeIntervalRepository.retrieveByFeeIdAndType(res.get().getId(), feeDestinationType)).map(feeIntervals -> {

                    long totalSum = amount;

                    for (FeeInterval feeInterval : feeIntervals) {
                        if (feeInterval.amount != null) {
                            if (feeInterval.feeIntervalType.equals(FeeIntervalType.SURCHARGE_FEE)) {
                                totalSum += feeInterval.amount;
                            } else {
                                totalSum -= feeInterval.amount;
                            }
                        } else {
                            if (feeInterval.percent != null) {
                                if (feeInterval.feeIntervalType.equals(FeeIntervalType.SURCHARGE_FEE)) {
                                    totalSum += feeInterval.percent * amount / 10000;
                                } else {
                                    totalSum -= feeInterval.percent * amount / 10000;
                                }
                            }
                        }
                    }

                    return totalSum;
                });
            } else {
                return F.Promise.pure(amount);
            }
        });

    }


    public static F.Promise<List<FeeInterval>> getFees(Integer accountID, Long amount, String currency, OperationType operationType, FeeDestinationType feeDestinationType, FeeRepository feeRepository, FeeIntervalRepository feeIntervalRepository) {

        return F.Promise.wrap(feeRepository.retrieveAppropriateFee(accountID, operationType, amount, currency)).flatMap(res -> {
            if (res.isPresent()) {
                return F.Promise.wrap(feeIntervalRepository.retrieveByFeeIdAndType(res.get().getId(), feeDestinationType));
            } else {
                return F.Promise.pure(new ArrayList<>());
            }
        });

    }
}
