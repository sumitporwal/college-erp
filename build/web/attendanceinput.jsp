<%-- 
    Document   : attendanceinput
    Created on : 14 Apr, 2020, 8:38:43 AM
    Author     : Windows
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
             if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("loginteacher.jsp");
            }
            String clas=request.getParameter("class");
            String sql="select name from register where class=?";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,clas);
            ResultSet rs=ps.executeQuery();
                    %> 
   
        <form action="" action="">
            Class<input type="text" name="class" required="required"><br><br>
            <input type="submit" value="save">
        </form><br><br><br>
                     <center>
          <form method="post" action="attendanceinputservlet"> 
              Subjectid<input type="text" name="subjectid" required="required"><br><br>
              Subject&nbsp&nbsp<input type="text" name="subject" required="required"><br><br>
        <table border="1" width="60%" align="center">
            <tr>
                <th>Student name</th>
                <th>Attendance</th>
                <th>Total</th>
                 </tr>
                  <% while(rs.next()){%>
            <tr>
                
                <td><%=rs.getString(1)%></td>
                <td><input type="text" name="attendance" required="required" size="45"></td>
                <td><input type="text" name="total" required="required" size="45"></td>
            </tr>
             <%}%>
            </table>
            <input type="submit" value="save">
            <input type="submit" value="back" onclick="location.href='welcome.jsp'">
        </form>
              </center>
  
    </body>
</html>
