<%-- 
    Document   : welcomestudent
    Created on : 14 Apr, 2020, 12:03:41 AM
    Author     : Windows
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>JSP Page</title>
        <meta name="viewport" content="width=device-width ,initial-scale=1">
        <link href='css/welcome.css' type="text/css" rel="stylesheet">
        <style>
            #input1{
                border-radius: 30px;
                position: absolute;
                top: 0px;
            }
            #course{
                position: absolute;
                top: 90px;
                left: 32%;
                text-align: center;
                background-color:powderblue;
                width: 25%;
                height: 40px;
                border: 1px solid silver; 
                box-shadow: 2px turquoise;
            }
            #course1{
                position: absolute;
                top: 90px;
                left: 62%;
                text-align: center;
                background-color:powderblue;
                width: 25%;
                height: 40px;
                border: 1px solid silver; 
                box-shadow: 2px turquoise;
            }
            #a1{
                text-decoration: none;
                position: relative;
                top: 10px; 
                font-size: 20px;
                color: white;
                animation-name: a;
                animation-iteration-count: infinite;
                animation-duration: 1.2s;
            }
             @keyframes a{
                 0%{
                     opacity:1;
                 }
                 100%{
                     opacity:0;
                 }
            }
        </style>
    </head>
    <body>
       <%
            if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
            String sem="";
            String sq="select scholar_no,stream,class,sem,name,photo from register where userid='"+session.getAttribute("userid")+"'";
            String ur="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection co=DriverManager.getConnection(ur,"root","root");
            PreparedStatement p=co.prepareStatement(sq);
            ResultSet r=p.executeQuery();
        %>
            <div id="div1">
            <header>
                <nav>
                    <span>
                        <table>
                            <tr>
                                <th>Scholar NO.</th>
                                <th>Stream</th>
                                <th>Sem</th>
                                <th>Student Name</th>
                            </tr>
                <tr>
                    <%while(r.next()){%>
                                <td><%=r.getInt(1)%></td>
                                <td><%=r.getString(2).toUpperCase()%></td>
                                <td><%=r.getString(3).toUpperCase()+" "+r.getString(4).toUpperCase()%></td>
                                <td><%=r.getString(5).toUpperCase()%></td>
                                <td><img id="input1" src="<%=r.getString(6)%>" width="60" height="45"/></td>
                                <%sem=r.getString(4);%>
                                <%}%>
                            </tr>
                        </table>
                    </span>
                </nav>
            </header> 
                            <%
            int n=0;
            String sql="select * from studentsubject where enrollment_no='"+session.getAttribute("userid")+"' and sem='"+sem+"'";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                n++;
            }
            %> 
            <main>
                <%if(n>0){%>
                <span id="course"><a id="a1" href="courseregistrationslip.jsp">COURSE REGISTRATION FORM</a></span>
                <%}%>
                <%if(n==0){%>
                <span id="course"><a id="a1" href="studentsubject.jsp">COURSE REGISTRATION FORM</a></span>
                <%}%>
                <span id="course1"><a id="a1" href="result.jsp">View Result</a></span>
                <section>
                    <article>
                        <h1>Fees Information</h1>
                        <a class="link" href="receipt.jsp">fee receipt</a>
                        <a class="link" href="fee.jsp">Pay Fee Online</a>
                    </article>
                    <article>
                        <h1>General Information</h1>
                        <a class="link" href="./pdffile/Academic_Calendar.pdf">Academic Calender</a>
                        <a class="link"href="profile.jsp">Your Profile</a>
                    </article>
                    <article>
                        <h1>Academics</h1>
                        <a class="link" href="assignment.jsp">Assignments</a>
                        <a class="link" href="attendance.jsp">Attendance SubjectWise</a>
                        <a class="link" href="attendancedate.jsp">Attendance DateWise</a>
                        <a class="link" href="studentassignmentupload.jsp">Assignments</a>
                    </article>
                    <article>
                        <h1>Bus Information</h1>
                        <a class="link" href="stop.jsp">Bus Stops</a>
                        <a class="link" href="route.jsp">Bus Routes</a>
                    </article>
                     </section>
                <aside>
                    <details>
                        <summary>General Information</summary>
                        <div style="background-color: white;border-radius: 5px;text-align: center">
                        <a class="link1" href='profile.jsp'>Your Profile</a></br>
                        <a class="link1" href='Academic_Calendar.pdf'>Academic Calender</a></br>
                        <a class="link1" href='news.jsp'>News/Notices</a></br>
                        </div>
                    </details>
                    <details>
                        <summary>Academics</summary>
                        <div style="background-color: white;border-radius: 5px;text-align: center">
                        <a class="link1" href='attendance.jsp'>Exam Schedule</a></br>
                        <a class="link1" href='attendance.jsp'>Syllabus</a></br>
                        <a class="link1" href='attendancedate.jsp'>Attendance DateWise</a></br>
                        <a class="link1"href='attendance.jsp'>Attendance SubjectWise</a><br>
                        </div>
                    </details>
                    <a style="color: white;font-size: 24px;margin:20px 10px" class="link" href='setpassword.jsp'>Change Password</a></br>
                  <form action="logoutservlet" method="post">
                        <input  style="color: white;font-size: 24px;margin:15px 25px;border:solid 0px black;background-color: lightblue;cursor: pointer" type="submit" value="Logout"></input>
                    </form>
                </aside>
            </main>
            <footer>
                
            </footer>
            </div>
    </body>
</html>
