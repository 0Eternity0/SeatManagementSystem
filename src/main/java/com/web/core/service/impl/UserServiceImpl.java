package com.web.core.service.impl;

import com.web.core.mapper.UserMapper;
import com.web.core.pojo.User;
import com.web.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User selectUser(User user) {
        User use =userMapper.selectUser(user);
        return use;
    }
    @Override
    public void deleteUser(User user)
    {
        userMapper.deleteUser(user);
    }

    @Override
    public void updateUser(User user)
    {
        userMapper.updateUser(user);
    }
}
