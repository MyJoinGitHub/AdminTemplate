package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceMapper extends PagingMapper<Resource, Long> {
    int update(Resource entity);
    
    int updateByOptimisticLock(Resource entity);

    Page<Resource> findByPage(Pageable pageable, Resource entity);

    int updateByPrimaryKey(Resource entity);
}