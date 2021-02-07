/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web1.dao.forgotpassworddao;
import web1.dao.setpassworddao;
import web1.model.forgotpasswordsql;

/**
 *
 * @author Windows
 */
@WebServlet(name = "forgotpasswordservlet", urlPatterns = {"/forgotpasswordservlet"})
public class forgotpasswordservlet extends HttpServlet {

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
         response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet        }catch(Exception e)
-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String to=request.getParameter("to");
        String from="princecr7singh@gmail.com";
        String pass="princesingh123";
        String pass1=Mailer.link(5);
      
        try{ 
            forgotpassworddao dao=new forgotpassworddao(to);
        forgotpasswordsql sq=new forgotpasswordsql();
        int result=sq.authenticate(dao);
        if(result>=0)
        {
         Mailer.send(to,from,pass,pass1);
          Mailer.register(pass1,to);
        response.sendRedirect("login.jsp");
        }
        else{
            response.sendRedirect("alertpassword.jsp");
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
//
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
