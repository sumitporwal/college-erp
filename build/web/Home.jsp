<%-- 
    Document   : index
    Created on : 23 Oct, 2019, 11:22:12 PM
    Author     : Windows
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maharishi Insitute Of Technology</title>
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link href="css/css1.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body id="body1">
        <div id="bgimg">
                <div class="container-fluid" style="background-color: transparent">
                    <span class="span1"><i class="fa fa-phone"></i><a id="ph" href="tel:0731-4259500"><span>0731-4259500</span></a>
                           <span class="span1"><i class="fa fa-envelope-o"></i><a id="ph" href="mailto:princecr7singh@gmail.com"><span>princecr7singh@gmail.com</span></a></span>
                    <span class="span2"><a id="ph" href="register.jsp">SIGN UP</a></span>
                </div>
             
        <header>
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
             <div class="container-fluid">
                 <div class="navbar-brand">
                <a href="#"><img src="images/medicaps-logo.jpg" alt="Medi-Caps University Logo" width="80px" height="80px"></a>
                <a id="medi" class="navbar-brand text-warning font-weight-bold" href="#">Medi-Caps University</a>
                 </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse text-center" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto ">
                       <li class="nav-item active">
                        <a class="nav-link text-white" href="#">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                         <a class="nav-link text-white" href="Gallery.jsp">Gallery <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                         <a class="nav-link text-white" href="#">Contact US <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link text-white" href="#about">About Us <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link text-white" href="login.jsp">Login<span class="sr-only">(current)</span></a>
                        </li>
                       </ul>
                </div>
             </div>
           </nav>
        </header>
        <div class="container-fluid text-center text-white headerset">
              <h2>Discover Your Future<br/> With US</h2>
        </div>
            </div>
            <div class="container-fluid">
            <div  id="about" class="card col-xs-12">
                <img class="card-img-top" src="images/group-of-people-in-conference-room-1181304_1.jpg" style="width: 60%;height: 300px;display: inline-block">
                <div class="card-body" id="divh2" style="display: inline-block"><h2 class="text-center">Welcome to Medi-Caps University</h2>
                    <p>Medi-Caps has been a brand name in the arena of technical education. Since its inception in July 2000, Medi-Caps has consistently aimed at creating an ideal ambiance for budding technocrats and managers; and helping them to grow like true professionals. With its highly qualified faculty there seems an optimal blend of academic brilliance and industry exposure, supplemented by highly specialized visiting faculty and industry experts, senior professionals from various segments of different industries and business houses. It was time now to spread wings and move out for more exposure and widening of the periphery.
                            Hence the foundation of Medi-Caps University has been laid down. With a strong foundation of the Group since 15 years, Medi-Caps University wishes to maintain the same objective of imparting quality education and producing sound professionals for the benefit of the society at large.</p></div>
            </div>
            </div>
            <section class="container-fluid sec1">
                        <h2>EVENTS AT COLLEGE</h2>
                        <div class="row">
                        <div class="col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto">
                        <img class="img" src="images/IMG_20200430_104127.jpg" alt="Graduation image"></div>
                        <div class="col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto"><img class="img" src="images/classroom.jpg" alt="classroom"></div>
                        <div class="col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto"><img class="img" src="images/event.jpg" alt="Event at the college"></div>
                        <div class="col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto"><img class="img" src="images/convocation.jpg" alt="convocation"></div>
                        <div class="col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto"><img class="img" src="images/alphabet-blur-books-close-up-301920.jpg" alt="Study"></div>
                        <div class="col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto"><img class="img" src="images/visit.jpg" alt="Industrial Visit"></div>
        
                        </div>
            </section>
        <div class="container-fluid" id="foot">
        <footer>  
            <h3>All Rights Reserved</h3>
        </footer>
            </div>
     <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </body>
</html>
