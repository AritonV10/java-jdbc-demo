/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vio.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author arito
 */
public class AbstractDomain implements Serializable{
    
    // when was the object created
    private Date dateCreated;
    
    
    // when it was the object last updated
    private Date lastUpdated;
    
}
