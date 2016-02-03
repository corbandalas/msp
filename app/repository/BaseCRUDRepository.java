package repository;

import model.BaseEntity;
import scala.concurrent.Future;

import java.util.List;

/**
 * Base DAO interface
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */
public interface  BaseCRUDRepository<T extends BaseEntity> {

    Future<T> create(T entity);

    Future<T> retrieveById(Object id);

    Future<List<T>> retrieveAll();

    Future<T> update(T entity);

    void delete(T entity);

}
