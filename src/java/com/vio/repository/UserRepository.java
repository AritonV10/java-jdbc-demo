/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.repository;

import com.vio.domain.User;
import java.util.Optional;

/**
 *
 * @author arito
 */
public interface UserRepository extends CRUD<User> {
    User findByUsername(String username);
}
