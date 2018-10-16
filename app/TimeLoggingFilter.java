import play.Logger;
import play.api.libs.iteratee.Execution;
import play.api.libs.iteratee.Iteratee;
import play.api.mvc.EssentialAction;
import play.api.mvc.EssentialFilter;
import play.api.mvc.RequestHeader;
import play.api.mvc.Result;
import play.libs.Scala;
import scala.Function1;
import scala.Tuple2;
import scala.collection.Seq;
import scala.runtime.AbstractFunction1;

import java.util.ArrayList;
import java.util.List;

public class TimeLoggingFilter implements EssentialFilter {

    public EssentialAction apply(final EssentialAction next) {

        return new TimeLoggingAction() {

            @Override
            public EssentialAction apply() {
                return next.apply();
            }

            @Override
            public Iteratee<byte[], Result> apply(final RequestHeader rh) {
                final long startTime = System.currentTimeMillis();

                return next.apply(rh).map(new AbstractFunction1<Result, Result>() {

                    @Override
                    public Result apply(Result v1) {
                        long time = logTime(rh, startTime);
                        List<Tuple2<String, String>> list = new ArrayList<>();
                        Tuple2<String, String> t =
                                new Tuple2<>("Request-Time",
                                        String.valueOf(time));
                        list.add(t);
                        Seq<Tuple2<String, String>> seq = Scala.toSeq(list);
                        return v1.withHeaders(seq);
                    }

                    @Override
                    public <A> Function1<Result, A> andThen(Function1<Result, A> g) {
                        return g;
                    }

                    @Override
                    public <A> Function1<A, Result> compose(Function1<A, Result> g) {
                        return g;
                    }

                }, Execution.defaultExecutionContext());
            }


            private long logTime(RequestHeader request, long startTime) {
                long endTime = System.currentTimeMillis();
                long requestTime = endTime - startTime;
                Logger.info(request.uri() + " from " + request.remoteAddress() + " took " + requestTime + " ms");

                return requestTime;
            }
        };
    }

    public abstract class TimeLoggingAction extends
            AbstractFunction1<RequestHeader, Iteratee<byte[], Result>>
            implements EssentialAction {}
}