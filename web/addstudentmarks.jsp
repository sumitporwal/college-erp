<%-- 
    Document   : addstudentmarks
    Created on : 1 Jul, 2020, 1:31:55 AM
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
        <title>Add Student Marks </title>
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <style>
            #input1{
                display: none;
            }
            #form1{
                display: initial;
            }
        </style>
    </head>
    <body>
       <!--<script src="marks.js"></script> -->
       <form action="" method="post">
            <input type="text" name="sem" placeholder="Enter Sem">
            <input type="text" name="enrollment" placeholder="Enter Enrollment NO.">
            <input id="btn1" type="submit" value="Search">
        </form>
        <%
        if(session.getAttribute("teacher_userid")==null){
            response.sendRedirect("login.jsp");
        }
          int n=0;
          int k=0;
        String sem=request.getParameter("sem");
        String enrollment=request.getParameter("enrollment");
        String s="select userid,sem from result where userid='"+enrollment+"' and sem='"+sem+"'";
         String u="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection(u,"root","root");
            PreparedStatement pre=c.prepareStatement(s);
            ResultSet result=pre.executeQuery();
            while(result.next()){
                k++;
            }
                if(k>=1){
                    response.sendRedirect("alertmarks.jsp");
                }
                else{
        String sql="select course_code,course_name,credit,userid from studentsubject left join register on register.userid=studentsubject.enrollment_no and register.sem=studentsubject.sem where register.sem=? and userid=?";
        String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,sem);
            ps.setString(2, enrollment);
            ResultSet rs=ps.executeQuery();
        %>
        <form action="calculategrade.jsp" method="post" id="form1">
        <table  border="1"  align="center">
            <tr>
                <th>Enrollment NO.</th>
                <%while(rs.next()){%>
                <th><input type="text" name="course_name" value="<%=rs.getString(2)%>"></br><input type="text" name="course_code" value="<%=rs.getString(1)%>"></th>
                <th id="input1"><input type="text" name="credit" value="<%=rs.getString(3)%>"></th>
                <%n++;}}%>
            </tr>
            <%
               String enroll=request.getParameter("enrollment");
               String sq="select credit,grade,cgpa from result where userid=?";
               String ur="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection co=DriverManager.getConnection(ur,"root","root");
            PreparedStatement p=co.prepareStatement(sq);
            p.setString(1, enroll);
            ResultSet r=p.executeQuery();
            %>
            <tr  id="input1">
            <%while(r.next()){%>
            <td><input type="text" value="<%=r.getString(1)%>" name="credits"></td>
            <td><input type="text" value="<%=r.getString(2)%>" name="grades"></td>
            <td><input type="text" value="<%=r.getString(3)%>" name="cgpa"></td>
            <%}%>
            </tr>
        <tr>
            <td><input type="text" name="userid" value="<%=request.getParameter("enrollment")%>"></td> 
             <%for(int i=0;i<n;i++){%>
            <td><input type="text" name="marks" required="required"></td>
           <%}%>
        </tr>
        </table>
        <input type="submit" value="Submit">
        </form>
            </body>
</html>
