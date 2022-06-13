package org.dkit.repository;

import org.dkit.domain.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @param <T> Entity
 * @param <I> Entity Id
 */
public class AbstractRepository<T extends Entity<I>, I> {

    /**
     * @return all entities
     */
    public List<T> get(){
        return new ArrayList<>();
    }


    /**
     * @param id entity id
     * @return the entity with the given id
     */
    public Optional<T> getById(I id){
        return Optional.empty();
    }


    /**
     * @param entity entity to save
     * @return saved entity (to get the auto generated ID)
     */
    public T save(T entity){
        return null;
    }

    /**
     * @param entities list of entities to save
     * @return saved entities (to get the auto generated IDs)
     */
    public List<T> save(List<T> entities){
        return new ArrayList<>();
    }

    /**
     * @param entity entity to update
     * @return void
     */
    public void update(T entity){

    }

    /**
     * @param entities list of entities to update
     * @return void
     */
    public void update(List<T> entities){

    }

    /**
     * delete entity
     * @param entity to delete
     * @return void
     */
    public void delete(T entity){

    }

    /**
     * delete list of entities
     * @param entities list of entities to delete
     * @return void
     */
    public void delete(List<T> entities){

    }

    /**
     * delete entity with given id
     * @param id if the entity to be deleted
     * @return void
     */
    public void deleteById(I id){

    }
}
