package model;

/**
 * Base Entity class
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 *
 */
public abstract class BaseEntity<T> {

    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

}
