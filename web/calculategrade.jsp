<%-- 
    Document   : calculategrade
    Created on : 4 Jul, 2020, 10:20:18 PM
    Author     : Windows
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page import="java.sql.PreparedStatement"%>
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
             String userid=request.getParameter("userid");
             String sql="select sem from register where userid='"+userid+"'";
            String url="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            %>
            <%
            String enroll=request.getParameter("userid");
            String sqq="select credit,grade,cgpa from result where userid='"+enroll+"'";
            String u="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection(u,"root","root");
            PreparedStatement pre=c.prepareStatement(sqq);
           // pre.setString(1, enroll);
            ResultSet r=pre.executeQuery();
            %>
            <%
             String sem="";
             while(rs.next()){
             sem=sem+rs.getString(1);
             }
             String[] coursecode=request.getParameterValues("course_code");
             String[] coursename=request.getParameterValues("course_name");
             String[] marks=request.getParameterValues("marks");
             String[] grade=new String[marks.length];
             Arrays.fill(grade,"");
             ArrayList<String> credits=new ArrayList<String>();
             ArrayList<String> grades=new ArrayList<String>();
             ArrayList<String> cg=new ArrayList<String>();
             String[] credit=request.getParameterValues("credit");
             while(r.next()){
                 credits.add(r.getString(1));
                 grades.add(r.getString(2));
                 cg.add(r.getString(3));
             }
             double sgpa=0;
             double cgpa=0;
             int cre=0;
             int totalcredit=0;
             double s=0;
             DecimalFormat df=new DecimalFormat("##.##");
            String sq="insert into result values(?,?,?,?,?,?,?,?)";
            String ur="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection co=DriverManager.getConnection(ur,"root","root");
            PreparedStatement p=con.prepareStatement(sq);
            for(int j=0;j<marks.length;j++){
                         switch(Integer.parseInt(marks[j])/10){
                             case 0:
                                 grade[j]=grade[j]+"fail";
                                 break;
                             case 1:
                                 grade[j]=grade[j]+"fail";
                                 break;
                             case 2:
                                 grade[j]=grade[j]+"fail";
                                 break;
                             case 3:
                                 grade[j]=grade[j]+"C";
                                 break;
                             case 4:
                                 grade[j]=grade[j]+"C++";
                                 break;
                             case 5:
                                 grade[j]=grade[j]+"B";
                                 break;
                             case 6:
                                 grade[j]=grade[j]+"B++";
                                 break;
                             case 7:
                                 grade[j]=grade[j]+"A";
                                 break;
                             case 8:
                                 grade[j]=grade[j]+"A++";
                                 break;
                             case 9:
                                 grade[j]=grade[j]+"o";
                                 break;
                             default:
                                 break;
                         }
                         if(!grade[j].equalsIgnoreCase("fail")){
                         cre=cre+Integer.parseInt(credit[j]);
                         s=s+((Integer.parseInt(marks[j])/10)+1)*(Integer.parseInt(credit[j]));
                         }
            }
            sgpa=s/cre;
            int precredit=0;
            if(sem.equals("1st-sem")){
           cgpa=sgpa;
           }
            else{
                 for(int j=0;j<credits.size();j++){
                     if(!grades.get(j).equalsIgnoreCase("fail")){
            precredit=precredit+Integer.parseInt(credits.get(j));
                     }
            }
            totalcredit=cre+precredit;
            cgpa=((Double.parseDouble(cg.get(cg.size()-1))*(precredit))+s)/totalcredit;
            }
            co.setAutoCommit(false);
                 for(int j=0;j<marks.length;j++){
                         p.setString(1,userid);
                         p.setString(2,credit[j]);
                         p.setString(3, sem);
                         p.setString(4,coursecode[j]);
                         p.setString(5,coursename[j]);
                         p.setString(6,grade[j]);
                         p.setString(7,df.format(sgpa));
                         p.setString(8,df.format(cgpa));
                         p.addBatch();  
             }
            response.sendRedirect("addstudentmarks.jsp");
            p.executeBatch();
            co.commit();

            %>
    </body>
</html>
