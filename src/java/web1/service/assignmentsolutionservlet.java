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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Windows
 */
@WebServlet(name = "assignmentsolutionservlet", urlPatterns = {"/assignmentsolutionservlet"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class assignmentsolutionservlet extends HttpServlet {
private static final String SAVE_DIR = "Assignment_Solution";
     private final static Logger LOGGER = 
            Logger.getLogger(assignmentservlet.class.getCanonicalName());
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
    private String getFileName(final Part part) {
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session=request.getSession();
    final String path = request.getServletContext().getRealPath("");
    String savePath = path + File.separator + SAVE_DIR;
    File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        final Part filePart=request.getPart("file");
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
     int ID=Integer.valueOf(request.getParameter("id"));
     Connection co=Mysql.MySqlConnection.getconnection();
     PreparedStatement p=co.prepareStatement("select assignment_id,assignment.course_code,assignment.course_name,upload_date,submission_date,teacher_name,assignmentfile,filename from assignment where assignment_id='"+ID+"'");
     ResultSet rs=p.executeQuery();
        final PrintWriter writer = response.getWriter();
        writer.println("New file " + filename + " created at " + savePath);
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        String filePath = SAVE_DIR+"/"+newfilename;
        while(rs.next()){
        Connection con=Mysql.MySqlConnection.getconnection();
        PreparedStatement ps=con.prepareStatement("insert into assignmentsolution values(?,?,?,?,?,?)");
        ps.setString(1,rs.getString(6));
        ps.setInt(2,rs.getInt(1));
        ps.setString(3,String.valueOf(session.getAttribute("userid")));
        ps.setString(4,formatter.format(date));
        ps.setString(5,filePath);
        ps.setString(6,filename);
        ps.executeUpdate();
        }
        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
                new Object[]{filename, path});
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
