package com.web.core.service;

import com.web.core.pojo.User;

/**
 * @author TCW
 */
public interface UserService {

     int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectBynamepwd(String username,String password);
}
