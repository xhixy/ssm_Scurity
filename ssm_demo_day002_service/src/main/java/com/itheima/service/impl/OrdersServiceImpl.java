package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrdersMapper;
import com.itheima.pojo.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 哈哈
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return ordersMapper.findAll();
    }

    @Override
    public Orders findById(String id) {
        return ordersMapper.findById(id);
    }
}
