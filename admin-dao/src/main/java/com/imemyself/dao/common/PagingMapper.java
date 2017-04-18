package com.imemyself.dao.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * Created by linjie1 on 2017/2/22.
 */
public interface PagingMapper<T, ID extends Serializable> extends CrudMapper<T, ID> {

    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     *
     * @param pageable
     * @return a page of entities
     */
    Page<T> findAll(Pageable pageable);
}