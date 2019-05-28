package com.web.core.pojo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记录某一时段指定阅览区的座位信息
 * @author TCW
 */
public class SeatInfoItem {

    /*该预览区的座位总数*/
    private int seatNum;

    /*该时段可用的座位数*/
    private int canUse=-1;

    /*该时段该阅览区所有座位的信息*/
    private Map<Integer,Seat> seatMap=new HashMap<>();



    public SeatInfoItem(int seatNum, List<Seat> allSeatInfo){

        this.seatNum=seatNum;
        for(Seat seat:allSeatInfo){
            seatMap.put(seat.getId(),seat);
        }
    }

    /**
     * 更新空座位信息
     * @param usedSeatList 已占座位列表
     */
    public void updateSeatInfo(List<Seat> usedSeatList){
        this.canUse=this.seatNum-usedSeatList.size();
        for (Seat seat:usedSeatList){
            seat.setFalg("1");
            /*更新*/
            seatMap.put(seat.getId(),seat);
        }
    }



    /**
     * 返回接口指定的json格式字符串
     * @return
     */
    public  String toJson() throws Exception{

        if(canUse==-1){
            new Exception("未更新空座信息");
            return null;
        }
        JsonObject root=new JsonObject();
        root.addProperty("seatNum",seatNum);
        root.addProperty("canUse",canUse);

        JsonArray jsonArray=new JsonArray();
        JsonObject jo;
        for (Integer key :seatMap.keySet()){

            jo=new JsonObject();
            jo.addProperty("seatId",seatMap.get(key).getId());
            jo.addProperty("status","0".equals(seatMap.get(key).getFalg())?"empty":"used");
            jo.addProperty("loca",seatMap.get(key).getLoca());
            //加入数组
            jsonArray.add(jo);
        }
        root.add("seatInfo",jsonArray);

        return root.toString();
    }

    @Override
    public String toString() {
        return "SeatInfoItem{" +
                "seatNum=" + seatNum +
                ", canUse=" + canUse +
                ", seatMap=" + seatMap +
                '}';
    }
}
