<%-- 
    Document   : Gallery
    Created on : 29 Apr, 2020, 3:29:19 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gallery</title>
            <meta name="viewport" content="width=device-width,initial-scale=1">
         <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link href="css/css1.css" rel="stylesheet" type="text/css">
    </head>
    <body id="body1">
                <div id="main">
                    <span class="span1"><span  class="glyphicon glyphicon-earphone"></span><a id="ph" href="tel:0731-4259500"><span>0731-4259500</span></a></span>
                    <span class="span1"><span class="glyphicon glyphicon-envelope"></span><a id="ph" href="mailto:princecr7singh@gmail.com"><span>princecr7singh@gmail.com</span></a></span>
                    <span class="span2"><a id="ph" href="signup.jsp">SIGN UP</a></span>
                </div>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class=".container">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">MAHARISHI INSTITUTE </br> OF TECHNOLOGY</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
</div>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="nav navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">HOME<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active text-center ">
        <a class="nav-link" href="#art1">ABOUT US</a>
      </li>
      <li class="nav-item active text-center ">
        <a class="nav-link" href="#head3">CONTACT</a>
      </li>
      <li class="nav-item active text-center ">
        <a class="nav-link" href="Gallery.jsp">GALLERY</a>
      </li>
      <li class="nav-item active text-center ">
        <a class="nav-link" href="login.jsp">LOGIN</a>
      </li>
    </ul>
  </div>
</div>
</nav>

        </header>
        <div class="container" id="main-content">
  <div id="pushContent"></div>
<div  class="jumbotron">
            <section>
                <h1 style="color: green; margin-top:570px ;text-align: center;font-size: 50px">Gallery</h1>
                <table>
                    <tr>
                        <td><img class="img" src="images/IMG_20200430_104127.jpg" alt="Graduation image" width="300px" height="200px"> </td>
                        <td><img class="img" src="images/classroom.jpg" alt="classroom"></td>
                        <td><img class="img" src="images/image.jpg" alt="background image"></td>
                    </tr>
                    <div>
                    <tr>
                        <td><img class="img" src="images/alphabet-blur-books-close-up-301920.jpg" alt="Study"></td>
                        <td><img class="img" src="images/event.jpg" alt="Event at the college"></td>
                        <td><img class="img" src="images/convocation.jpg" alt="convocation"></td>
                   </tr>
                    </div>
                    <div>
                   <tr>
                       <td><img class="img" src="images/people-sitting-around-brown-wooden-table-under-white-pendant-1181435.jpg" alt="Meeting"></td>
                       <td><img class="img" src="images/library.jpg" alt="Student studying in a library"></td>
                       <td><img class="img" src="images/visit.jpg" alt="Industrial Visit"></td>
                   </tr>
                    </div>
                </table> 
            </section>
        </main>
         <footer>
            <nav>
            <div id="foot">
            <span><h1 id="head2">About Us</h1></span>
            <span><h1 id="head3">Contact Us</h1></span>
            </div>
                </nav>
        </footer>
         
    </body>

</html>
