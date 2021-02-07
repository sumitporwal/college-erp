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
import web1.dao.welcomedao;

/**
 *
 * @author Windows
 */
public class welcomesql {
   int i;
    public int attendance(welcomedao dao){
        try{
    Connection con=Mysql.MySqlConnection.getconnection();
        PreparedStatement ps=con.prepareStatement("insert into attendance values(?,?,?,?,?,?,?,?,?)");
        ps.setString(1,dao.getSubjectid());
        ps.setString(2,dao.getSubjectname());
        ps.setString(3,dao.getAttended());
        ps.setInt(4, dao.getAttendance());
        ps.setInt(5,dao.getTotal());
        ps.setString(6,dao.getDate());
        ps.setDouble(7,dao.getPercent());
        ps.setString(8,dao.getUserid());
        ps.setString(9, dao.getUserid1());
        ps.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }
    }
