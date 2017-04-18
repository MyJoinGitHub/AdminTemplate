package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.SystemParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemParamMapper extends PagingMapper<SystemParam, Long> {
    int update(SystemParam entity);
    
    int updateByOptimisticLock(SystemParam entity);

    Page<SystemParam> findByPage(Pageable pageable, SystemParam entity);

    int updateByPrimaryKey(SystemParam entity);
}