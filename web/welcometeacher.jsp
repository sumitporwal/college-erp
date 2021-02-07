<%-- 
    Document   : welcometeacher
    Created on : 8 May, 2020, 9:19:46 AM
    Author     : Windows
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width ,initial-scale=1">
        <link href='css/welcome.css' type="text/css" rel="stylesheet">
        <style>
             #input1{
                border-radius: 30px;
                position: absolute;
                top: 0px;
            }
            header table,th,td{
                column-width: 333px;
            }
        </style>
    </head>
    <body>
         <%
            if(session.getAttribute("teacher_userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
            String sql="select userid,department,name,photo from registerteacher where userid='"+session.getAttribute("teacher_userid")+"'";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            %> 
            <div id="div1">
            <header>
                <nav>
                    <span>
                        <form action="" method="">
                        <table>
                            <tr>
                                <th>User</th>
                                <th>Branch</th>
                                <th>Name</th>
                            </tr>
                            <% while(rs.next()){%>
                            <tr>
                                <td><%=rs.getString(1)%></td>
                                <td><%=rs.getString(2)%></td>
                                <td><%=rs.getString(3)%></td>
                                <td><img id="input1" src="<%=rs.getString(4)%>" width="60" height="45"></td>
                            </tr>
                            <%}%>
                        </table>
                            </form>
                    </span>
                </nav>
            </header> 
            <main>
                <section>
                    <article>
                        <h1>Fees Information</h1>
                        <a class="link" href="receipt.jsp">fee receipt</a>
                        <a class="link" href="fee.jsp">Pay Fee Online</a>
                    </article>
                    <article>
                        <h1>General Information</h1>
                        <a class="link" href="Academic_Calendar.pdf">Academic Calender</a>
                        <a class="link"href="profile.jsp">Your Profile</a>
                    </article>
                    <article>
                        <h1>Academics</h1>
                        <a class="link" href="assignment.jsp">Assignments</a>
                        <a class="link" href="attendanceteacher.jsp">Attendance</a></br></br></br>
                        <a class="link" href="notes.jsp">Notes</a>
                        <a class="link" href="addstudentmarks.jsp">Add Marks</a>
                    </article>
                    <article style="position: absolute;top: 240px">
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
                        <a class="link1" href='./pdffile/Academic_Calendar.pdf'>Academic Calender</a></br>
                        <a class="link1" href='news.jsp'>News/Notices</a></br>
                        </div>
                    </details>
                    <details>
                        <summary>Academics</summary>
                        <div style="background-color: white;border-radius: 5px;text-align: center">
                        <a class="link1" href='attendance.jsp'>Exam Schedule</a></br>
                        <a class="link1" href='attendance.jsp'>Syllabus</a></br>
                        <a class="link1" href='attendanceteacher.jsp'>Attendance</a></br>
                        <a class="link1"href='notes.jsp'>Notes</a><br>
                        </div>
                    </details>
                    <a style="color: white;font-size: 24px;margin:20px 10px" class="link" href='setpassword.jsp'>Change Password</a>
                    <form action="logoutservlet" method="post">
                          <input  style="color: white;font-size: 24px;margin:20px 30px;padding: 0px;border:solid 0px black;background-color: lightblue;cursor: pointer" type="submit" value="Logout"></input>
                    </form>
                </aside>
            </main>
            <footer>
                
            </footer>
            </div>

    </body>
</html>
