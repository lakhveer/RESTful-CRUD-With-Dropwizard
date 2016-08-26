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
public class Company {

    @JsonProperty
    private int cid;
    
    @JsonProperty
    private String companyName;
    
    @JsonProperty
    private String companyAddress;

    public Company() {
    }

    public Company(int cid, String companyName, String companyAddress) {
        this.cid = cid;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

}
