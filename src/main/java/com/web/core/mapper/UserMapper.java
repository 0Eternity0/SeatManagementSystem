package com.web.core.mapper;


import com.web.core.pojo.User;

/**
 * @author TCW
 */
public interface UserMapper {

    /**
     * 插入user
     * @param user
     */
    void insertUser(User user);
    User selectUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}
