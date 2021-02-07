<%-- 
    Document   : register
    Created on : 2 Apr, 2020, 5:35:57 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="css/register.css" rel="stylesheet" type="text/css">
    </head>
    <body id="body1">
    <center>
        
        <h1 style="color: chartreuse">Register</h1>
        <form  id="form1" action="registerservlet" method="post" enctype="multipart/form-data">
           <div> <input class="item" type="text" name="name" required="required" placeholder="Enter Your Name"></div>
           <div><input class="item" type="email" name="email" required="required" placeholder="Email id"></div>
           <div><input class="item" type="text" name="phno" required="required" placeholder="Contact Number"></div>
           <div><input class="item" type="password" name="pass"  required="required" placeholder="Password"></div>
           <div><input class="item" type="text" name="userid" required="required" placeholder="Enrollment NO."></div>
           <div><select name="stream" class="item" required="required" style="width: 88%;height: 30px">
                   <option class="item" disabled="" selected="">Select Stream</option>
                   <option class="item" value="B.Tech">B.Tech</option>
                   <option class="item" value="M.Tech">M.Tech</option>
                   <option class="item" value="BCA">BCA</option>
                   <option class="item" value="BBA">BBA</option>
                   <option class="item" value="MBA">MBA</option>
                   <option class="item" value="Pharmacy">PHARMACY</option>
               </select></div>
           <div><input class="item" type="text" name="branch" required="required" placeholder="Branch"></div>
           <div><input class="item" type="text" name="clas" required="required" placeholder="Class"></div>
           <div><input type="file" class="item" name="file" required="required" placeholder="Select a file" style="width: 88%;height: 25px;color:black"></div>
           <div><input class="item" id="btn1" type="submit" value="Register">
           <input class="item" id="btn2" type="submit" value="login" onclick="location.href='login.jsp'"></div>
          </form>
       
    </center>
    </body>
</html>
