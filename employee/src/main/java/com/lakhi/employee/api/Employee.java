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
public class Employee {

    @JsonProperty
    private int eid;

    @JsonProperty
    private int cid;

    @JsonProperty
    private String name;

    @JsonProperty
    private String mobile;

    @JsonProperty
    private String address;

    @JsonProperty
    private String email;

    @JsonProperty
    private String comapnyName;
    
    public Employee() {

    }

    public Employee(int eid, int cid, String name, String mobile, String address, String email, String comapnyName) {
        this.eid = eid;
        this.cid = cid;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.email = email;
        this.comapnyName = comapnyName;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComapnyName() {
        return comapnyName;
    }

    public void setComapnyName(String comapnyName) {
        this.comapnyName = comapnyName;
    }

}
