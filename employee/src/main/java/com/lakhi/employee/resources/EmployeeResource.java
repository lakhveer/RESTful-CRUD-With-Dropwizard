/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.resources;

import com.lakhi.employee.api.Employee;
import com.lakhi.employee.dao.EmployeeDao;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author matrixm
 */
@Path("/employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    EmployeeDao emp;

    public EmployeeResource(EmployeeDao emp) {
        this.emp = emp;
    }

    @POST
    public void addEmployee(Employee e) {
        emp.addEmployee(e);
    }

    @PUT
    @Path("/{eid}")
    public void updateEmployee(@PathParam("eid") int eid, Employee e) {
        e.setEid(eid);
        emp.updateEmployee(e);
    }

    @DELETE
    @Path("/{eid}")
    public void deleteEmployee(@PathParam("eid") int eid) {
        emp.deleteEmployee(eid);
    }

    @GET
    @Path("/company/{companyName}")
    public List<Employee> getEmployeeByCompany(@PathParam("companyName") String companyName) {
        int pageNo = 0;
        System.err.println("Page NO = " + pageNo);
        return emp.getEmployeeByCompany(companyName, pageNo);
    }

    @GET
    @Path("/company/{companyName}/{pageNo}")
    public List<Employee> getEmployeeByCompanyByPage(@PathParam("companyName") String companyName, @PathParam("pageNo") int pageNo) {
        int result = pageNo * 5;
        System.err.println("Page NO = " + result);
        return emp.getEmployeeByCompany(companyName, result);
    }

    @GET
    @Path("/employee/{name}")
    public List<Employee> getEmployeeByEmailOrName(@PathParam("name") String name) {
        return emp.getEmployeeByEmailOrName(name);
    }
}
