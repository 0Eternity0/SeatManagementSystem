package com.web.core.mapper;


import com.web.core.pojo.Seat;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SeatMapper {

    /**
     * 查询指定时段，指定阅览区的所有空闲座位的信息
     * @param start
     * @param end
     * @param RegionId
     * @return
     */
    List<Seat> queryUsedSeatInfo(@Param("start") Date start, @Param("end") Date end, @Param("RegionId") int RegionId);

    /**
     * 查询指定阅览区的座位信息
     * @param regionId
     * @return
     */
    List<Seat> queryAllSeatInfo(@Param("id") int regionId);
}
