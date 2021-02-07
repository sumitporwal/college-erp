<%-- 
    Document   : result
    Created on : 18 Jul, 2020, 4:15:23 PM
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
        <title>Result</title>
    </head>
    <body>
        <%
        if(session.getAttribute("userid")==null){
            response.sendRedirect("login.jsp");
        }
        String sem=request.getParameter("sem");
        String url="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,"root","root");
        PreparedStatement ps=con.prepareStatement("select * from resultpdf left join register on register.sem=resultpdf.sem and register.userid=resultpdf.userid where resultpdf.userid='"+session.getAttribute("userid")+"' and resultpdf.sem=?");
        ps.setString(1,sem);
        ResultSet rs=ps.executeQuery();        
        %>
        <%while(rs.next()){%>
        <embed src="<%=rs.getString(3)%>" type="application/pdf" width="100%" height="700px" />
               <%}%>
               <form action="" method="post" id="form1">
                  <div>Select Semester<select name="sem" class="item" id="select" required="required">
                   <option class="item" disabled="" selected="">Select Sem</option>
                   <option class="item" value="1st-Sem">1st-Sem</option>
                   <option class="item" value="2nd-Sem">2nd-Sem</option>
                   <option class="item" value="3rd-Sem">3rd-Sem</option>
                   <option class="item" value="4th-Sem">4th-Sem</option>
                   <option class="item" value="5th-Sem">5th-Sem</option>
                   <option class="item" value="6th-Sem">6th-Sem</option>
                   <option class="item" value="7th-Sem">7th-Sem</option>
                   <option class="item" value="8th-Sem">8th-Sem</option>
               </select></div>
                   <input id="btn" type="submit" value="Search">
               </form>
               <script>
                   document.getElementById("form1").addEventListener('submit',function(){
                   document.getElementById("form1").style.display="none";
                   });
               </script>
    </body>
</html>
