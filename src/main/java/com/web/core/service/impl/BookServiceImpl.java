package com.web.core.service.impl;

import com.web.core.mapper.RegionMapper;
import com.web.core.mapper.SeatMapper;
import com.web.core.pojo.Region;
import com.web.core.pojo.Seat;
import com.web.core.pojo.SeatInfoItem;
import com.web.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


@Service
public class BookServiceImpl  implements BookService {

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public SeatInfoItem query(Date startTime, Date endTime, int regionId) {


        Region region = regionMapper.selectByPrimaryKey(regionId);


        List<Seat> allSeatList=seatMapper.queryAllSeatInfo(regionId);

        SeatInfoItem seatInfoItem=new SeatInfoItem(region.getSeatNum(),allSeatList);
        List<Seat> UsedSeatList=seatMapper.queryUsedSeatInfo(startTime,endTime,regionId);
        seatInfoItem.updateSeatInfo(UsedSeatList);


        return seatInfoItem;
    }
}
