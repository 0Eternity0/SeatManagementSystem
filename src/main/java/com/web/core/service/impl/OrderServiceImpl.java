package com.web.core.service.impl;

import com.web.core.mapper.OrderMapper;
import com.web.core.pojo.Order;
import com.web.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String getSeatStatus(int UserId) {
        Integer status=orderMapper.queryOrderStatusByUserId(UserId);
        if(status!=null){
            if(status==0){
                //待入座
                return "0";
            }else if(status==1){
                //已经入座
                return "1";
            }else if(status==2){
                //暂时离开
                return "2";

            }
        }
        return "null";
    }


    @Override
    public boolean signIn(int UserId) {
        String status=getSeatStatus(UserId);
        if("0".equals(status)||"2".equals(status)){
            orderMapper.changeOrderStatusByUserId(UserId,1);
            return true;
        }
        return false;
    }

    @Override
    public boolean stepOut(int UserId) {
        String status=getSeatStatus(UserId);
        if("1".equals(status)){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkTime(int userId, Date now) {
        Order order = orderMapper.queryOderByUserId(userId);
        if(now.after(order.getStartTime()) && order.getEndTime().after(now)){
            return true;
        }
        return false;
    }


}
