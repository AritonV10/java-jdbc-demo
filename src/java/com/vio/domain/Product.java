/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.domain;

import java.util.logging.Logger;

/**
 *
 * @author arito
 * User entity
 */
public class Product extends AbstractDomain {
    
    private String productName;
    private Double productCost;
    private boolean isStock;

    public void setIsStock(boolean isStock) {
        this.isStock = isStock;
    }

    public boolean isIsStock() {
        return isStock;
    }
    
    public Product(){super();}

    
    
    public String getProductName() {
        return productName;
    }

    public Double getProductCost() {
        return productCost;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }
    
    
}
