package com.web.core.mapper;

import com.web.core.pojo.Order;

public interface OrderMapper {

    /**
     * 通过预约用户的Id查找座位的状态
     * @param userId
     * @return
     */
    Integer queryOrderStatusByUserId(int userId);

    /**
     * 通过用户的id修改座位的状态
     * @param userId 用户id
     * @param newStatus 新的状态
     */
    void changeOrderStatusByUserId(int userId,int newStatus);


    /**
     * 根据用户的id查询预约
     * @param UserId
     * @return
     */
    Order queryOderByUserId(int UserId);
}
