<%-- 
    Document   : studentassignmentupload
    Created on : 27 Jul, 2020, 2:15:55 AM
    Author     : Windows
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <style>
            body{
                background-color:window; 
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
             table{
                 border:1px solid black;
                 border-collapse: collapse;
                 width:100%;
                 text-align:center;
                 margin-top: 2%;
             }
                 th{
             border:1px solid black;
             border-collapse: collapse;
             color: black;
             height: 60px;
             font-size: 20px;
             text-align: center;
                 } 
                 td{
                     border:1px solid black;
                     border-collapse: collapse;
                     background-color: white;
                     color: black;
                     height: 30px;
                     font-size: 15px;
                     text-align: center;
                 }
        </style>
    </head>
    <body>
        <%  
            if(session.getAttribute("userid")==null){
                response.sendRedirect("login.jsp");
            }
            int i=0;
            ArrayList<String> path=new ArrayList<String>();
            Connection con=Mysql.MySqlConnection.getconnection();
            PreparedStatement ps=con.prepareStatement("select assignment.assignment_id,assignment.course_code,assignment.course_name,upload_date,submission_date,assignment.teacher_name,assignmentfile,assignment.filename from assignment left join studentsubject on studentsubject.course_code=assignment.course_code left join register on register.sem=studentsubject.sem left join assignmentsolution on assignment.Assignment_id!=assignmentsolution.assignment_id where studentsubject.enrollment_no='"+session.getAttribute("userid")+"' and  register.userid='"+session.getAttribute("userid")+"' and assignment.Assignment_id!=assignmentsolution.assignment_id and assignmentsolution.enrollment_no='"+session.getAttribute("userid")+"'");
            ResultSet rs=ps.executeQuery();
        %>
        <%
            ArrayList<String> solution=new ArrayList<String>();
        Connection co=Mysql.MySqlConnection.getconnection();
        PreparedStatement p=co.prepareStatement("select assignment_id,solution_filename,solution_newfilename from assignmentsolution where enrollment_no='"+session.getAttribute("userid")+"'");
        ResultSet r=p.executeQuery();
        %>
         <div id="div2">
                <span><a class="glyphicon glyphicon-home" href="welcomestudent.jsp"></a></span>
                <span><a class="glyphicon glyphicon-off" href="logoutservlet"></a></span>
        </div>
        <form action="solutionupload.jsp" method="post">
        <table>
             <h2 style="margin-top:2%">Assignment:</h2>
            <tr>
               <th>SNo.</th>
               <th>Course Code</th> 
               <th>Course Name</th> 
               <th>Uploaded By</th> 
               <th>Upload Date</th> 
               <th>Submission Date</th>
               <th>Assignment File</th>
               <th>Upload Solution</th>
            </tr>
                <%while(rs.next()){%>
                <tr>
                <td><%=i+1%></td>
                <td><%=rs.getString(2)%></td>
                <td><%=rs.getString(3)%></td>
                <td><%=rs.getString(6)%></td>
                <td><%=rs.getString(4)%></td>
                <td><%=rs.getString(5)%></td>
                <%path.add(rs.getString(7));%>
                <input type='text' name='id' value='<%=rs.getInt(1)%>' style="display:none">
                <td><input id="<%=i%>" type="button" value="<%=rs.getString(8)%>" style="width:90%"></td>
                <td><input type="submit" value="Upload" id='<%=i%>'></td>
                </tr>
                <%i++;}%>
                
        </table>
        </form>
        <embed id="embed" type="application/pdf" width="100%" height="700px"/>
            <script>
                <%for(int j=0;j<path.size();j++){%>
                document.getElementById("<%=j%>").addEventListener("click",function(){
                  document.getElementById("embed").src="<%=path.get(j)%>";
                });
                <%}%>
                <%for(int j=0;j<solution.size();j++){%>
                document.getElementById("<%=solution.get(j)%>").addEventListener("click",function(){
                  document.getElementById("embed").src="<%=solution.get(j)%>";
                });
                <%}%>
            </script>
    </body>
</html>
