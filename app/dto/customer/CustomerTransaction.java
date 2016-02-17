package dto.customer;

import ae.globalprocessing.hyperionweb.Transaction2;
import org.springframework.beans.BeanUtils;

/**
 * API customer transaction object
 * @author ra created 17.02.2016.
 * @since 0.2.0
 */
public class CustomerTransaction {
    private String txnDate;
    private String postDate;
    private double amtBill;
    private double amtTxn;
    private int debOrCred;
    private String description;
    private String curTxn;
    private int itemId;
    private double avlBal;
    private double blkAmt;
    private String transactionType;
    private String statusCode;
    private String statusDesc;
    private String txnTime;
    private String locDate;
    private long wsid;

    public CustomerTransaction(Transaction2 transaction2) {
        BeanUtils.copyProperties(transaction2,this);
    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public double getAmtBill() {
        return amtBill;
    }

    public void setAmtBill(double amtBill) {
        this.amtBill = amtBill;
    }

    public double getAmtTxn() {
        return amtTxn;
    }

    public void setAmtTxn(double amtTxn) {
        this.amtTxn = amtTxn;
    }

    public int getDebOrCred() {
        return debOrCred;
    }

    public void setDebOrCred(int debOrCred) {
        this.debOrCred = debOrCred;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurTxn() {
        return curTxn;
    }

    public void setCurTxn(String curTxn) {
        this.curTxn = curTxn;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getAvlBal() {
        return avlBal;
    }

    public void setAvlBal(double avlBal) {
        this.avlBal = avlBal;
    }

    public double getBlkAmt() {
        return blkAmt;
    }

    public void setBlkAmt(double blkAmt) {
        this.blkAmt = blkAmt;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(String txnTime) {
        this.txnTime = txnTime;
    }

    public String getLocDate() {
        return locDate;
    }

    public void setLocDate(String locDate) {
        this.locDate = locDate;
    }

    public long getWsid() {
        return wsid;
    }

    public void setWsid(long wsid) {
        this.wsid = wsid;
    }
}
