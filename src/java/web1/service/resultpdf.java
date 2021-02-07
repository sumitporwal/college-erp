/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web1.service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "resultpdf", urlPatterns = {"/resultpdf"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class resultpdf extends HttpServlet {
  private static final String SAVE_DIR = "Result";
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
        HttpSession session=request.getSession();
        final String path = request.getServletContext().getRealPath("");
        String savePath = path + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
           try{
        List<String> fname=new ArrayList<String>();
        List<String> user=new ArrayList<String>();
        List<String> semester=new ArrayList<String>();
        String url="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,"root","root");
        PreparedStatement ps=con.prepareStatement("select * from register");
        ResultSet rs=ps.executeQuery();        
        while(rs.next()){
        Document document=new Document(PageSize.A4);
        String imgpath=request.getServletContext().getRealPath("")+File.separator;
        int credit_earned=0;
        String sgpa=""; 
        String cgpa="";
        String userid=rs.getString(6);
        user.add(rs.getString(6));
        String filename=String.valueOf(rs.getString(6))+"_"+rs.getString(9)+".pdf";
        fname.add(String.valueOf(rs.getString(6))+"_"+rs.getString(9)+".pdf");
        String filepath=savePath+File.separator+filename;
        String sem=rs.getString(9);
        semester.add(rs.getString(9));
        imgpath=imgpath+rs.getString(11);
        PdfWriter.getInstance(document,new FileOutputStream(filepath));
        document.open();
        Rectangle rect= new Rectangle(560,825,35,15); // you can resize rectangle 
        rect.enableBorderSide(1);
        rect.enableBorderSide(2);
        rect.enableBorderSide(4);
        rect.enableBorderSide(8);
        rect.setBorderColor(BaseColor.BLACK);
        rect.setBorderWidth(2);
        document.add(rect);
        Image image1 = Image.getInstance("https://images.static-collegedunia.com/public/college_data/images/logos/1469009421418_logo.jpg");
        image1.scaleToFit(100, 100);
        image1.setAbsolutePosition(50f, 700f);
        document.add(image1);
        Font f=new Font();
        f.setStyle(Font.BOLD);
        f.setSize(20);
        Paragraph para=new Paragraph("Medi-Caps University,Indore",f);
        para.setAlignment(Element.ALIGN_CENTER);
        para.setIndentationLeft(75f);
        document.add(para);
        document.add(Chunk.NEWLINE);
        Font f1=new Font();
        f1.setStyle(Font.BOLD);
        f1.setSize(14);
        if(Integer.parseInt(sem.substring(0,1))%2==0){
        Paragraph para1=new Paragraph("GRADE CARD-EVEN SEMESTER",f1);
        para1.setAlignment(Element.ALIGN_CENTER);
        para1.setIndentationLeft(75f);
        document.add(para1);
        }
        else if(Integer.parseInt(sem.substring(0,1))%2==1){
        Paragraph para1=new Paragraph("GRADE CARD-ODD SEMESTER",f1);
        para1.setAlignment(Element.ALIGN_CENTER);
        para1.setIndentationLeft(70f);
        document.add(para1);
        }
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
        PdfPTable table=new PdfPTable(2);
        table.setSpacingAfter(2f);
        table.setHorizontalAlignment((Element.ALIGN_LEFT));
        table.getDefaultCell().setFixedHeight(25f);
        PdfPCell cell = new PdfPCell();
        for(int j=0;j<=0;j++){
        table.addCell("Name");
        table.addCell("Scholar_no");
        table.setHeaderRows(1);
        table.setSkipFirstHeader(true);
        String u="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection(u,"root","root");
        PreparedStatement pre=c.prepareStatement("select * from register where userid='"+userid+"'");
        ResultSet r=pre.executeQuery();      
            while(r.next()){
                table.addCell("Name");
                table.addCell(r.getString(2).toUpperCase());
                table.addCell("Enrollment No.");
                table.addCell(r.getString(6).toUpperCase());
                table.addCell("Stream");
                table.addCell(r.getString(7));
                table.addCell("Branch");
                table.addCell(r.getString(8).toUpperCase());
            }
        }
        table.setWidthPercentage(70);
        document.add(table);
        Image image = Image.getInstance(imgpath);
        image.scaleToFit(150, 90);
        image.setAbsolutePosition(420f, 585f);
        document.add(image);
        float[] columnWidths = {100,200,70,70};
        PdfPTable table1=new PdfPTable(columnWidths);
        table1.getDefaultCell().setFixedHeight(20f);
        table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
        table1.addCell(new Phrase("Course Code",boldFont));
        table1.addCell(new Phrase("Course Name",boldFont));
        table1.addCell(new Phrase("Course Credit",boldFont));
        table1.addCell(new Phrase("Grade",boldFont));
        table1.setHeaderRows(1);
        PdfPCell[] cells=table1.getRow(0).getCells();
        cells[0].setFixedHeight(50f);
        for(int j=0;j<=0;j++){
        String u="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection(u,"root","root");
        PreparedStatement pre=c.prepareStatement("select course_code,course_name,credit,grade,sgpa,cgpa from result left join register on register.sem=result.sem and register.userid=result.userid where register.userid='"+userid+"'");
        ResultSet result=pre.executeQuery(); 
            while(result.next()){
                table1.addCell(new Phrase(result.getString(1).toUpperCase(),normalFont));
                table1.addCell(new Phrase(result.getString(2).toUpperCase(),normalFont));
                table1.addCell(new Phrase(result.getString(3).toUpperCase(),normalFont));
                table1.addCell(new Phrase(result.getString(4).toUpperCase(),normalFont));
                sgpa=result.getString(5);
                cgpa=result.getString(6);
                if(result.getString(4).equalsIgnoreCase("fail")){
                    
                }
                else{
                    credit_earned= credit_earned+Integer.parseInt(result.getString(3));
                }
            }
        }
        table1.setWidthPercentage(99);
        table1.setSpacingAfter(2f);
        document.add(table1);
        float[] col = {200,80,150,80};
        PdfPTable table2=new PdfPTable(col);
        table2.getDefaultCell().setFixedHeight(30f);
        int total_credit_earned=0;
        String un="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(un,"root","root");
        PreparedStatement pr=conn.prepareStatement("select credit,grade,sgpa,cgpa from result where userid='"+userid+"'");
        ResultSet res=pr.executeQuery();
        while(res.next()){
            if(res.getString(2).equalsIgnoreCase("fail")){
                    
                }
            else{
                total_credit_earned=total_credit_earned+Integer.parseInt(res.getString(1));
                }
        }
        PdfPCell c1 = new PdfPCell(new Phrase("Current Semester Performance",boldFont));
        c1.setColspan(2);
        c1.setFixedHeight(30f);
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase("Cumulative Performance",boldFont));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        c2.setFixedHeight(30f);
        c2.setColspan(2);
        table2.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("Credit Earned",boldFont));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        c3.setFixedHeight(30f);
        table2.addCell(c3);
        PdfPCell c4 = new PdfPCell(new Phrase("SGPA",boldFont));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        c4.setFixedHeight(30f);
        table2.addCell(c4);
        PdfPCell c5 = new PdfPCell(new Phrase("Total Credit Earned",boldFont));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        c5.setFixedHeight(30f);
        table2.addCell(c5);
        PdfPCell c6 = new PdfPCell(new Phrase("CGPA",boldFont));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        c6.setFixedHeight(30f);
        table2.addCell(c6);
        PdfPCell c7 = new PdfPCell(new Phrase(String.valueOf(credit_earned),boldFont));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        c7.setFixedHeight(30f);
        table2.addCell(c7);
        PdfPCell c8 = new PdfPCell(new Phrase(sgpa,boldFont));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        c8.setFixedHeight(30f);
        table2.addCell(c8);
        PdfPCell c9 = new PdfPCell(new Phrase(String.valueOf(total_credit_earned),boldFont));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        c9.setFixedHeight(30f);
        table2.addCell(c9);
        PdfPCell c10 = new PdfPCell(new Phrase(cgpa,boldFont));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        c10.setFixedHeight(30f);
        table2.addCell(c10);
        table2.setHeaderRows(1);
        table2.setWidthPercentage(99);
        document.add(table2);
        document.close();
        }
        String sq="insert into resultpdf values(?,?,?)";
        String ur="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection co=DriverManager.getConnection(ur,"root","root");
        PreparedStatement p=co.prepareStatement(sq);
        co.setAutoCommit(false);
        for(int i=0;i<user.size();i++){
        p.setString(1, user.get(i));
        p.setString(2,semester.get(i));
        p.setString(3,SAVE_DIR+"/"+fname.get(i));
        p.addBatch();
        }
        response.sendRedirect("welcomeadmin.jsp");
        p.executeBatch();
        co.commit();
        }catch(Exception e){
            e.printStackTrace();
        }
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
       /* HttpSession session=request.getSession();
        final String path = request.getServletContext().getRealPath("");
        String savePath = path + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
           try{
        String sq="insert into resultpdf values(?,?,?)";
        String ur="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection co=DriverManager.getConnection(ur,"root","root");
        PreparedStatement p=co.prepareStatement(sq);
        String url="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,"root","root");
        PreparedStatement ps=con.prepareStatement("select * from register");
        ResultSet rs=ps.executeQuery();        
        Document document=new Document(PageSize.A4);
        String imgpath=request.getServletContext().getRealPath("")+File.separator;
        int credit_earned=0;
        while(rs.next()){
        String sgpa=""; 
        String cgpa="";
        String userid=rs.getString(6);
        String filename=String.valueOf(rs.getString(6))+"_"+rs.getString(9)+".pdf";
        String filepath=savePath+File.separator+filename;
        String sem=rs.getString(9);
        imgpath=imgpath+rs.getString(11);
        PdfWriter.getInstance(document,new FileOutputStream(filepath));
        document.open();
        Rectangle rect= new Rectangle(560,825,35,15); // you can resize rectangle 
        rect.enableBorderSide(1);
        rect.enableBorderSide(2);
        rect.enableBorderSide(4);
        rect.enableBorderSide(8);
        rect.setBorderColor(BaseColor.BLACK);
        rect.setBorderWidth(2);
        document.add(rect);
        Image image1 = Image.getInstance("https://images.static-collegedunia.com/public/college_data/images/logos/1469009421418_logo.jpg");
        image1.scaleToFit(100, 100);
        image1.setAbsolutePosition(50f, 700f);
        document.add(image1);
        Font f=new Font();
        f.setStyle(Font.BOLD);
        f.setSize(20);
        Paragraph para=new Paragraph("Medi-Caps University,Indore",f);
        para.setAlignment(Element.ALIGN_CENTER);
        para.setIndentationLeft(75f);
        document.add(para);
        document.add(Chunk.NEWLINE);
        Font f1=new Font();
        f1.setStyle(Font.BOLD);
        f1.setSize(14);
        if(Integer.parseInt(sem.substring(0,1))%2==0){
        Paragraph para1=new Paragraph("GRADE CARD-EVEN SEMESTER",f1);
        para1.setAlignment(Element.ALIGN_CENTER);
        para1.setIndentationLeft(75f);
        document.add(para1);
        }
        else if(Integer.parseInt(sem.substring(0,1))%2==1){
        Paragraph para1=new Paragraph("GRADE CARD-ODD SEMESTER",f1);
        para1.setAlignment(Element.ALIGN_CENTER);
        para1.setIndentationLeft(70f);
        document.add(para1);
        }
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(new LineSeparator());
        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
        Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
        PdfPTable table=new PdfPTable(2);
        table.setSpacingAfter(2f);
        table.setHorizontalAlignment((Element.ALIGN_LEFT));
        table.getDefaultCell().setFixedHeight(25f);
        PdfPCell cell = new PdfPCell();
        for(int j=0;j<=0;j++){
        table.addCell("Name");
        table.addCell("Scholar_no");
        table.setHeaderRows(1);
        table.setSkipFirstHeader(true);
        String u="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection(u,"root","root");
        PreparedStatement pre=c.prepareStatement("select * from register where userid='"+userid+"'");
        ResultSet r=pre.executeQuery();      
            while(r.next()){
                table.addCell("Name");
                table.addCell(r.getString(2).toUpperCase());
                table.addCell("Enrollment No.");
                table.addCell(r.getString(6).toUpperCase());
                table.addCell("Stream");
                table.addCell(r.getString(7));
                table.addCell("Branch");
                table.addCell(r.getString(8).toUpperCase());
            }
        }
        table.setWidthPercentage(70);
        document.add(table);
        Image image = Image.getInstance(imgpath);
        image.scaleToFit(150, 90);
        image.setAbsolutePosition(420f, 585f);
        document.add(image);
        float[] columnWidths = {100,200,70,70};
        PdfPTable table1=new PdfPTable(columnWidths);
        table1.getDefaultCell().setFixedHeight(20f);
        table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);
        table1.addCell(new Phrase("Course Code",boldFont));
        table1.addCell(new Phrase("Course Name",boldFont));
        table1.addCell(new Phrase("Course Credit",boldFont));
        table1.addCell(new Phrase("Grade",boldFont));
        table1.setHeaderRows(1);
        PdfPCell[] cells=table1.getRow(0).getCells();
        cells[0].setFixedHeight(50f);
        for(int j=0;j<=0;j++){
        String u="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection c=DriverManager.getConnection(u,"root","root");
        PreparedStatement pre=c.prepareStatement("select course_code,course_name,credit,grade,sgpa,cgpa from result left join register on register.sem=result.sem where register.userid='"+userid+"'");
        ResultSet result=pre.executeQuery(); 
            while(result.next()){
                table1.addCell(new Phrase(result.getString(1).toUpperCase(),normalFont));
                table1.addCell(new Phrase(result.getString(2).toUpperCase(),normalFont));
                table1.addCell(new Phrase(result.getString(3).toUpperCase(),normalFont));
                table1.addCell(new Phrase(result.getString(4).toUpperCase(),normalFont));
                sgpa=sgpa+result.getString(5);
                cgpa=result.getString(6);
                if(result.getString(4).equalsIgnoreCase("fail")){
                    
                }
                else{
                    credit_earned= credit_earned+Integer.parseInt(result.getString(3));
                }
            }
        }
        table1.setWidthPercentage(99);
        table1.setSpacingAfter(2f);
        document.add(table1);
        float[] col = {200,80,150,80};
        PdfPTable table2=new PdfPTable(col);
        table2.getDefaultCell().setFixedHeight(30f);
        int total_credit_earned=0;
        String un="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(un,"root","root");
        PreparedStatement pr=conn.prepareStatement("select credit,grade,sgpa,cgpa from result where userid='"+userid+"'");
        ResultSet res=pr.executeQuery();
        while(res.next()){
            if(res.getString(2).equalsIgnoreCase("fail")){
                    
                }
            else{
                total_credit_earned=total_credit_earned+Integer.parseInt(res.getString(1));
                }
        }
        PdfPCell c1 = new PdfPCell(new Phrase("Current Semester Performance",boldFont));
        c1.setColspan(2);
        c1.setFixedHeight(30f);
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase("Cumulative Performance",boldFont));
        c2.setHorizontalAlignment(Element.ALIGN_CENTER);
        c2.setFixedHeight(30f);
        c2.setColspan(2);
        table2.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("Credit Earned",boldFont));
        c3.setHorizontalAlignment(Element.ALIGN_CENTER);
        c3.setFixedHeight(30f);
        table2.addCell(c3);
        PdfPCell c4 = new PdfPCell(new Phrase("SGPA",boldFont));
        c4.setHorizontalAlignment(Element.ALIGN_CENTER);
        c4.setFixedHeight(30f);
        table2.addCell(c4);
        PdfPCell c5 = new PdfPCell(new Phrase("Total Credit Earned",boldFont));
        c5.setHorizontalAlignment(Element.ALIGN_CENTER);
        c5.setFixedHeight(30f);
        table2.addCell(c5);
        PdfPCell c6 = new PdfPCell(new Phrase("CGPA",boldFont));
        c6.setHorizontalAlignment(Element.ALIGN_CENTER);
        c6.setFixedHeight(30f);
        table2.addCell(c6);
        PdfPCell c7 = new PdfPCell(new Phrase(String.valueOf(credit_earned),boldFont));
        c7.setHorizontalAlignment(Element.ALIGN_CENTER);
        c7.setFixedHeight(30f);
        table2.addCell(c7);
        PdfPCell c8 = new PdfPCell(new Phrase(sgpa,boldFont));
        c8.setHorizontalAlignment(Element.ALIGN_CENTER);
        c8.setFixedHeight(30f);
        table2.addCell(c8);
        PdfPCell c9 = new PdfPCell(new Phrase(String.valueOf(total_credit_earned),boldFont));
        c9.setHorizontalAlignment(Element.ALIGN_CENTER);
        c9.setFixedHeight(30f);
        table2.addCell(c9);
        PdfPCell c10 = new PdfPCell(new Phrase(cgpa,boldFont));
        c10.setHorizontalAlignment(Element.ALIGN_CENTER);
        c10.setFixedHeight(30f);
        table2.addCell(c10);
        table2.setHeaderRows(1);
        table2.setWidthPercentage(99);
        document.add(table2);
        document.close();
        response.sendRedirect("welcomeadmin.jsp");
        co.setAutoCommit(false);
        p.setString(1, userid);
        p.setString(2,sem);
        p.setString(3,SAVE_DIR+"/"+filename);
        p.addBatch();
        }
        response.sendRedirect("welcomeadmin.jsp");
        p.executeBatch();
        co.commit();
        }catch(Exception e){
            e.printStackTrace();
        }*/
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
