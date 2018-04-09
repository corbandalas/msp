package dto.partner;

import ae.globalprocessing.hyperionweb.ApplyFees;
import dto.BaseAPIResponse;

/**
 * Apply fee response DTO object
 *
 * @author corbandalas created 04.04.2018.
 * @since 0.6.0
 */
public class ApplyCardFeeResponse  extends BaseAPIResponse {

    private ApplyFees applyFees;

    public ApplyCardFeeResponse(String text, String code, ApplyFees applyFees) {
        super(text, code);
        this.applyFees = applyFees;
    }

    public ApplyFees getApplyFees() {
        return applyFees;
    }

    public void setApplyFees(ApplyFees applyFees) {
        this.applyFees = applyFees;
    }
}


