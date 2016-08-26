/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.resources;

import com.lakhi.employee.dao.CompanyDao;
import com.lakhi.employee.api.Company;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author matrixm
 */
@Path("/company")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource {
    
    CompanyDao company;
    
    @Context
    HttpServletRequest request;

    public CompanyResource(CompanyDao company) {
        this.company = company;
    }

    @GET
    public List<Company> getAllCompanies(){
        System.out.println("\nToken = " + request.getSession().getAttribute("token"));
        return company.getAllCompanies();
    }
    
    @GET
    @Path("/{cid}")
    public List<Company> getCompanyById(@PathParam("cid") int cid){
        return company.getCompanyById(cid);
    }
    
    @POST
    public void addCompany(Company c){
        company.addCompany(c);
    }
    
    @DELETE
    @Path("/{cid}")
    public void deleteCompany(@PathParam("cid") int cid){
        company.deleteCompany(cid);
    }
    
    @PUT
    @Path("/{cid}")
    public void updateCompany(@PathParam("cid") int cid,Company c){
        c.setCid(cid);
        company.updateCompany(c);
    }
}
