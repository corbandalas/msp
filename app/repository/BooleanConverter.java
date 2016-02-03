package repository;

import com.github.pgasync.Converter;
import com.github.pgasync.impl.Oid;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Boolean converter for Async PostgreSQL connection driver
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 *
 */
public class BooleanConverter implements Converter<Boolean> {
    @Override
    public Class<Boolean> type() {
        return Boolean.class;
    }

    @Override
    public byte[] from(Boolean o) {
        return new String(o.toString()).getBytes(UTF_8);
    }

    @Override
    public Boolean to(Oid oid, byte[] value) {
        return new Boolean(new String(value, UTF_8));
    }
}