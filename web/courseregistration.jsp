<%-- 
    Document   : courseregistration
    Created on : 28 Jun, 2020, 2:18:37 AM
    Author     : Windows
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Registration Slip</title>
    </head>
    <body>
        <%
             if(session.getAttribute("userid")==null)
            {
                response.sendRedirect("login.jsp");
            }
            String sql="select register.stream,register.branch,register.sem,course_code,course_name,credits from subject left join register on register.stream=subject.stream and register.branch=subject.branch and register.sem=subject.sem where userid='"+session.getAttribute("userid")+"'";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            %>
            <%
        String sqlquery="select course_code,course_name,credit from result where userid='"+session.getAttribute("userid")+"' and grade='fail'";
        String urli="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection(urli,"root","root");
        PreparedStatement pres=conn.prepareStatement(sqlquery);
        ResultSet res=pres.executeQuery();
        String[] checkbox=request.getParameterValues("checkbox");
        String userid=String.valueOf(session.getAttribute("userid"));
        String sem=request.getParameter("sem");
        ArrayList<String> code=new ArrayList<String>();
        ArrayList<String> name=new ArrayList<String>();
        ArrayList<String> credit=new ArrayList<String>();
        int j=0;
        while(rs.next() &&  j<checkbox.length){
        if(checkbox[j].equals(rs.getString(4))){
        code.add(rs.getString(4));
        name.add(rs.getString(5));
        credit.add(rs.getString(6));
        j++;
        }
        }
        while(res.next() &&  j<checkbox.length){
        if(checkbox[j].equals(res.getString(1))){
        code.add(res.getString(1));
        name.add(res.getString(2));
        credit.add(res.getString(3));
        j++;
        }
        }
        
          String sq="insert into studentsubject values(?,?,?,?,?)";
            String ur="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection co=DriverManager.getConnection(ur,"root","root");
            PreparedStatement p=con.prepareStatement(sq);
            co.setAutoCommit(false);
        for(int i=0;i<checkbox.length;i++){
            p.setString(1, userid);
            p.setString(2, sem);
            p.setString(3, code.get(i));
            p.setString(4, name.get(i));
            p.setString(5, credit.get(i));
            p.addBatch();
            }
        response.sendRedirect("courseregistrationslip.jsp");
        p.executeBatch();
        co.commit();
            %>
    </body>
</html>
