package dto.partner;

import ae.globalprocessing.hyperionweb.BalanceTransfer;
import ae.globalprocessing.hyperionweb.ChangeGroup;
import dto.BaseAPIResponse;

/**
 * Card balance transfer response DTO object
 *
 * @author corbandalas created 04.04.2018.
 * @since 0.6.0
 */

public class CardBalanceTransferResponse extends BaseAPIResponse {

    private BalanceTransfer balanceTransfer;

    public CardBalanceTransferResponse(String text, String code, BalanceTransfer balanceTransfer) {
        super(text, code);
        this.balanceTransfer = balanceTransfer;
    }

    public BalanceTransfer getBalanceTransfer() {
        return balanceTransfer;
    }

    public void setBalanceTransfer(BalanceTransfer balanceTransfer) {
        this.balanceTransfer = balanceTransfer;
    }
}
