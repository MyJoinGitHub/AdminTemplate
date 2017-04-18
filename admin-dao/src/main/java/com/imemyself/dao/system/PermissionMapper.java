package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper extends PagingMapper<Permission, Long> {
    int update(Permission entity);
    
    int updateByOptimisticLock(Permission entity);

    Page<Permission> findByPage(Pageable pageable, Permission entity);

    int updateByPrimaryKey(Permission entity);
}