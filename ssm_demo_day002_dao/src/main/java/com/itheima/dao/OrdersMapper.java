package com.itheima.dao;

import com.itheima.pojo.Member;
import com.itheima.pojo.Orders;
import com.itheima.pojo.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 会员
 */
public interface OrdersMapper {

    /**
     * 查询所有
     * @return List<Orders>
     */
    @Select("select * from orders")
    @Results({
                    @Result(id=true,property = "id",column = "id"),
                    @Result(property = "orderNum",column = "orderNum"),
                    @Result(property = "orderTime",column = "orderTime"),
                    @Result(property = "orderStatus",column = "orderStatus"),
                    @Result(property = "peopleCount",column = "peopleCount"),
                    @Result(property = "payType",column = "payType"),
                    @Result(property = "payTypeStr",column = "payTypeStr"),
                    @Result(property = "orderDesc",column = "orderDesc"),
                    @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itheima.dao.ProductMapper.findById"))
            })
    public List<Orders> findAll();


    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from orders where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "com.itheima.dao.ProductMapper.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.itheima.dao.MemberMapper.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.TravellerMapper.findAll")),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc")
    })
    public Orders findById(String id);
    
}