<%-- 
    Document   : assignmentupload
    Created on : 28 May, 2020, 5:28:10 PM
    Author     : Windows
--%>

<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.InputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>hello</h1>
       <%
            if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("login.jsp");
            }   
        String subjectid=request.getParameter("subjectid");
        String subject=request.getParameter("subject");
        String date=request.getParameter("date");
        String clas=request.getParameter("class");
        String myloc=request.getParameter("assignment");
        java.io.File f=new java.io.File(myloc);
        java.io.FileInputStream fis=new java.io.FileInputStream(f);
        try{
       String url="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,"root","root");
        PreparedStatement ps=con.prepareStatement("insert into assignment values(default,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, subjectid);
        ps.setString(2, subject);
        ps.setString(3, date);
        ps.setString(4, clas);
        ps.setBinaryStream(5,fis,(int)f.length());   
        int i=ps.executeUpdate();
          ResultSet rs=ps.getGeneratedKeys();
          rs.next();
          if(i>=0){
              response.sendRedirect("assignment.jsp");
          }
        }catch(Exception e){
            e.printStackTrace();
        }
           %>
    </body>
</html>
