/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.repository;

import com.vio.db.config.ConnectionPool;
import com.vio.domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arito
 */
public class ProductRepositoryImpl implements ProductRepository{

    private final ConnectionPool pool = ConnectionPool.getInstance();
    
    @Override
    public Set<Product> findAll() {
        final String FIND_ALL = "SELECT * FROM product";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Set<Product> products = new HashSet<>();
               try{
            connection = pool.getConnection();
            statement = connection.prepareStatement(FIND_ALL);
            result = statement.executeQuery();
            while(result.next()){
                final String PRODUCT_NAME = result.getString("product_name");
                final Double PRODUCT_PRICE = result.getObject("product_price", Double.class);
                final boolean IS_AVAILABLE = result.getBoolean("product_stock");
                final Product product = new Product();
                product.setProductName(PRODUCT_NAME);
                product.setProductName(PRODUCT_NAME);
                product.setIsStock(IS_AVAILABLE);
                products.add(product);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
               
         return products;
    }

    @Override
    public <U extends String> Product findById(U objectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product update(Product object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product save(Product object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <U extends String> void delete(U objectId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
