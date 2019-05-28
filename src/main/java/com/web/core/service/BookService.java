package com.web.core.service;


import com.web.core.pojo.SeatInfoItem;

import java.util.Date;

public interface BookService {

    /**
     * 查询指定时段，指定阅览区的座位占用情况
     * @param startTime
     * @param endTime
     * @param regionId
     * @return
     */
   SeatInfoItem query(Date startTime,Date endTime,int regionId);
}
