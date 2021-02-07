<%-- 
    Document   : subject
    Created on : 27 Jun, 2020, 11:58:14 PM
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
        <title>Add University Subjects</title>
         <meta name="viewport" content="width=device-width,initial-scale=1">
         <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <style>
            body{
                background-color: lightyellow;
            }
            #div1{
                margin-left: 10%;
                margin-top: 10%;
                margin-bottom: 3%;
            } 
            .input1{
                margin-right: 5%;
                width: 15%;
            }
            #div2{
                margin-left: 10%;
            }
            #div3{
                 background-color: lightgrey;
                 width: 100%;
                 height: 40px;
             }
             .glyphicon-off{
                 margin: 10px;
                 width: 15px;
                 height: 15px;
                 color: yellow;
                 position: absolute;
                 right: 10px;
                 text-decoration: none;
             }
             .glyphicon-home{
                 margin: 10px;
                 width: 15px;
                 height: 15px;
                 color: white;
                 position: absolute;
                 right: 40px;
                 text-decoration: none;
             }
            label{
                margin: 10px;
                font-size: 18px;
            }
            #btn{
               border-radius: 5px;
               margin-top: 25px;
               background-color: lightcyan;
               width: 70px;
               font-size: 18px;
               cursor: pointer;
            }
        </style>
    </head>
    <body>
        <%
         if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("loginadmin.jsp");
            }
         try{
            String code=request.getParameter("course code");
            String name=request.getParameter("course name");
            String credit=request.getParameter("credit");
            String stream=request.getParameter("stream");
            String branch=request.getParameter("branch");
            String sem=request.getParameter("sem");
            String sql="insert into subject values(?,?,?,?,?,?)";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,code);
            ps.setString(2,name);
            ps.setString(3,credit);
            ps.setString(4,stream);
            ps.setString(5,branch);
            ps.setString(6,sem);
            ps.executeUpdate();
         }catch(Exception e){
             e.printStackTrace();
         }
        %>
          <div id="div3">
                <span><a class="glyphicon glyphicon-home" href="welcomeadmin.jsp"></a></span>
                <span><a class="glyphicon glyphicon-off" href="logoutadminservlet"></a></span>
    </div>
         <form action="" method="post">
             <div id="div1">
                 <label>Course Code:</label><input type="text" name="course code" required="required" class="input1">
                     <label>Course Name:</label><input type="text" name="course name" required="required" class="input1">
                     <label>Credits:</label><input type="text" name="credit" required="required" class="input1"></br></br>
             </div>
             <div id="div2">
                     <label>Stream:</label><input type="text" name="stream" required="required" class="input1">
                     <label>Branch:</label><input type="text" name="branch" required="required" class="input1">
                     <label>Sem:</label><input type="text" name="sem" required="required" class="input1"></br></br>
             </div>
             <center><input id="btn" type="submit" name="submit" value="Add"></center>
    </form>
   
    </body>
</html>
