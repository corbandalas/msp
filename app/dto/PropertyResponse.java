package dto;

import model.Property;

import java.util.List;

/**
 * Property API response
 *
 * @author corbandalas - created 03.02.2016
 * @since 0.1.0
 *
 */
public class PropertyResponse extends BaseAPIResponse{

    private Property property;

    public PropertyResponse(String text, String code, Property property) {
        super(text, code);
        this.property = property;
    }


    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
