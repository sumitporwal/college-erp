<%-- 
    Document   : setpassword
    Created on : 2 Apr, 2020, 5:44:18 PM
    Author     : Windows
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set Password</title>
    </head>
      <body>
          <%
         if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
         try{
          String pass=request.getParameter("setpass");
          String sql="update register set password=? where userid='"+session.getAttribute("userid")+"'";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,pass);
           int result=ps.executeUpdate();
            if(result>=0)
            {
                response.sendRedirect("login.jsp");
            }
            else{
                response.sendRedirect("setpassword.jsp");
            }
         }catch(Exception e){
             e.printStackTrace();
         }
        %> 
         
         <h1>Set New Password</h1>
        <form action=" " method="">
            new password:<input type="password" name="setpass" required="required"><br><br>
        <input type="submit" value="submit">
        <input type="submit" value="back" onclick="location.href='login.jsp'">
        </form>
        </body>
        
</html>
