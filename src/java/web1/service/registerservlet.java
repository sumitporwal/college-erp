/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import web1.dao.registerdao;
import web1.model.registersql;

/**
 *
 * @author Windows
 */
@WebServlet(name = "registerservlet", urlPatterns = {"/registerservlet"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class registerservlet extends HttpServlet {
private static final String SAVE_DIR = "Student_Images";

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
     */ public class Validation{
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
           public boolean userid_Validation(String userid)
 {
     boolean st=false;
      String pattern = "^(?)(EN|BC|ME|BBA|MBA|PH|BCA|MCA|MC)[0-9]{2}[A-Za-z]{2}[0-9]{6}$";  
      Pattern pat=Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
      Matcher match=pat.matcher(userid);
      if(match.matches()){
          st=true;
          }
      else{
          st=false;
      }
      return st;
 }
          /* public String sem(){
               String pattern = "^(?)(EN|BC|ME|BBA|MBA|PH|BCA|MCA|MC)[0-9]{2}[A-Za-z]{2}[0-9]{6}$";            
               Calendar cal=Calendar.getInstance();
               int year=(cal.get(Calendar.YEAR))-Integer.parseInt(pattern.substring(pattern.length()-10,pattern.length()-8));
               int sem=0;
               String se="";
               int month=(cal.get(Calendar.MONTH));
               if(month>=1 && month<=6){
                 sem=(year*2)-1;
               }
               else if(month>=7 && month<=12){
                   sem=year*2;
               }
               if(sem==1){
                   se=se+String.valueOf(year)+"st-sem";
               }
               else if(sem==3){
                   se=se+String.valueOf(year)+"rd-sem";
               }
               else if(sem==2 || sem==4 || sem==5 || sem==6 || sem==7 || sem==8){
                   se=se+String.valueOf(sem)+"nd-sem";
               }
               System.out.println(year);
               return se;
           }*/
           
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
        final String filename=getFileName(filePart);
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
        String stream=req.getParameter("stream");
        String branch=req.getParameter("branch");
        String clas=req.getParameter("clas");
        Calendar cal=Calendar.getInstance();
        String filePath = SAVE_DIR+"/"+newfilename;
        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                new Object[]{filename, path});
        
         /*InputStream input=null;
        Part filepart=req.getPart("file");
        if(filepart!=null){
            System.out.println(filepart.getName());
            System.out.println(filepart.getSize());
            System.out.println(filepart.getContentType());
            input=filepart.getInputStream();
        }*/
        Validation v=new Validation();
        boolean status=v.email_Validation(email);
        boolean stat=v.mobileno_Validation(phno);
        boolean st=v.userid_Validation(userid);
        //String sem=v.sem();
        if(status==true)
  {  
       if(st==true){
           int year=(cal.get(Calendar.YEAR))-Integer.parseInt("20"+userid.substring(userid.length()-10,userid.length()-8));
               int se=0;
               String sem="";
               int month=(cal.get(Calendar.MONTH));
               if(month>=0 && month<=5){
                 se=(year*2);
               }
               else if(month>=6 && month<=11){
                   se=(year*2)+1;
               }
            switch (se) {
                case 1:
                    sem=sem+String.valueOf(se)+"st-sem";
                    break;
                case 3:
                    sem=sem+String.valueOf(se)+"rd-sem";
                    break;
                case 2:
                     sem=sem+String.valueOf(se)+"nd-sem";
                    break;
                case 4:
                     sem=sem+String.valueOf(se)+"th-sem";
                    break;
                case 5:
                     sem=sem+String.valueOf(se)+"th-sem";
                    break;
                case 6:
                     sem=sem+String.valueOf(se)+"th-sem";
                    break;
                case 7:
                     sem=sem+String.valueOf(se)+"th-sem";
                    break;
                case 8:
                    sem=sem+String.valueOf(se)+"th-sem";
                    break;
                default:
                    break;
            }
  if(stat==true)
  {
      if(phno.length()<10||phno.length()>10)
            {
              resp.sendRedirect("alertregister.jsp");
            }
      else
      {
        registerdao r =new registerdao(name, email, phno, pass,userid,stream,branch,sem,clas,filePath,filename);
        registersql rc = new registersql();
        int i = rc.register(r);
        if (i>=0) {
           resp.sendRedirect("login.jsp");
        } else {
            resp.sendRedirect("register.jsp");
        }
    }
      }
  }
        else{
           resp.sendRedirect("alertregister.jsp");
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
