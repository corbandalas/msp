package dto;

import model.Property;

import java.util.List;

/**
 * Property List API response
 *
 * @author corbandalas - created 02.02.2016
 * @since 0.1.0
 *
 */
public class PropertyListResponse extends BaseAPIResponse{

    private List<Property> propertyList;

    public PropertyListResponse(String text, String code, List<Property> list) {
        super(text, code);
        propertyList = list;
    }

    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

}
