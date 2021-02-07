<%-- 
    Document   : editstudent
    Created on : 26 Jun, 2020, 10:49:31 PM
    Author     : Windows
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title></title>
    </head>
    <body>
        <%
         if(session.getAttribute("admin_userid")==null)
            {
                response.sendRedirect("loginadmin.jsp");
            }
         try{
             //int scholar=Integer.parseInt(request.getParameter("scholar"));
             String name=request.getParameter("name");
             String email=request.getParameter("email");
             String phno=request.getParameter("phno");
             String password=request.getParameter("password");
             String userid=request.getParameter("enrollment");
             String stream=request.getParameter("stream");
             String branch=request.getParameter("branch");
             String sem=request.getParameter("sem");
             String clas=request.getParameter("class");
          String sql="update register set name='"+name+"',email='"+email+"',phno='"+phno+"',password='"+password+"',stream='"+stream+"',branch='"+branch+"',sem='"+sem+"',class='"+clas+"' where userid=?";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, userid);
            ps.executeUpdate();
           response.sendRedirect("editstudentrecord.jsp");
         }catch(Exception e){
             e.printStackTrace();
         }
        %>
    </body>
</html>
