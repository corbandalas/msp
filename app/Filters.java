import play.api.mvc.EssentialFilter;
import play.filters.cors.CORSFilter;
import play.http.HttpFilters;

import javax.inject.Inject;

/**
 * CORS(Cross-Origin Resource Sharing) Filter
 *
 * @author corbandalas - created 01.02.2016
 * @since 0.1.0
 *
 */
public class Filters implements HttpFilters {

    @Inject
    CORSFilter corsFilter;

//    @Inject
//    TimeLoggingFilter timeLoggingFilter;

    public EssentialFilter[] filters() {
        return new EssentialFilter[] { corsFilter };
    }
}