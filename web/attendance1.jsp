<%-- 
    Document   : attendance1
    Created on : 24 May, 2020, 5:00:54 PM
    Author     : Windows
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         if(session.getAttribute("teacher_userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
      
       int[] attendance = new int[200];
        int[] total = new int[200];
        double[] percent = new double[200];
        Arrays.fill(attendance, 0);
        Arrays.fill(total, 0);
        Arrays.fill(percent, 0);
        
        String subjectid = request.getParameter("subjectid");
        String subject = request.getParameter("subject");
        String[] attended = request.getParameterValues("attendance");
        String date = request.getParameter("date");
        String[] userid=request.getParameterValues("enroll");
        for(int i=0;i<userid.length;i++){
         if(attended[i].equals("P")||attended[i].equals("p"))
           {
            attendance[i]=attendance[i]+1;
            total[i]=total[i]+1;
            percent[i]=100;
           }
           else if(attended[i].equals("A")||attended[i].equals("a"))
                   {
                   total[i]=total[i]+1;
                   percent[i]=0;
                   }
        }
          String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement("insert into attendance values(default,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            con.setAutoCommit(false);
            for(int j=0;j<userid.length;j++){
          ps.setString(1,subjectid);
          ps.setString(2,subject);
          ps.setString(3,attended[j]);
          ps.setInt(4,attendance[j]);
          ps.setInt(5,total[j]);
          ps.setString(6,date);
          ps.setDouble(7, percent[j]);
          ps.setString(8,userid[j]);
          ps.addBatch();
          ResultSet rs=ps.getGeneratedKeys();
          rs.next();
            }
             response.sendRedirect("attendanceteacher.jsp");
            ps.executeBatch();
            con.commit();
          
          %>
    </body>
</html>
