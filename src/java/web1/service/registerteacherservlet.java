/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import web1.dao.registerteacherdao;
import web1.model.registerteachersql;

/**
 *
 * @author Windows
 */
@WebServlet(name = "registerteacherservlet", urlPatterns = {"/registerteacherservlet"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class registerteacherservlet extends HttpServlet {
private static final String SAVE_DIR = "Staff_Images";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     private final static Logger LOGGER = 
            Logger.getLogger(registerservlet.class.getCanonicalName());
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet registerteacherservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerteacherservlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    private String getFileName(final Part part){
         final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
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
         public class Validation{
         public boolean email_Validation(String email){
          boolean status=false;
          String email_Pattern="^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
          Pattern pattern=Pattern.compile(email_Pattern);
Matcher matcher=pattern.matcher(email);
if(matcher.matches()){
status=true;
}
else{
status=false;
}
return status;
      }
          public boolean mobileno_Validation(String mobileno)
 {
     boolean stat=false;
      String pattern = "[6-9][0-9]{9}";  
      Pattern pat=Pattern.compile(pattern);
      Matcher match=pat.matcher(mobileno);
      if(match.matches()){
          stat=true;
          }
      else{
          stat=false;
      }
      return stat;
 }
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       final String path = req.getServletContext().getRealPath("");
    String savePath = path + File.separator + SAVE_DIR;
    File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        final Part filePart=req.getPart("file");
        String filename=getFileName(filePart);
        String id = UUID.randomUUID().toString();
        String[] fileNameSplits = filename.split("\\.");
        int extensionIndex = fileNameSplits.length - 1;
        String newfilename= id + "." + fileNameSplits[extensionIndex];
        OutputStream out=null;     
        InputStream filecontent=null;
        try{
        out=new FileOutputStream(new File(savePath+File.separator+newfilename));
        filecontent=filePart.getInputStream();
        int read=0;
        final byte[] bytes=new byte[1024];
        while((read=filecontent.read(bytes))!=-1){
            out.write(bytes,0,read);
        }
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phno = req.getParameter("phno");
        String pass = req.getParameter("pass");
        String userid = req.getParameter("userid");
        String branch=req.getParameter("department");
        String filePath = SAVE_DIR+"/"+newfilename;
        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                new Object[]{filename, path});
       /*  InputStream input=null;
        Part filepart=req.getPart("file");
        if(filepart!=null){
            System.out.println(filepart.getName());
            System.out.println(filepart.getSize());
            System.out.println(filepart.getContentType());
            input=filepart.getInputStream();
        }*/
        Validation v=new Validation();
        boolean status=v.email_Validation(email);
        boolean stat=v.mobileno_Validation(pass);
        if(status==true)
  {  
  if(stat=true)
  {
      if(phno.length()<10||phno.length()>10)
            {
              resp.sendRedirect("alertregister.jsp");
            }
      else
      {
           registerteacherdao r =new registerteacherdao(name, email, phno, pass,userid,branch,filePath,filename);
        registerteachersql rc = new registerteachersql();
        int i = rc.registerteacher(r);
        if (i>=0) {
           resp.sendRedirect("login.jsp");
        } else {
            resp.sendRedirect("registerteacher.jsp");
        }
    }
  }
    }
        else{
           resp.sendRedirect("alertregister.jsp");
        }
    }
    catch(Exception e){
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
