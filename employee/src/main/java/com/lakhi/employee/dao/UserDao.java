/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lakhi.employee.dao;

import com.lakhi.employee.api.User;
import com.lakhi.employee.api.mapper.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 *
 * @author matrixm
 */

@RegisterMapper(UserMapper.class)
public interface UserDao {
    
    @SqlUpdate("insert into user values(:uid, :email, MD5(:password), :cid)")
    void addUser(@BindBean User u);
    
    @SqlQuery("select * from user where email = :email and password = MD5(:password) ")
    boolean isLogin(@Bind("email") String email ,@Bind("password") String password);
//    List<User> isLogin(@Bind("email") String email ,@Bind("password") String password);
//    Integer isLogin(@BindBean User u);
    
    
}
