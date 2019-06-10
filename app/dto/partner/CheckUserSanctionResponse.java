package dto.partner;

import dto.BaseAPIResponse;

/**
 * Response object for check user sanction
 *
 * @author corbandalas created 07.06.2019.
 * @since 1.0.0
 */
public class CheckUserSanctionResponse extends BaseAPIResponse {

    private String result;

    public CheckUserSanctionResponse(String text, String code, String result) {
        super(text, code);

        this.result = result;

    }

}