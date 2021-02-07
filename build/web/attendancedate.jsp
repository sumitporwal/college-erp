<%-- 
    Document   : attendancedate
    Created on : 20 Apr, 2020, 10:58:13 AM
    Author     : Windows
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance</title>
    </head>
    <body>
        <%
            if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
                              

            String sql="select date,subjectid,subject,attended from attendance where userid1='"+session.getAttribute("userid")+"' order by date";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
        %><center>
        <form method="" action="">
        <table border="1" width="800" align="center">
            <tr>
                <th>Date</th>
                <th>subject id</th>
                <th>subject name</th>
                <th>attendance</th>
            </tr>
            <tr>
                
             <% while(rs.next()){%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                 <td><%=rs.getString(3)%></td>
                 <td><%=rs.getString(4)%></td>   
            </tr>
              <%}%>
        </table><br>
        
            <input type="button" value="back" onclick="location.href='welcomestudent.jsp'">
        </form>
    </center>
    </body>
</html>
