package dto.payroll;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Response Bean for managing payroll error response
 *
 * @author corbandalas - created 05.12.2017
 * @since 0.7.0
 */

@XmlRootElement(name = "CRDEXCEPTION")
public class PayrollErrorResponseBean {

    private List<Card> card;

    public PayrollErrorResponseBean(List<Card> card) {
        this.card = card;
    }

    public PayrollErrorResponseBean() {
    }

    public List<Card> getCard() {
        return card;
    }

    public void setCard(List<Card> card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "PayrollErrorResponseBean{" +
                "card=" + card +
                '}';
    }
}
