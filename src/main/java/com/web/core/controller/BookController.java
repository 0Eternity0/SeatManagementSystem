package com.web.core.controller;



import com.web.core.mapper.SeatMapper;
import com.web.core.pojo.Order;
import com.web.core.pojo.SeatInfoItem;
import com.web.core.pojo.User;
import com.web.core.service.BookService;
import com.web.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理所有预约相关的请求
 * @author TCW
 */
@Controller
@RequestMapping("Book")
public class BookController {


    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    /**
     * 处理座位信息查询请求
     * @param time
     * @param area
     * @return
     */
    @RequestMapping("querySeat")
    @ResponseBody
    public String querySeat(String time,String area){


        System.out.println("time = [" + time + "], area = [" + area + "]");
        String[] times=time.split(" to ");
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        int regionId=Integer.parseInt(area);
        Date startTime;
        Date endTime;
        try {
            /*解析查询的开始和结束时段*/
            startTime =sdf.parse(times[0]);
            endTime =sdf.parse(times[1]);

            SeatInfoItem seatInfoItem = bookService.query(startTime, endTime, regionId);

            return seatInfoItem.toJson();


        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }



    }

    /**
     * 处理预约的请求
     * @param time 预约的时间段信息
     * @param SeatNum 座位的编号
     * @return
     */
    @RequestMapping("SelSeat")
    @ResponseBody
    public String SelSeat(String time, int SeatNum, HttpSession session){
        System.out.println("time = [" + time + "], SeatNum = [" + SeatNum + "]");
        String[] times=time.split(" to ");
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        Date startTime;
        Date endTime;
        try {
            /*解析查询的开始和结束时段*/
            startTime = sdf.parse(times[0]);
            endTime = sdf.parse(times[1]);
            User user=(User)session.getAttribute("User");
            if(user==null){
                //未登录
                return "0";
            }
            Order order=new Order(user.getId(),SeatNum,startTime,0,endTime);
           //预约
            if(bookService.makeOrder(order)){
                return "1";
            }else{
                return "0";
            }
        }catch (ParseException e){
            e.printStackTrace();
            return "0";
        }

    }


    /**
     * 处理用户入座的请求
     * @param session
     * @return
     */
    @RequestMapping("SignIn")
    @ResponseBody
    public String SignIn(HttpSession session){
       User user= (User)session.getAttribute("User");
       if(user!=null){
           if(orderService.signIn(user.getId())){
               return "1";
           }else {
               return "0";
           }
       }

        return "0";
    }
}