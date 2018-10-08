package com.itheima.controller;


import com.itheima.pojo.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductContorller {

    @Autowired
    private ProductService productService;

    private final static String REDIRECT = "redirect:findAll.do";

    @RequestMapping(path = "/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping(path = "/save.do")
    public String findAll(Product product){
        productService.saveProduct(product);
        return REDIRECT;
    }
}
