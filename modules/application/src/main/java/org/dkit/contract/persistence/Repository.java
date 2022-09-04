package org.dkit.contract.persistence;


import java.util.List;
import java.util.Optional;

/**
 * @param <T> Object
 * @param <I> Object Id
 */
public interface Repository<T, I> {

    /**
     * @return all entities
     */
    List<T> get();

    /**
     * @param id entity id
     * @return the entity with the given id
     */
    Optional<T> getById(I id);

    /**
     * @param entity entity to save
     * @return saved entity (to get the auto generated ID)
     */
    T save(T entity);

    /**
     * @param entities list of entities to save
     * @return saved entities (to get the auto generated IDs)
     */
    List<T> save(List<T> entities);

    /**
     * @param entity entity to update
     * @return void
     */
    void update(T entity);

    /**
     * @param entities list of entities to update
     * @return void
     */
    void update(List<T> entities);

    /**
     * delete entity
     * @param entity to delete
     * @return void
     */
    void delete(T entity);

    /**
     * delete list of entities
     * @param entities list of entities to delete
     * @return void
     */
    void delete(List<T> entities);

    /**
     * delete entity with given id
     * @param id if the entity to be deleted
     * @return void
     */
    void deleteById(I id);
}
