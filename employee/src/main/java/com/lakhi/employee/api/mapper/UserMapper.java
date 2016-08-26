/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.api.mapper;

import com.lakhi.employee.api.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author matrixm
 */
public class UserMapper implements ResultSetMapper<User>{

    @Override
    public User map(int i, ResultSet rs, StatementContext sc) throws SQLException {

        return new User(rs.getInt("uid"), rs.getString("email"), rs.getString("password"), rs.getString("companyName"), rs.getInt("cid"));
        
    }
    
}
