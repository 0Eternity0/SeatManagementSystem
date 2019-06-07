package com.web.core.mapper;

import com.web.core.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TCW
 */
public interface OrderMapper {

    /**
     * 通过预约用户的Id查找座位的状态
     * @param userId
     * @return
     */
    Integer queryOrderStatusByUserId(@Param("userId") int userId);

    /**
     * 通过用户的id修改座位的状态
     * @param userId 用户id
     * @param newStatus 新的状态
     */
    void changeOrderStatusByUserId(@Param("userId") int userId,@Param("newStatus") int newStatus);


    /**
     * 根据用户的id查询预约
     * @param UserId
     * @return
     */
    Order queryOderByUserId(@Param("userId") int UserId);

    void deleteOrderByUserId(@Param("userId") int userId);
}
