package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMapper extends PagingMapper<Group, Long> {
    int update(Group entity);
    
    int updateByOptimisticLock(Group entity);

    Page<Group> findByPage(Pageable pageable, Group entity);

    int updateByPrimaryKey(Group entity);
}