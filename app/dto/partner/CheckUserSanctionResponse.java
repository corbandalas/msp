package dto.partner;

import dto.BaseAPIResponse;

/**
 * Response object for check user sanction
 *
 * @author corbandalas created 07.06.2019.
 * @since 1.0.0
 */
public class CheckUserSanctionResponse extends BaseAPIResponse {

    private String matchScore;
    private boolean match;

    public CheckUserSanctionResponse(String text, String code, String matchScore, boolean match) {
        super(text, code);
        this.matchScore = matchScore;
        this.match = match;
    }

    public String getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(String matchScore) {
        this.matchScore = matchScore;
    }

    public boolean getMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }
}