/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import web1.dao.registerteacherdao;

/**
 *
 * @author Windows
 */
public class registerteachersql {
     int i;
     public int registerteacher(registerteacherdao dao)
    {
    try{
        Connection con=Mysql.MySqlConnection.getconnection();
        PreparedStatement ps=con.prepareStatement("insert into registerteacher values(default,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,dao.getName());
        ps.setString(2,dao.getEmail());
        ps.setString(3,dao.getPhno());
        ps.setString(4,dao.getPassword());
        ps.setString(5,dao.getUserid());
        ps.setString(6,dao.getBranch());
        ps.setString(7,dao.getPhoto());
        ps.setString(8,dao.getFilename());
         ps.executeUpdate();
          ResultSet rs=ps.getGeneratedKeys();
         rs.next();
    }catch(Exception e){
        e.printStackTrace();
    }
    return i;
    }
}
