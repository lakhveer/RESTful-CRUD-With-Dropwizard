/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.api.mapper;

import com.lakhi.employee.api.Company;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author matrixm
 */
public class CompanyMapper implements ResultSetMapper<Company>{

    @Override
    public Company map(int i, ResultSet rs, StatementContext sc) throws SQLException {
        return new Company(rs.getInt("cid"), rs.getString("companyName"), rs.getString("companyAddress"));
    }
    
}
