package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.swaggerui;

/**
 * Swagger UI Play controller
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 *
 */


public class SwaggerController extends Controller {

    public Result swagger() {
        return ok(swaggerui.render());
    }
}