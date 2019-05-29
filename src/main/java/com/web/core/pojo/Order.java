package com.web.core.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer userId;

    private Integer seatId;

    private Date startTime;

    private Integer status;

    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Order(Integer userId, Integer seatId, Date startTime, Integer status, Date endTime) {
        this.userId = userId;
        this.seatId = seatId;
        this.startTime = startTime;
        this.status = status;
        this.endTime = endTime;
    }
}