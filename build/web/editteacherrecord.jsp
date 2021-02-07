<%-- 
    Document   : editteacherrecord
    Created on : 26 Jun, 2020, 7:41:52 PM
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
       <title>Edit Teacher Record</title>
         <meta name="viewport" content="width=device-width,initial-scale=1">
         <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
         <style>
             body{
                 background-color: lightgoldenrodyellow;
             }
             #div1{
                 margin-top: 30px;
             }
             .glyphicon-search{
                 margin: 10px;
                 margin-left: 5%;
                 font-size: 15px;
                 text-decoration: none;
             }
             #div2{
                 background-color: lightgrey;
                 width: 100%;
                 height: 30px;
             }
             .glyphicon-off{
                 margin: 10px;
                 font-size: 15px;
                 color: yellow;
                 position: absolute;
                 right: 10px;
                 text-decoration: none;
             }
             .glyphicon-home{
                 margin: 10px;
                 font-size: 15px;
                 color: white;
                 position: absolute;
                 right: 40px;
                 text-decoration: none;
             }
             table{
                 border:1px;
                 width:100%;
                 text-align:center;
                 
             }
                 th{
             background-color: slategrey;
             color: white;
             height: 60px;
             font-size: 20px;
             text-align: center;
                 } 
                 #btn1{
                     background-color: turquoise;
                     border-radius: 5px;
                 }
                 td{
                     background-color: white;
                     color: black;
                     height: 30px;
                     font-size: 15px;
                     text-align: center;
                 }
                 .input1{
                     text-align: center;
                     width: 100%;
                 }
                 #btn2{
                     position: absolute;
                     top:22%;
                     right: 5%;
                     background-color: royalblue;
                     width: 5%;
                     color: white;
                     border-radius: 10px;
                 }
                 .input2{
                     cursor: not-allowed;
                 }
         </style>
    </head>
    <body>
        <%
         if(session.getAttribute("admin_userid")==null)
            {
                response.sendRedirect("loginadmin.jsp");
            }
            String enrollment=request.getParameter("userid");
            String sql="select scholar_no,name,email,phno,password,userid,department from registerteacher where userid=?";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,enrollment);
            ResultSet rs=ps.executeQuery();
            %>
            <div id="div2">
                <span><a class="glyphicon glyphicon-home" href="welcomeadmin.jsp"></a></span>
                <span><a class="glyphicon glyphicon-off" href="logoutadminservlet"></a></span>
    </div>
    <center>
        <h2 style="margin-top:3%;">Edit Teacher Record</h2>
    </center>
            <form action="" method="post">
                <div id="div1">
                    <span><a class="glyphicon glyphicon-search" href="#"></a></span>
                    <span><input type="text" name="userid" placeholder="User ID"></span>
                    <span><input id="btn1" type="submit" name='search' value='Search'></span></br></br>
                </div>
            </form>
            <form action="editteacher.jsp" method="post">
                <input type="submit" value="Save" id="btn2">
            <table>
                <tr>
                    <th>Scholar_NO.</th>
                    <th>Student Name</th>
                    <th>Email</th>
                    <th>Mobile NO.</th>
                    <th>Password</th>
                    <th>User Id</th>
                    <th>Department</th>
                </tr>
                <% while(rs.next()){%>
                <tr>
                    <td><input class="input1 input2" type="text" name="scholar" value="<%=rs.getInt(1)%>"></td>
                   <td><input class="input1" type="text" name="name" value="<%=rs.getString(2)%>"></td>
                   <td><input class="input1" type="text" name="email" value="<%=rs.getString(3)%>"></td>
                   <td><input class="input1" type="text" name="phno" value="<%=rs.getString(4)%>"></td>
                   <td><input class="input1" type="text" name="password" value="<%=rs.getString(5)%>"></td>
                   <td><input class="input1 input2" type="text" name="enrollment" value="<%=rs.getString(6)%>"></td>
                   <td><input class="input1" type="text" name="stream" value="<%=rs.getString(7)%>"></td> 
                </tr>
                 <%}%>
            </table>
            </form>
    </body>
</html>
