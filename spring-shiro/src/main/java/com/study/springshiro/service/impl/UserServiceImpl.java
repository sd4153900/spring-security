package com.study.springshiro.service.impl;

import com.study.springshiro.mapper.UserMapper;
import com.study.springshiro.model.User;
import com.study.springshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
