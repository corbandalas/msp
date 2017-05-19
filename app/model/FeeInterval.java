package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.enums.FeeDestinationType;
import model.enums.FeeIntervalType;

import javax.annotation.concurrent.Immutable;

/**
 * Database stored entity for managing fee intervals across the project
 *
 * @author corbandalas - created 08.05.2017
 * @since 0.4.0
 */

@Immutable
@JsonDeserialize
public class FeeInterval extends BaseEntity<Long> {

    public final Long feeId;
    public final FeeIntervalType feeIntervalType;
    public final FeeDestinationType feeDestinationType;
    public Long amount;
    public Long percent;
    public final Integer accountId;

    @JsonCreator
    public FeeInterval(@JsonProperty("id") Long id, @JsonProperty("feeId") Long feeId, @JsonProperty("amount") Long amount, @JsonProperty("percent") Long percent, @JsonProperty("accountId") Integer accountId, @JsonProperty("feeIntervalType") FeeIntervalType feeIntervalType, @JsonProperty("feeDestinationType") FeeDestinationType feeDestinationType) {
        this.setId(id);
        this.feeId = feeId;
        this.amount = amount;
        this.accountId = accountId;
        this.percent = percent;
        this.feeIntervalType = feeIntervalType;
        this.feeDestinationType = feeDestinationType;
    }

    @Override
    public String toString() {
        return "FeeInterval{" +
                "feeId=" + feeId +
                ", amount=" + amount +
                ", accountId=" + accountId +
                ", percent=" + percent +
                ", feeIntervalType=" + feeIntervalType +
                ", feeDestinationType=" + feeDestinationType +
                '}';
    }
}
