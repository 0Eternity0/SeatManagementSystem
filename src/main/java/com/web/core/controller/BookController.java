package com.web.core.controller;



import com.web.core.pojo.SeatInfoItem;
import com.web.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 处理所有预约相关的请求
 * @author TCW
 */
@Controller
public class BookController {


    @Autowired
    private BookService bookService;

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
}
