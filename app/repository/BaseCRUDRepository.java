package repository;

import com.github.pgasync.ResultSet;
import com.github.pgasync.Row;
import model.BaseEntity;
import model.Country;
import scala.concurrent.Future;

import java.util.List;
import java.util.Optional;

/**
 * Base DAO interface
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */
public interface BaseCRUDRepository<T extends BaseEntity> {


    //DB CRUD Methods
    Future<T> create(T entity);

    Future<Optional<T>> retrieveById(Object id);

    Future<List<T>> retrieveAll();

    Future<T> update(T entity);

    void delete(T entity);


    //Helpers methods
    T createEntity(Row row);


    default Optional<T> createEntity(ResultSet resultSet) {


        if (resultSet.size() > 0) {
            Row row = resultSet.row(0);

            return Optional.of(createEntity(row));

        } else {
            return Optional.ofNullable(null);
        }
    }

}
