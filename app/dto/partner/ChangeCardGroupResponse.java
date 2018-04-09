package dto.partner;

import ae.globalprocessing.hyperionweb.ChangeGroup;
import dto.BaseAPIResponse;

/**
 * Change Card Group response DTO object
 *
 * @author corbandalas created 04.04.2018.
 * @since 0.6.0
 */

public class ChangeCardGroupResponse extends BaseAPIResponse {

    private ChangeGroup changeGroup;

    public ChangeCardGroupResponse(String text, String code, ChangeGroup changeGroup) {
        super(text, code);
        this.changeGroup = changeGroup;
    }

    public ChangeGroup getChangeGroup() {
        return changeGroup;
    }

    public void setChangeGroup(ChangeGroup changeGroup) {
        this.changeGroup = changeGroup;
    }
}
