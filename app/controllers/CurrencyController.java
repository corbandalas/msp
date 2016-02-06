package controllers;

import com.google.inject.Inject;
import model.Currency;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import repository.CurrencyRepository;

import java.util.List;

/**
 * @author ra - created 06.02.2016.
 * @since 0.1.0
 */
public class CurrencyController extends BaseController {

    @Inject
    CurrencyRepository currencyRepository;

    public F.Promise<Result> retrieveAll() {

        F.Promise<List<Currency>> historyPromise = F.Promise.wrap(currencyRepository.retrieveAll());

        historyPromise.onFailure(throwable->throwable.printStackTrace());

        return historyPromise.map(res->ok(Json.toJson(res)));
    }
}
