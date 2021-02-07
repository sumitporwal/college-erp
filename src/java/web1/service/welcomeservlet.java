/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Array;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import web1.dao.welcomedao;
import web1.model.welcomesql;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author Windows
 */
@WebServlet(name = "welcomeservlet", urlPatterns = {"/welcomeservlet"})
public class welcomeservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
/*protected int phy(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    int i=0;
             try{ 
            String clas=req.getParameter("class");
            String sql="select userid,name from register where class=?";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,clas);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                 i++;
            }
             }catch(Exception e){
                 e.printStackTrace();
             }
             return i;
}
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int attendance[]=new int[100];
        int total[]=new int[100];
        double percent[]=new double[100];
        HttpSession session=req.getSession(); 
        String subjectid[] = req.getParameterValues("subjectid");
        String subjectname[] = req.getParameterValues("subject");
        String attended[] = req.getParameterValues("attendance");
        String date[] = req.getParameterValues("date");
        String userid1[]=req.getParameterValues("enroll");
         try{
    Connection con=Mysql.MySqlConnection.getconnection();
        PreparedStatement ps=con.prepareStatement("insert into attendance values(?,?,?,?,?,?,?,?)");
        for(int i=0;i<attended.length;i++){
        if(attended[i].equals("P")||attended[i].equals("p"))
           {
            attendance[i]=attendance[i]+1;
            total[i]=total[i]+1;
            percent[i]=((attendance[i])*100)/total[i];
           }
           else if(attended[i].equals("A")||attended[i].equals("a"))
                   {
                   total[i]=total[i]+1;
                   percent[i]=((attendance[i])*100)/total[i];
                   }
        ps.setString(1,subjectid[i]);
        ps.setString(2,subjectname[i]);
        ps.setString(3,attended[i]);
        ps.setInt(4, attendance[i]);
        ps.setInt(5,total[i]);
        ps.setString(6,date[i]);
        ps.setDouble(7,percent[i]);
        ps.setString(8, userid1[i]);
        int r=ps.executeUpdate();
        }
         }catch(Exception e){
             e.printStackTrace();
         }
}


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
