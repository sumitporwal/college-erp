/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import web1.dao.logindao;

/**
 *
 * @author Windows
 */
public class loginteachersql {
    int i;
    public int authenticate(logindao dao)
    {
        try{
      String sql="select * from registerteacher where userid=? and password=?";   
       Connection con=Mysql.MySqlConnection.getconnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,dao.getUserid());
            ps.setString(2,dao.getPassword());
            ResultSet rs=ps.executeQuery();
                 if(rs.next()){
                 i=rs.getInt(1);
                         if(i==1){
                             return i;
                         }
             }
             else{
                 i=-1;
                 return i;
             }
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
