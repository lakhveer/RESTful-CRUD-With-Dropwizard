/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.dao;

import com.lakhi.employee.api.Employee;
import com.lakhi.employee.api.mapper.EmployeeMapper;
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

@RegisterMapper(EmployeeMapper.class)
public interface EmployeeDao {

    @SqlUpdate("insert into employee values(:eid, :cid, :name, :mobile, :address, :email) ")
    void addEmployee(@BindBean Employee e);
    
    @SqlUpdate("update employee set name = :name, mobile = :mobile, address = :address, email = :email where eid = :eid")
    void updateEmployee(@BindBean Employee e);
    
    @SqlUpdate("delete from employee where eid = :eid ")
    void deleteEmployee(@Bind("eid") int eid);
    
    @SqlQuery("select e.*,c.companyName from employee e, company c where e.cid = c.cid And c.companyName = :companyName LIMIT 5 OFFSET :result")
    List<Employee> getEmployeeByCompany(@Bind("companyName") String companyName, @Bind("result") int result);
    
    @SqlQuery("select e.*,c.companyName from employee e, company c where (e.name like ':name%' or e.email like ':name%') AND e.cid = c.cid ")
    List<Employee> getEmployeeByEmailOrName(@Bind("name") String name);
}
