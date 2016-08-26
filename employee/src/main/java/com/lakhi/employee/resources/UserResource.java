/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.resources;

import com.lakhi.employee.api.Session;
import com.lakhi.employee.api.User;
import com.lakhi.employee.dao.SessionDao;
import com.lakhi.employee.dao.UserDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author matrixm
 */
@Path("/user")
public class UserResource {

    UserDao user;
    SessionDao session;

    @Context
    HttpServletRequest request;
    
    public UserResource() {
    }
 
    public UserResource(UserDao user, SessionDao session) {
        this.user = user;
        this.session = session;
    }

    @POST
    @Path("/registration")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addUser(User u) {
        user.addUser(u);
    }

    @POST
    @Path("/login")
    public String login(User u)  {
        boolean aa = user.isLogin(u.getEmail(), u.getPassword());
        if (aa) {
            Session s = new Session(u.getEmail());
//            session.createSession(s.getAccessToken(), s.getEmail(), new java.util.Date());
               
            HttpSession se = request.getSession(true);
            se.setMaxInactiveInterval(1*60);
            se.setAttribute("token", s.getAccessToken());
            return "Email = " + u.getEmail() + "\nPassword = " + u.getPassword() + "\nToken = " + request.getSession().getAttribute("token");
        } else {
            System.err.println("TEST FAILD");
            return "Invalid Email or Password";
        }
    }
}
