package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.pojo.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    /*@RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(){
        List<Orders> ordersList = ordersService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ordersList",ordersList);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }*/

    //RequestParam中:
    //      name:客户端提交过来的参数名
    //      required:客户端是否一定要提交此参数,如果没提交,那么默认值是defaultValue指定的值
    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1") int pageNum , @RequestParam(name = "pageSize",required = true,defaultValue = "5") int pageSize){
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }

    @RequestMapping(path = "/findById.do")
    public ModelAndView findById(String id){
        Orders orders = ordersService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }
}
