/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.dao;

import com.lakhi.employee.api.Company;
import com.lakhi.employee.api.mapper.CompanyMapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 *
 * @author matrixm
 */

@RegisterMapper(CompanyMapper.class)
public interface CompanyDao {
    
    @SqlUpdate("insert into company values(:cid, :companyName, :companyAddress)")
    void addCompany(@BindBean Company c);
    
    @SqlQuery("select * from company where cid = :cid")
    List<Company> getCompanyById(@Bind("cid") int cid );
 
    @SqlQuery("select * from company")
    List<Company> getAllCompanies();
    
    @SqlUpdate("delete from company where cid = :cid ")
    void deleteCompany(@Bind("cid") int id);
    
    @SqlUpdate("update company set companyName = :companyName, companyAddress = :companyAddress where cid = :cid ")
    void updateCompany(@BindBean Company c);
}
