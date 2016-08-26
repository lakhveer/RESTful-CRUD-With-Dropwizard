/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 *
 * @author matrixm
 */
public interface SessionDao {
    
    @SqlUpdate("insert into session values ( :accessToken, :email, :created) ")
    void createSession(@Bind("accessToken") String accessToken
        ,@Bind("email") String email
        ,@Bind("created") java.util.Date created);
    
}
