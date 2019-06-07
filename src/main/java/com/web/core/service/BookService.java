package com.web.core.service;


import com.web.core.pojo.Order;
import com.web.core.pojo.SeatInfoItem;

import java.util.Date;


/**
 * @author TCW
 */
public interface BookService {

    /**
     * 查询指定时段，指定阅览区的座位占用情况
     * @param startTime
     * @param endTime
     * @param regionId
     * @return
     */
   SeatInfoItem query(Date startTime,Date endTime,int regionId);

    /**
     * 检查指定座位的在指定时间段的状态
     * @param startTime 时间段的开始时间
     * @param endTime 时间段的结束时间
     * @param seatId 座位的主键
     * @return 0：空闲 1：已预约未入座 2：已入座 3：暂时离开
     */
    int checkSeatStatus(Date startTime,Date endTime,int seatId);

    /**
     * 确认座位状态并进行预约操作
     * @param order
     * @return 成功返回true，否者返回false
     */
    boolean makeOrder(Order order);
}
