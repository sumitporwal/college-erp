<%-- 
    Document   : assignment
    Created on : 27 May, 2020, 10:51:32 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment</title>
    </head>
    <body>
     <%
     if(session.getAttribute("teacher_userid")==null){
      response.sendRedirect("login.jsp");
     }
     %>   
    <center>
        <h1>Upload Assignmet</h1>
        <form action="assignmentservlet" enctype="multipart/form-data" method="post">
            <label>Stream:</label><input type="text" name="stream"></br></br>
            <label>Branch:</label><input type="text" name="branch"></br></br>
            <label>Course Code:</label><input type="text" name="subjectid"></br></br>
            <label>Course Name:</label><input type="text" name="subject"></br></br>
            <label>Submission Date:</label><input type="date" name="date"></br></br>
           <input type="file" name="file"></br></br>
           <input type="submit" value="upload">
        </form>
    </center>
    </body>
</html>
