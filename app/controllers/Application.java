package controllers;


import play.mvc.Result;
import views.html.*;

/**
 * Index Play controller
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 *
 */
public class Application extends BaseController {

    public  Result index() {
        return ok(index.render("Your new application is ready."));
    }


}
