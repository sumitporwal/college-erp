<%-- 
    Document   : forgotpassword
    Created on : 2 Apr, 2020, 5:45:48 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
       <center>
        <h1>Change Password</h1>
        <form action="forgotpasswordservlet" method="post">
            Email:<input type="email" name="to" size="30" required="required">
            <input type="submit" value="Confirm">
        </form>
    </center>
    </body>
</html>
