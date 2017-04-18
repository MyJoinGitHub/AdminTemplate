package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.RolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionMapper extends PagingMapper<RolePermission, Long> {
    int update(RolePermission entity);
    
    int updateByOptimisticLock(RolePermission entity);

    Page<RolePermission> findByPage(Pageable pageable, RolePermission entity);

    int updateByPrimaryKey(RolePermission entity);
}