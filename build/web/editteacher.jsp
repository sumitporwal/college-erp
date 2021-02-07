<%-- 
    Document   : editteacher
    Created on : 27 Jun, 2020, 11:46:55 PM
    Author     : Windows
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
         if(session.getAttribute("admin_userid")==null)
            {
                response.sendRedirect("loginadmin.jsp");
            }
             //int scholar=Integer.parseInt(request.getParameter("scholar"));
             String name=request.getParameter("name");
             String email=request.getParameter("email");
             String phno=request.getParameter("phno");
             String password=request.getParameter("password");
             String userid=request.getParameter("enrollment");
             String department=request.getParameter("stream");
          String sql="update registerteacher set name='"+name+"',email='"+email+"',phno='"+phno+"',password='"+password+"',department='"+department+"' where userid=?";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,userid);
            ps.executeUpdate();
           response.sendRedirect("editteacherrecord.jsp");
        %>
    </body>
</html>
