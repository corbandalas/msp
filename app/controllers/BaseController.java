package controllers;

import dto.BaseAPIResponse;
import dto.PropertyListResponse;
import dto.PropertyResponse;
import model.Property;

import java.util.List;

/**
 * Base Play controller
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 *
 */

public class BaseController extends play.mvc.Controller {

    protected BaseAPIResponse createResponse(String code, String text) {
        return new BaseAPIResponse(text, code);
    }

    protected PropertyListResponse createResponse(String code, String text, List<Property> propertyList)  {
        return new PropertyListResponse(text, code, propertyList);
    }

    protected PropertyResponse createResponse(String code, String text, Property property)  {
        return new PropertyResponse(text, code, property);
    }
}
