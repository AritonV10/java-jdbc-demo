/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.service;

import com.vio.domain.User;
import com.vio.repository.UserRepositoryImpl;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author arito
 */
public class UserServiceImpl implements UserService {
    
    
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    
    @Override
    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll()
                .iterator()
                .forEachRemaining(user -> users.add(user));
        
        return users;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            return null;
        }
        
        return user;
    }

    @Override
    public User registerUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
