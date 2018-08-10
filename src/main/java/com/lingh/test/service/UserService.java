package com.lingh.test.service;

import com.lingh.test.db.dao.TUserMapper;
import com.lingh.test.db.entity.TUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    TUserMapper userMapper;

    public TUser getByUsername(String username) {
        return userMapper.getByUserName(username);
    }
}
