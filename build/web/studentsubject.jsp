<%-- 
    Document   : studentsubject
    Created on : 25 Jun, 2020, 12:42:50 AM
    Author     : Windows
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Registration</title>
         <meta name="viewport" content="width=device-width,initial-scale=1">
         <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <style>
            body{
                background-color: snow;
            }
            #div1{
                display: inline-block;
                width: 60%;
                margin-left: 2%;
            }
            #h1{
                margin-left: 3%;
                margin-bottom: 10px;
                font-size: 30px;
            }
            #h2{
                margin-left: 8%;
                position: absolute;
                text-align: center;
            }
            #img1{
                margin: 1%;
                margin-left: 3%;
            }
            #img2{
                display: inline-block;
                width: 15%;
                height: 120px;
                position: absolute;
                right: 5%;
                top: 2%;
            }
            .input1{
                width: 100%;
                cursor: not-allowed;
            }
            .input2{
                cursor: pointer;
            }
            #td1{
                text-align: center;
            }
            #btn1{
                background-color: skyblue;
                font-size: 15px;
                color: white;
                width: 50px;
                border-radius: 5px;
                float: right;
                position: absolute;
                top: 10px;
                right: -25%;
            }
            #btn2{
                background-color: skyblue;
                font-size: 15px;
                color: white;
                width: 50px;
                border-radius: 5px;
                float: right;
                position: absolute;
                top: 10px;
                right: -32%;
            }
            #printableArea{
                border: 1px solid black;
                box-shadow: 5px transparent;
                width: 60%;
                height: auto;
                margin: 0% 20%;
                margin-top: 0px;
                background-color: white;
                position: relative;
            }
             #div2{
                 background-color: lightgrey;
                 width: 100%;
                 height: 30px;
             }
             .glyphicon-off{
                 margin: 10px;
                 font-size: 15px;
                 color: yellow;
                 position: absolute;
                 right: 10px;
                 text-decoration: none;
             }
             .glyphicon-home{
                 margin: 10px;
                 font-size: 15px;
                 color: white;
                 position: absolute;
                 right: 40px;
                 text-decoration: none;
             }
             #table1,tr{
               width:100%;
               margin-left: 5px;
               margin-top: 3%;
             }
             #table3{
                 margin-top: 1%;
                 margin-bottom: 3px;
             }
             #table3 th{
                 height: 30px;
             }
        </style>
    </head>
    <body>
        <%
             if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
            String path="";
            String sql="select userid,name,email,stream,branch,class,sem,photo from register where userid='"+session.getAttribute("userid")+"'";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                path=rs.getString(8);
            }
            %>
            <div id="div3">
            <div id="div2">
                <span><a class="glyphicon glyphicon-home" href="welcomestudent.jsp"></a></span>
                <span><a class="glyphicon glyphicon-off" href="logoutservlet"></a></span>
            </div>
        <div id="printableArea">
            <img src="medicaps-logo.jpg" style="width:14%;height: 120px;display: inline-block">
            <div id="div1">
            <h2 id="h1">Medi-Caps University,Indore</h2>
            <h3 id="h2">Subject Choice Filling</h3>
            </div>
            <img id="img2" src="<%=path%>">
            <hr style="border: 1px solid black">
            <%
            int totalcre=0;
            Connection connec=Mysql.MySqlConnection.getconnection();
            PreparedStatement prep=connec.prepareStatement("select credit from result where userid='"+session.getAttribute("userid")+"' and grade!='fail'");
            ResultSet resu=prep.executeQuery();
            while(resu.next()){
            totalcre=totalcre+Integer.valueOf(resu.getString(1));    
            }
            %>
            <%  String sqli="select userid,name,email,stream,branch,class,sem,photo from register where userid='"+session.getAttribute("userid")+"'";
            String urli="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(urli,"root","root");
            PreparedStatement pse=conn.prepareStatement(sqli);
            ResultSet res=pse.executeQuery();
            %>
            <table  id="table1"  width="98%">
             <% while(res.next()){%>
             <tr>
                 <td>Enrollment NO.</td>
                 <td><input type="text" name="enrollment" value="<%=res.getString(1)%>" disabled="disabled"></td>
                 <td>Branch</td>
                 <td><input type="text" name="branch" value="<%=res.getString(5)%>" disabled="disabled"></td>
             </tr>
             <tr>
                 <td>Name</td>
                 <td><input type="text" name="name" value="<%=res.getString(2)%>" disabled="disabled"></td> 
                 <td>Class</td>
                 <td><input type="text" name="clas" value="<%=res.getString(6)%>" disabled="disabled"></td>    
             </tr>
             <tr>
                 <td>Email</td>
                 <td><input type="text" name="email" value="<%=res.getString(3)%>" disabled="disabled"></td> 
                 <td>Stream</td>
                 <td><input type="text" name="stream" value="<%=res.getString(4)%>" disabled="disabled"></td>
             </tr>
             <tr>
                 <td>Semester</td>
                 <td><input type="text" name="email" value="<%=res.getString(7)%>" disabled="disabled"></td> 
                 <td><b>Total Earned Credits Up till Now:</b></td>
                 <td><input type="text" name="stream" value="<%=totalcre%>" disabled="disabled"></td>
             </tr>
             <%}%>
            </table>
            <% 
            String sq="select scholar_no,name,email,phno,password,userid,register.stream,register.branch,register.sem,course_code,course_name,credits from subject left join register on register.stream=subject.stream and register.branch=subject.branch and register.sem=subject.sem where userid='"+session.getAttribute("userid")+"'";
            String ur="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection co=DriverManager.getConnection(ur,"root","root");
            PreparedStatement p=co.prepareStatement(sq);
            ResultSet r=p.executeQuery();
            %>
            <form action="courseregistration.jsp" method="post">
              <table border="1" width="99%" align="center" id="table3">
                  <%
            String s="select userid,name,email,stream,branch,class,sem from register where userid='"+session.getAttribute("userid")+"'";
            String u="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection(u,"root","root");
            PreparedStatement pre=c.prepareStatement(s);
            ResultSet result=pre.executeQuery();
            %>
                  <%while(result.next()){%>
                  <tr style="display:none">
                 <td>Sem</td>
                 <td><input type="text" name="sem" value="<%=result.getString(7)%>"></td></tr>
                  <%}%>
                  <tr>
                      <th></th>
                      <th>Course Code</th>
                      <th>Course Name</th>
                      <th>Credits</th>
                      <th>Semester</th>
                  </tr>
                      <% while(r.next()){%>
                  <tr>
                      <td id="td1"><input class="input2" type="checkbox" value="<%=r.getString(10)%>" name="checkbox"></td>
                      <td><%=r.getString(10)%></td>
                      <td><%=r.getString(11)%></td>
                      <td><%=r.getString(12)%></td>
                      <td><%=r.getString(9)%></td>
                  </tr>
                   <%}%>
             <%
            String sqlquery="select course_code,course_name,credit from result where userid='"+session.getAttribute("userid")+"' and grade='fail'";
            String urlip="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conne=DriverManager.getConnection(urlip,"root","root");
            PreparedStatement prepe=conne.prepareStatement(sqlquery);
            ResultSet resul=prepe.executeQuery();
           while(res.next()){%>
                  <tr>
                      <td id="td1"><input class="input2" id="read" type="checkbox" value="<%=resul.getString(1)%>" name="checkbox"></td>
                      <td><%=resul.getString(1)%></td>
                      <td><%=resul.getString(2)%></td>
                      <td><%=resul.getString(3)%></td>
                  </tr>
                  <%}%>
                   <input id="btn1" type="submit" name="submit" value="Save">
              </table>
                  <hr style="border-style: inset;border-width: 1px;color: black;margin-top: 0.2em;margin-bottom: 0.2em">
                  <b><span style="font-size: 14px">Important Points:-</span></b>
                  <hr style="border-style: inset;border-width: 1px;color: black;margin-top: 0.2em;margin-bottom: 0.2em">
                  <P style="color: skyblue">1.The courses in which you wish to appear in Makeup sem MUST be registered either in EVEN or ODD sem.A non registered course of EVEN/ODD sem will not be visible on Makeup Registration Page.</p>
                  <hr style="border-style: inset;border-width: 1px;color: black;margin-top: 0.2em;margin-bottom: 0.2em">
                  <p style="color:red">2.SELECT COURSES CAREFULLY.FIRST VERIFY THE COURSE CODES FROM THE SCHEME.</p>
                  <hr style="border-style: inset;border-width: 1px;color: black;margin-top: 0.2em;margin-bottom: 0.2em">
                  <p style="color: red;">3.The same photograph will be seen on your Marksheets & Degree,which you will have to submit for job interviews.</p>
                 
                    </form>
                   </div>
            </div>
    </body>
</html>
