<%-- 
    Document   : welcome
    Created on : 2 Apr, 2020, 5:41:40 PM
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
        <style>
        table,td,th{
        border: solid 1px black;
        width: 60%;
        border-collapse: collapse;
        }
        .btn1{
            border-radius: 5px;
            background-color: dodgerblue;
        }
        /*#form2{
            display: none;
        }*/
        </style>
    </head>
    <body>
        <%
            int i=0;
             if(session.getAttribute("teacher_userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
             
            String stream=request.getParameter("stream");
            String branch=request.getParameter("branch");
            String sem=request.getParameter("sem");
            String clas=request.getParameter("class");
            String sql="select userid,name from register where stream=? and branch=? and sem=? and class=?";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,stream);
            ps.setString(2,branch);
            ps.setString(3,sem);
            ps.setString(4,clas);
            ResultSet rs=ps.executeQuery();
                    %> 

        <form  style="text-align:right" action="logoutservlet" method="post">
            <input class="btn1" type="button" value="change password" onclick="location.href='setpassword.jsp'">
            <input class="btn1" type="submit"  value="logout">
        </form>
         <h1>Welcome to our site</h1>
         <form action="" method="post" id="form1">
         <select name="stream" class="item" required="required">
                   <option class="item" disabled="" selected="">Select Stream</option>
                   <option class="item" value="B.Tech">B.Tech</option>
                   <option class="item" value="M.Tech">M.Tech</option>
                   <option class="item" value="BCA">BCA</option>
                   <option class="item" value="BBA">BBA</option>
                   <option class="item" value="MBA">MBA</option>
                   <option class="item" value="Pharmacy">PHARMACY</option>
         </select>
             <input class="item" type="text" name="branch" required="required" placeholder="Enter Branch">
            <select name="sem" class="item" id="select" required="required">
                   <option class="item" disabled="" selected="">Select Sem</option>
                   <option class="item" value="1st-Sem">1st-Sem</option>
                   <option class="item" value="2nd-Sem">2nd-Sem</option>
                   <option class="item" value="3rd-Sem">3rd-Sem</option>
                   <option class="item" value="4th-Sem">4th-Sem</option>
                   <option class="item" value="5th-Sem">5th-Sem</option>
                   <option class="item" value="6th-Sem">6th-Sem</option>
                   <option class="item" value="7th-Sem">7th-Sem</option>
                   <option class="item" value="8th-Sem">8th-Sem</option>
               </select>
            <input class="item" type="text" name="class" required="required" placeholder="Enter Class">
            <input id="btn1" type="submit" value="Search">
        </form><br><br><br>
    <center>
        
        <form  action="attendance1.jsp" method="post" id="form2">
            Subjectid<input type="text" name="subjectid" required="required"><br><br>
            Subject&nbsp&nbsp<input type="text" name="subject" required="required"><br><br>
            date&nbsp&nbsp&nbsp&nbsp&nbsp<input type="datetime-local" name="date" required="required"><br><br>
              <table>
            <tr>
                <th>Enrollment No.</th>
                <th>Student name</th>
                <th>Attended</th>
                 </tr>
                 
                  <%while(rs.next()){%>
            <tr>
                <td><input type="text" name="enroll" value="<%=rs.getString(1)%>" size="33%"></td>
                <td><input type="text" name="name" value="<%=rs.getString(2)%>" size="34%"></td>
                <td><input type="text" name="attendance" required="required" size="33%"></td>
                         </tr>
             <%i++;}%>
             
            </table>
            <input type="submit" value="save">
        </form>
       </center>
<script>
    document.getElementById("form1").addEventListener('submit',function(){
    document.getElementById("form2").style.display="initial"; 
    });
</script>
    </body>
</html>
