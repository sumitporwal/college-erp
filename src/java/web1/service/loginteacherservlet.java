/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import web1.dao.logindao;
import web1.model.loginteachersql;

/**
 *
 * @author Windows
 */
@WebServlet(name = "loginteacherservlet", urlPatterns = {"/loginteacherservlet"})
public class loginteacherservlet extends HttpServlet {

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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
         try{
        String  userid=request.getParameter("userid");
        String pass = request.getParameter("pass");
         logindao login = new logindao(userid, pass);
        loginteachersql lt = new loginteachersql();
        int res = lt.authenticate(login);
        if (res>=0) {
       HttpSession session=request.getSession(); 
       session.setAttribute("teacher_userid",userid);
       session.setAttribute("teacher_pass", pass);
       Connection con=Mysql.MySqlConnection.getconnection();
       PreparedStatement ps=con.prepareStatement("select name from registerteacher where userid='"+session.getAttribute("teacher_userid")+"'");
       ResultSet rs=ps.executeQuery();
       while(rs.next()){
       session.setAttribute("teacher_name", rs.getString(1));
       }
       response.sendRedirect("welcometeacher.jsp");
        }
         else {
             response.sendRedirect("alertlogin.jsp");
        }
        }catch(Exception e)
        {
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
