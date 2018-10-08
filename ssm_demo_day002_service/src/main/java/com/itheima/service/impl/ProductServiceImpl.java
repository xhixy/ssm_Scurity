package com.itheima.service.impl;

import com.itheima.dao.ProductMapper;
import com.itheima.pojo.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        System.out.println(product);
        int a = 1;
        productMapper.save(product);
    }
}
