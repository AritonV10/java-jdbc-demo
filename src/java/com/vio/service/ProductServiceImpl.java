/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.service;

import com.vio.domain.Product;
import com.vio.repository.ProductRepositoryImpl;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.StreamSupport;

/**
 *
 * @author arito
 */
public class ProductServiceImpl implements ProductService{

    final ProductRepositoryImpl repository = new ProductRepositoryImpl();
    
    @Override
    public Set<Product> getProducts() {
        Set<Product> products = new HashSet<>();
        repository.findAll()
                .iterator()
                .forEachRemaining(product -> products.add(product));
        return products;
    }
    
}
