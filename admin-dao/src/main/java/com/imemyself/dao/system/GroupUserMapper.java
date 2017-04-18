package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.GroupUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserMapper extends PagingMapper<GroupUser, Long> {
    int update(GroupUser entity);
    
    int updateByOptimisticLock(GroupUser entity);

    Page<GroupUser> findByPage(Pageable pageable, GroupUser entity);

    int updateByPrimaryKey(GroupUser entity);
}