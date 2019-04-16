package com.web.core.pojo;

public class Region {
    private Integer id;

    private String regionName;

    private String regionCategory;

    private Integer seatNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getRegionCategory() {
        return regionCategory;
    }

    public void setRegionCategory(String regionCategory) {
        this.regionCategory = regionCategory == null ? null : regionCategory.trim();
    }

    public Integer getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }
}