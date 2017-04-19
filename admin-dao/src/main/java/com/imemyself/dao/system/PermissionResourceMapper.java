package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.PermissionResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionResourceMapper extends PagingMapper<PermissionResource, Long> {

    int update(PermissionResource entity);
    
    int updateByOptimisticLock(PermissionResource entity);

    Page<PermissionResource> findByPage(Pageable pageable, PermissionResource entity);

    int updateByPrimaryKey(PermissionResource entity);
}