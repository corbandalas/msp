package model;


import java.util.Date;

/**
 * Database stored entity for managing payroll request sequence
 *
 * @author corbandalas - created 26.11.2017
 * @since 0.7.0
 */

public class PayrollSequence extends BaseEntity<Long> {

    private Date lastDate;
    private long currentValue;


    public PayrollSequence(Date lastDate, long currentValue) {
        this.lastDate = lastDate;
        this.currentValue = currentValue;
    }


    public PayrollSequence() {
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public long getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(long currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return "PayrollSequence{" +
                "lastDate=" + lastDate +
                ", currentValue=" + currentValue +
                '}';
    }
}
