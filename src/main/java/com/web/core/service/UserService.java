package com.web.core.service;

import com.web.core.pojo.User;


/**
 * @author TCW
 */
public interface UserService {

    /**
     * 插入一个user
     * @param user
     */
    void addUser(User user);
    User selectUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
