/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author matrixm
 */
public class User {
 
    @JsonProperty
    private int uid;
    
    @JsonProperty
    private String email;
    
    @JsonProperty
    private String password;
    
    @JsonProperty
    private String companyName;

    @JsonProperty
    private int cid;
    
    public User(){
        
    }
    
    public User(int uid, String email, String password, String companyName, int cid) {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
}
