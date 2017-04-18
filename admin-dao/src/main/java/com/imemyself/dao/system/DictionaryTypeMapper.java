package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.DictionaryType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryTypeMapper extends PagingMapper<DictionaryType, Long> {
    int update(DictionaryType entity);
    
    int updateByOptimisticLock(DictionaryType entity);

    Page<DictionaryType> findByPage(Pageable pageable, DictionaryType entity);

    int updateByPrimaryKey(DictionaryType entity);
}