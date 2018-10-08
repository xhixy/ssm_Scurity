package com.itheima.service;

import com.itheima.pojo.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(int pageNum,int pageSize);

    public Orders findById(String id);
}
