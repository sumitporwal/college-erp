<%-- 
    Document   : attendance
    Created on : 20 Feb, 2020, 11:16:45 PM
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
        <title>attendance</title>
    </head>
    <body>
        <%
            if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
                    
          
            String sql="select subjectid,subject,sum(attendance),sum(total),avg(percent) from attendance where userid1='"+session.getAttribute("userid")+"' group by subjectid";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
        %><center>
          <form method="" action="">
        <table border="1" width="800" align="center">
            <tr>
                <th>subject id</th>
                <th>subject name</th>
                <th>attendance</th>
                <th>total</th>
                <th>percentage</th>
            </tr>
            <tr>
                
             <% while(rs.next()){%>
            <tr>
                <td><%=rs.getString(1)%></td>
                 <td><%=rs.getString(2)%></td>
                 <td><%=rs.getInt(3)%></td>
                 <td><%=rs.getInt(4)%></td>
                 <td><%=rs.getDouble(5)%></td>    
            </tr>
              <%}%>
        </table><br>
            <input type="button" value="back" onclick="location.href='welcomestudent.jsp'">
        </form>
    </center>
    </body>
</html>
