<%-- 
    Document   : welcomeadmin
    Created on : 9 Jul, 2020, 3:15:24 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width ,initial-scale=1">
        <link href='css/welcome.css' type="text/css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(session.getAttribute("admin_userid")==null){
          response.sendRedirect("loginadmin.jsp");
        }
        %>
       
        <a href="updatesem.jsp">update sem</a>
        <a href="subject.jsp">Add New Subject</a>
        <a href="editteacherrecord.jsp">Edit Teacher Record</a>
        <a href="editstudentrecord.jsp">Edit Student Record</a>
        <a href="studentrecord.jsp">Student Record</a>
        <a href="teacherrecord.jsp">Teacher Record</a>
        <a href="searchstudent.jsp">Search Student</a>
        <a href="searchteacher.jsp">Search Teacher</a>
        <a href="resultpdf">Upload Result</a>
    </body>
</html>
