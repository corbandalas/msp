package dto.partner;

import ae.globalprocessing.hyperionweb.BalanceAdjust;
import dto.BaseAPIResponse;

/**
 * Card Balance adjustment response DTO object
 *
 * @author corbandalas created 24.08.2018.
 * @since 0.6.0
 */

public class BalanceAdjustmentResponse extends BaseAPIResponse {

    private BalanceAdjust balanceAdjust;

    public BalanceAdjustmentResponse(String text, String code, BalanceAdjust balanceAdjust) {
        super(text, code);
        this.balanceAdjust = balanceAdjust;
    }

    public BalanceAdjust getBalanceAdjust() {
        return balanceAdjust;
    }

    public void setBalanceAdjust(BalanceAdjust balanceAdjust) {
        this.balanceAdjust = balanceAdjust;
    }
}
