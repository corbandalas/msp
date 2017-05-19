package dto.customer;

import dto.BaseAPIResponse;
import model.FeeInterval;

import java.util.List;

/**
 * API obtain operation fee DTO response
 *
 * @author corbandalas created 19.05.2017.
 * @since 0.4.0
 */
public class ObtainFeeResponse extends BaseAPIResponse {
    private List<FeeInterval> feeIntervalList;
    private Long totalAmount;

    public ObtainFeeResponse(String text, String code, Long totalAmount, List<FeeInterval> feeIntervalList) {
        super(text, code);
        this.totalAmount = totalAmount;
        this.feeIntervalList = feeIntervalList;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<FeeInterval> getFeeIntervalList() {
        return feeIntervalList;
    }

    public void setFeeIntervalList(List<FeeInterval> feeIntervalList) {
        this.feeIntervalList = feeIntervalList;
    }
}
