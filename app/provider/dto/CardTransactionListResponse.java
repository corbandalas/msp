package provider.dto;

import ae.globalprocessing.hyperionweb.Transaction2;

import java.util.List;

/**
 * Card transaction list response
 *
 * @author corbandalas - created 15.02.2016
 * @since 0.1.0
 */
public class CardTransactionListResponse extends BaseCardResponse {

    private List<Transaction2> list;

    public CardTransactionListResponse(String actionCode) {
        super(actionCode);
    }


    public CardTransactionListResponse(String actionCode, List<Transaction2> list) {
        super(actionCode);
        this.list = list;
    }

    public List<Transaction2> getList() {
        return list;
    }

    public void setList(List<Transaction2> list) {
        this.list = list;
    }
}
