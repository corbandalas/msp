package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import model.enums.OperationType;

import javax.annotation.concurrent.Immutable;

/**
 * Database stored entity for managing fees across the project
 *
 * @author corbandalas - created 08.05.2017
 * @since 0.4.0
 */

@Immutable
@JsonDeserialize
public class Fee extends BaseEntity<Long> {

    public final Long startAmountRange;
    public final Long endAmountRange;
    public final OperationType operationType;
    public final String currencyId;
    public final Integer accountId;

    @JsonCreator
    public Fee(@JsonProperty("id") Long id, @JsonProperty("startAmountRange") Long startAmountRange, @JsonProperty("endAmountRange") Long endAmountRange, @JsonProperty("currencyId") String currencyId, @JsonProperty("accountId") Integer accountId, @JsonProperty("operationType") OperationType operationType) {
        this.setId(id);
        this.startAmountRange = startAmountRange;
        this.endAmountRange = endAmountRange;
        this.currencyId = currencyId;
        this.operationType = operationType;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "startAmountRange=" + startAmountRange +
                ", endAmountRange=" + endAmountRange +
                ", currencyId=" + currencyId +
                ", accountId=" + accountId +
                ", operationType=" + operationType +
                '}';
    }
}
