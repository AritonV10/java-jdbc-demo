/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author arito
 */
public class Cart extends AbstractDomain{
    
    private Collection<Product> products = new ArrayList<>();
    private Integer quantity;

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" + "products=" + products + ", quantity=" + quantity + '}';
    }

    
    
    
    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
    
    public Collection<Product> getProducts() {
        return products;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    
    
}
