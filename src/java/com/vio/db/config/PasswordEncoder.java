/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.db.config;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author arito
 */
public class PasswordEncoder {
    
    private MessageDigest md;

    public PasswordEncoder() throws NoSuchAlgorithmException {
        this.md = MessageDigest.getInstance("SHA-256");
    }
    
    public String encode(String password){
        
        StringBuffer buffer = null;
        
        try{
        byte[] hash = this.md.digest(password.getBytes("UTF-8"));
        buffer = new StringBuffer();
        
        for(int i = 0; i < hash.length; i++){
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) buffer.append("0");
            buffer.append(hex);
        }
        
        } catch (Exception e){
           e.printStackTrace();
        }
        
        return buffer.toString(); 
    }
          
}
