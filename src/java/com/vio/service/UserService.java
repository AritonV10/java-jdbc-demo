/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.service;

import com.vio.domain.User;
import java.util.Set;

/**
 *
 * @author arito
 */
public interface UserService {
    
    Set<User> getUsers();
    User findByUsername(String username);
    User registerUser(User user);
}
