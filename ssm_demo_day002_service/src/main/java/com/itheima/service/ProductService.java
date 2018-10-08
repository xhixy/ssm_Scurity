package com.itheima.service;

import com.itheima.pojo.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void saveProduct(Product product);
}
