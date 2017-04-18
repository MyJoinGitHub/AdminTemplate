package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper extends PagingMapper<Role, Long> {
    int update(Role entity);
    
    int updateByOptimisticLock(Role entity);

    Page<Role> findByPage(Pageable pageable, Role entity);

    int updateByPrimaryKey(Role entity);
}