package com.web.core.pojo;

public class Seat {
    private Integer id;

    private Integer regionId;

    private String loca;

    private String falg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getLoca() {
        return loca;
    }

    public void setLoca(String loca) {
        this.loca = loca == null ? null : loca.trim();
    }

    public String getFalg() {
        return falg;
    }

    public void setFalg(String falg) {
        this.falg = falg == null ? null : falg.trim();
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", regionId=" + regionId +
                ", loca='" + loca + '\'' +
                ", falg='" + falg + '\'' +
                '}';
    }
}