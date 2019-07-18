package dto.partner;

import dto.BaseAPIResponse;

/**
 * Regenerate response DTO object
 *
 * @author corbandalas created 19.07.2019.
 * @since 0.6.0
 */

public class RegenerateResponse extends BaseAPIResponse {

    private Regenerate regenerate;

    public RegenerateResponse(String text, String code, Regenerate regenerate) {
        super(text, code);
        this.regenerate = regenerate;
    }

    public Regenerate getRegenerate() {
        return regenerate;
    }

    public void setRegenerate(Regenerate regenerate) {
        this.regenerate = regenerate;
    }
}
