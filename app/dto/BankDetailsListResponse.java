package dto;

import com.envoyservices.merchantapi.BankDetailsResultV2;

import java.util.List;

/**
 * WorldPay bank details account list DTO response
 *
 * @author corbandalas created 18.05.2016.
 * @since 0.2.0
 */
public class BankDetailsListResponse extends BaseAPIResponse {


    private List<BankDetailsResultV2> bankDetailsResultV2;

    public BankDetailsListResponse() {
        super("", "");
    }

    public BankDetailsListResponse(String text, String code, List<BankDetailsResultV2> bankDetailsResultV2) {
        super(text, code);
        this.bankDetailsResultV2 = bankDetailsResultV2;
    }

    public List<BankDetailsResultV2> getBankDetailsResultV2() {
        return bankDetailsResultV2;
    }

    public void setBankDetailsResultV2(List<BankDetailsResultV2> bankDetailsResultV2) {
        this.bankDetailsResultV2 = bankDetailsResultV2;
    }
}
