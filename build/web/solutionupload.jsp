<%-- 
    Document   : solutionupload
    Created on : 28 Jul, 2020, 11:18:57 PM
    Author     : Windows
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<@import "http://fonts.googleapis.com/css?family=Raleway"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width,initial-scale=1">
         <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <style>
            #abc {
width:100%;
height:100%;
opacity:.95;
top:0;
left:0;
position:fixed;
background-color:#313131;
overflow:auto
}
.glyphicon-remove-circle {
    position: absolute;
    right: 0px;
    top: -5px;
    font-size: 25px;
    color: red;
}
div#popupContact {
position:absolute;
left:50%;
top:13%;
margin-left:-202px;
font-family:'Raleway',sans-serif
}
form {
width: 100%;
max-width:500px;
min-width:250px;
padding:10px 50px;
border:2px solid gray;
border-radius:10px;
font-family:raleway;
background-color:#fff
}
input {
width:100%;
height: 30px;
margin-top:3px;
border:1px solid #ccc;
font-size:15px;
font-family:raleway
}
.div{
    margin-top: 20px;
    font-size: 18px;
}
#file{
    margin-top: 15px;
}
#btn{
    margin-top: 15px;
    background-color:#FFBC00;
}
        </style>
    </head>
    <body>
        <%
        if(session.getAttribute("userid")==null){
            response.sendRedirect("login.jsp");
        }
     int ID=Integer.valueOf(request.getParameter("id"));
     Connection co=Mysql.MySqlConnection.getconnection();
     PreparedStatement p=co.prepareStatement("select assignment_id,assignment.course_code,assignment.course_name,upload_date,submission_date,teacher_name,assignmentfile,filename from assignment where assignment_id='"+ID+"'");
     ResultSet rs=p.executeQuery();
        %>
    <div id="abc">
      <div id="popupContact">
        <form action="assignmentsolutionservlet" method="post" enctype="multipart/form-data">
            <a class="glyphicon glyphicon-remove-circle" href="studentassignmentupload.jsp"></a>
            <%while(rs.next()){%>
            <div class="div">SNO.</div>
            <input type='text' name='id' value='<%=rs.getInt(1)%>'>
            <div class="div">Course Code</div>
            <input type='text' name='course_code' value="<%=rs.getString(2)%>" disabled="disabled">
            <div class="div">Course Name</div>
            <input type='text' name='course_name' value="<%=rs.getString(3)%>" disabled="disabled">
            <div class="div">Upload Date</div>
            <input type='text' name='upload_date' value="<%=rs.getString(4)%>" disabled="disabled">
            <div class="div">Submission Date</div>
            <input type='text' name='submission_date' value="<%=rs.getString(5)%>" disabled="disabled">
            <input type='file' name='file' id="file">
            <input type="submit" value="Upload File" id="btn">
            <%}%>
        </form>
      </div>
    </div>
    </body>
</html>
