/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Windows
 */
public class MySqlConnection {
     private static MySqlConnection _instance;
    private static Connection con ;
    
    
    

    public static Connection getconnection(){
        if(con==null){
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studant?useSSL=false","root","root");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return con;
    }
}
