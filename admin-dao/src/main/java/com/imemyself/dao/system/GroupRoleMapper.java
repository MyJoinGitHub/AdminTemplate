package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.GroupRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRoleMapper extends PagingMapper<GroupRole, Long> {
    int update(GroupRole entity);
    
    int updateByOptimisticLock(GroupRole entity);

    Page<GroupRole> findByPage(Pageable pageable, GroupRole entity);

    int updateByPrimaryKey(GroupRole entity);
}