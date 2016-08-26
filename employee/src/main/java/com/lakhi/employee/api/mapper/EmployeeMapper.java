/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.api.mapper;

import com.lakhi.employee.api.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author matrixm
 */
public class EmployeeMapper implements ResultSetMapper<Employee>{

    @Override
    public Employee map(int i, ResultSet rs, StatementContext sc) throws SQLException {
        
        return new Employee(rs.getInt("eid"), rs.getInt("cid"), rs.getString("name"), rs.getString("mobile"), rs.getString("address"), rs.getString("email"), rs.getString("companyName"));
        
    }
    
}
