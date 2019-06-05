package dto.partner;

import ae.globalprocessing.hyperionweb.ExtendExpiry;
import ae.globalprocessing.hyperionweb.Regenerate;
import dto.BaseAPIResponse;

/**
 * Extend exp date response DTO object
 *
 * @author corbandalas created 20.03.2019.
 * @since 0.6.0
 */

public class ExtendExpDateResponse extends BaseAPIResponse {

    private ExtendExpiry extendExpiry;
    private Regenerate regenerate;

    public ExtendExpDateResponse(String text, String code, ExtendExpiry extendExpiry, Regenerate regenerate) {
        super(text, code);
        this.extendExpiry = extendExpiry;
        this.regenerate = regenerate;
    }

    public ExtendExpiry getExtendExpiry() {
        return extendExpiry;
    }

    public void setExtendExpiry(ExtendExpiry extendExpiry) {
        this.extendExpiry = extendExpiry;
    }

    public Regenerate getRegenerate() {
        return regenerate;
    }

    public void setRegenerate(Regenerate regenerate) {
        this.regenerate = regenerate;
    }
}
