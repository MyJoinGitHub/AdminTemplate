package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.Dictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryMapper extends PagingMapper<Dictionary, Long> {
    int update(Dictionary entity);

    int updateByOptimisticLock(Dictionary entity);

    Page<Dictionary> findByPage(Pageable pageable, Dictionary entity);

    int updateByPrimaryKey(Dictionary entity);
}