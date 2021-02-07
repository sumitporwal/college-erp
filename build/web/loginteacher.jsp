<%-- 
    Document   : loginstudent
    Created on : 15 Apr, 2020, 10:59:57 AM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <title>Login</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
    </head>
       <body id="body2">
        <div id="form2"> 
        <center>
            <h1 style="color: goldenrod">Login</h1>
     <form action="loginteacherservlet" method="post">
         <div><input class="item"  type="text" name="userid" required="required"  placeholder="Userid"></div>
         <div><input class="item" type="password" name="pass" placeholder="Password" required="required"></div>
         <div> <input class="item" id="btn1" type="submit" value="Login"></div>
         <div><input class="item" id="btn2" type="button" value="Sign UP" onclick="location.href='registerteacher.jsp'"></div>
         <div> <p><a id="link" href="forgotpassword.jsp">Forgot Password</a></p></div>
          </form>
     </center>
            
        </div>

    </body>
</html>
