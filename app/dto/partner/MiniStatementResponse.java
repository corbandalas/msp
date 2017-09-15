package dto.partner;

import ae.globalprocessing.hyperionweb.BalanceEnquire2;
import ae.globalprocessing.hyperionweb.CardStatement2;
import dto.BaseAPIResponse;

/**
 * Mini Statement response DTO object
 *
 * @author corbandalas created 15.09.2017.
 * @since 0.6.0
 */

public class MiniStatementResponse extends BaseAPIResponse {

    private CardStatement2 cardStatement;

    public MiniStatementResponse(String text, String code, CardStatement2 cardStatement) {
        super(text, code);
        this.cardStatement = cardStatement;
    }

    public CardStatement2 getCardStatement() {
        return cardStatement;
    }

    public void setCardStatement(CardStatement2 cardStatement) {
        this.cardStatement = cardStatement;
    }
}
