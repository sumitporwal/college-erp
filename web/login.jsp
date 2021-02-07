<%-- 
    Document   : login
    Created on : 2 Apr, 2020, 5:37:08 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet" type="text/css">
    </head>
       <body id="body2">
        <div id="form2"> 
        <center>
            <h1 style="color: goldenrod">Login</h1>
     <form action="" method="">
         <div><input class="item" type="text" name="userid" required="required" disabled placeholder="Userid"></div>
         <div><input class="item" type="password" name="pass" placeholder="Password" required="required" disabled></div>
         <div>user:<input  class="item1" type="radio" id="teacher" name="user" onclick="location.href='loginteacher.jsp'">teacher
             <input  class="item1"  type="radio" id="student" name="user" onclick="location.href='loginstudent.jsp'">student</div>
         <div> <input class="item" id="btn1" type="submit" value="Login"></div>
         <div> <p><a id="link" href="forgotpassword.jsp">Forgot Password</a></p></div>
          </form>
     </center>
            
        </div>
    </body>
</html>
