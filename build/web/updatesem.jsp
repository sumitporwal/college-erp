<%-- 
    Document   : updatesem
    Created on : 9 Jul, 2020, 7:58:11 PM
    Author     : Windows
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>updatesem</title>
    </head>
    <body>
        <%
        if(session.getAttribute("admin_userid")==null){
            response.sendRedirect("loginadmin.jsp");
        }
        String sq="select userid,sem from register";
        String ur="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection co=DriverManager.getConnection(ur,"root","root");
        PreparedStatement p=co.prepareStatement(sq);
        ResultSet rs=p.executeQuery();
        %>
        <%
         List<String> user=new ArrayList<String>();
         List<Integer> se=new ArrayList<Integer>();
         while(rs.next()){
         se.add((Integer.parseInt((rs.getString(2)).substring(0,1)))+1);
         user.add(rs.getString(1));
            }
        for(int i=0;i<user.size();i++){
        String sql="update register set sem=? where userid='"+user.get(i)+"'";
        String url="jdbc:mysql://localhost:3306/studant";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,"root","root");
        PreparedStatement ps=con.prepareStatement(sql);
        //con.setAutoCommit(false);
        if(se.get(i)<=8){
        String sem="";
        switch (se.get(i)) {
                case 1:
                    sem=sem+String.valueOf(se.get(i))+"st-sem";
                    break;
                case 3:
                    sem=sem+String.valueOf(se.get(i))+"rd-sem";
                    break;
                case 2:
                     sem=sem+String.valueOf(se.get(i))+"nd-sem";
                    break;
                case 4:
                     sem=sem+String.valueOf(se.get(i))+"th-sem";
                    break;
                case 5:
                     sem=sem+String.valueOf(se.get(i))+"th-sem";
                    break;
                case 6:
                     sem=sem+String.valueOf(se.get(i))+"th-sem";
                    break;
                case 7:
                     sem=sem+String.valueOf(se.get(i))+"th-sem";
                    break;
                case 8:
                    sem=sem+String.valueOf(se.get(i))+"th-sem";
                    break;
                default:
                    break;
            }
        ps.setString(1,sem);
        ps.executeUpdate();
       // ps.addBatch();
        }
        }
        response.sendRedirect("welcomeadmin.jsp");
        //ps.executeBatch();
        //con.commit();
        %>
    </body>
</html>
