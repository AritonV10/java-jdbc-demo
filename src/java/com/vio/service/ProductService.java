/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.service;

import com.vio.domain.Product;
import java.util.Set;

/**
 *
 * @author arito
 */
public interface ProductService {
    Set<Product> getProducts();
}
