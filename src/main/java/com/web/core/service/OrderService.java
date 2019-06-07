package com.web.core.service;

import java.util.Date;

public interface OrderService {

    /**
     * 根据用户Id获取其所预约的座位的状态
     *
     * @param UserId 用户的id
     * @return 座位的状态
     */
    String getSeatStatus(int UserId);

    /**
     * 根据用户的Id入座
     * @param UserId
     * @return
     */
    boolean signIn(int UserId);


    /**
     * 根据用户的id完成暂时离开
     *
     * @param UserId
     * @return
     */
    boolean stepOut(int UserId);


    /**
     * 检查现在是否是在预约时间段
     * @param now
     * @return
     */
    boolean checkTime(int userId,Date now);

    /**
     * 用户离开座位
     * @param userId
     * @return
     */
    boolean leave(int userId);

}
