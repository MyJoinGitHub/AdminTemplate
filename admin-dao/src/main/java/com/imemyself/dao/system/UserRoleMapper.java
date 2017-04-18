package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper extends PagingMapper<UserRole, Long> {
    int update(UserRole entity);
    
    int updateByOptimisticLock(UserRole entity);

    Page<UserRole> findByPage(Pageable pageable, UserRole entity);

    int updateByPrimaryKey(UserRole entity);
}