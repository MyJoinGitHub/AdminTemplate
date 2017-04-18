package com.imemyself.dao.common;

import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public interface CrudMapper<T, ID extends Serializable> extends Repository<T, ID> {

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity
     * @return effects rows count
     */
    int insert(T entity);

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal null} if none found
     * @throws IllegalArgumentException if {@code id} is {@literal null}
     */
    T findOne(ID id);

    /**
     * Returns all instances of the type.
     *
     * @return all entities
     */
    List<T> findAll();

    /**
     * Returns all instances of the type with the given IDs.
     *
     * @param ids
     * @return
     */
    List<T> findAll(Iterable<ID> ids);

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be {@literal null}.
     * @return effects rows count
     */
    int delete(ID id);

    int delete(T entity);

}