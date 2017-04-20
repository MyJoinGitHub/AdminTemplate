package com.imemyself.service.system.impl;

import com.imemyself.dao.system.UserMapper;
import com.imemyself.domain.system.User;
import com.imemyself.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by linjie1 on 2017/4/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void test() {
        User user = new User();
        user.setUserCode("070440101");
        user.setLastLoginTime(new Date());
        user.setUserAddress("京东大厦");
        user.setUserEmail("linjie");
        user.setUserName("林杰");
        user.setUserPassword("123456");
        user.setUserMobile("13439700670");
        userMapper.insert(user);
//        if (user != null) {
//            throw new NullPointerException("测试事务");
//        }
//        userMapper.delete(user);
    }
}
