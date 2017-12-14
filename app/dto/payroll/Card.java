package dto.payroll;


/**
 * Response Card Bean for managing payroll error response
 *
 * @author corbandalas - created 07.12.2017
 * @since 0.7.0
 */

public class Card {

    private String recid;
    private String pan;
    private String pubtoken;
    private String accno;
    private String action;
    private String errmsg;

    public Card() {
    }

    public Card(String recid, String pan, String pubtoken, String accno, String action, String errmsg) {
        this.recid = recid;
        this.pan = pan;
        this.pubtoken = pubtoken;
        this.accno = accno;
        this.action = action;
        this.errmsg = errmsg;
    }

    public String getRecid() {
        return recid;
    }

    public void setRecid(String recid) {
        this.recid = recid;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPubtoken() {
        return pubtoken;
    }

    public void setPubtoken(String pubtoken) {
        this.pubtoken = pubtoken;
    }

    public String getAccno() {
        return accno;
    }

    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "Card{" +
                "recid='" + recid + '\'' +
                ", pan='" + pan + '\'' +
                ", pubtoken='" + pubtoken + '\'' +
                ", accno='" + accno + '\'' +
                ", action='" + action + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
