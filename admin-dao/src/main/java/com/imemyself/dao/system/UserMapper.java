package com.imemyself.dao.system;

import com.imemyself.dao.common.PagingMapper;
import com.imemyself.domain.system.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends PagingMapper<User, Long> {
    int update(User entity);
    
    int updateByOptimisticLock(User entity);

    Page<User> findByPage(Pageable pageable, User entity);

    int updateByPrimaryKey(User entity);
}