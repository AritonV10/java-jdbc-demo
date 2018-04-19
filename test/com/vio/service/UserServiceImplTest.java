/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.service;

import com.vio.domain.User;
import com.vio.repository.UserRepositoryImpl;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arito
 */

public class UserServiceImplTest {
    
   
    UserServiceImpl service;
    UserRepositoryImpl repository;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.service = new UserServiceImpl();
        this.repository = new UserRepositoryImpl();
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void getUsers(){
        Set<User> users = service.getUsers();
        
        assertEquals(1, users.size());
        
        
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
