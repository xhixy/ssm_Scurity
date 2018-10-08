package com.itheima.dao;

import com.itheima.pojo.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerMapper {


    @Select("select * from traveller where id in (select TRAVELLERID from ORDER_TRAVELLER where ORDERID = #{ordersId})")
    public List<Traveller> findAll(String id);
}
