package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class courseregistrationslip_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("      <title>Course Registration</title>\n");
      out.write("         <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n");
      out.write("         <link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <style>\n");
      out.write("            @media print{\n");
      out.write("                #btn1{\n");
      out.write("                    display: none;\n");
      out.write("                }\n");
      out.write("                #btn2{\n");
      out.write("                    display: none;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("           body{\n");
      out.write("                background-color: snow;\n");
      out.write("            }\n");
      out.write("            #div1{\n");
      out.write("                display: inline-block;\n");
      out.write("                width: 60%;\n");
      out.write("                margin-left: 2%;\n");
      out.write("            }\n");
      out.write("            #h1{\n");
      out.write("                margin-left: 3%;\n");
      out.write("                margin-bottom: 10px;\n");
      out.write("                font-size: 30px;\n");
      out.write("            }\n");
      out.write("            #h2{\n");
      out.write("                margin-left: 8%;\n");
      out.write("                position: absolute;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #img1{\n");
      out.write("                margin: 1%;\n");
      out.write("                margin-left: 3%;\n");
      out.write("            }\n");
      out.write("            #img2{\n");
      out.write("                display: inline-block;\n");
      out.write("                width: 15%;\n");
      out.write("                height: 120px;\n");
      out.write("                position: absolute;\n");
      out.write("                right: 5%;\n");
      out.write("                top: 2%;\n");
      out.write("            }\n");
      out.write("            .input1{\n");
      out.write("                width: 100%;\n");
      out.write("                cursor: not-allowed;\n");
      out.write("            }\n");
      out.write("            .input2{\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            #td1{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #btn1{\n");
      out.write("                background-color: skyblue;\n");
      out.write("                font-size: 15px;\n");
      out.write("                color: white;\n");
      out.write("                width: 50px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                float: right;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 10px;\n");
      out.write("                right: -25%;\n");
      out.write("            }\n");
      out.write("            #btn2{\n");
      out.write("                background-color: skyblue;\n");
      out.write("                font-size: 15px;\n");
      out.write("                color: white;\n");
      out.write("                width: 50px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                float: right;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 10px;\n");
      out.write("                right: -32%;\n");
      out.write("            }\n");
      out.write("            #printableArea{\n");
      out.write("                border: 1px solid black;\n");
      out.write("                box-shadow: 5px transparent;\n");
      out.write("                width: 60%;\n");
      out.write("                height: auto;\n");
      out.write("                margin: 0% 20%;\n");
      out.write("                margin-top: 0px;\n");
      out.write("                background-color: white;\n");
      out.write("                position: relative;\n");
      out.write("            }\n");
      out.write("             #div2{\n");
      out.write("                 background-color: lightgrey;\n");
      out.write("                 width: 100%;\n");
      out.write("                 height: 30px;\n");
      out.write("             }\n");
      out.write("             .glyphicon-off{\n");
      out.write("                 margin: 10px;\n");
      out.write("                 font-size: 15px;\n");
      out.write("                 color: yellow;\n");
      out.write("                 position: absolute;\n");
      out.write("                 right: 10px;\n");
      out.write("                 text-decoration: none;\n");
      out.write("             }\n");
      out.write("             .glyphicon-home{\n");
      out.write("                 margin: 10px;\n");
      out.write("                 font-size: 15px;\n");
      out.write("                 color: white;\n");
      out.write("                 position: absolute;\n");
      out.write("                 right: 40px;\n");
      out.write("                 text-decoration: none;\n");
      out.write("             }\n");
      out.write("             #table1,tr{\n");
      out.write("               width:100%;\n");
      out.write("               margin-left: 5px;\n");
      out.write("               margin-top: 3%;\n");
      out.write("             }\n");
      out.write("             #table3{\n");
      out.write("                 margin-top: 1%;\n");
      out.write("                 margin-bottom: 3px;\n");
      out.write("             }\n");
      out.write("             #table3 th{\n");
      out.write("                 height: 30px;\n");
      out.write("             }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
            
      out.write("\n");
      out.write("            <div id=\"div3\">\n");
      out.write("              <div id=\"div2\">\n");
      out.write("                <span><a class=\"glyphicon glyphicon-home\" href=\"welcomestudent.jsp\"></a></span>\n");
      out.write("                <span><a class=\"glyphicon glyphicon-off\" href=\"logoutservlet\"></a></span>\n");
      out.write("              </div>\n");
      out.write("        <div id=\"printableArea\">\n");
      out.write("        <img id=\"img1\" src=\"medicaps-logo.jpg\" style=\"width:15%;height: 140px;display: inline-block\">\n");
      out.write("        <div id=\"div1\">\n");
      out.write("            <h2 id=\"h1\">Medi-Caps University,Indore</h2>\n");
      out.write("            <h3 id=\"h2\">Course Registration Slip</h3>\n");
      out.write("        </div>\n");
      out.write("            <img id=\"img2\" src=\"");
      out.print(path);
      out.write("\">\n");
      out.write("            <hr style=\"border: 1px solid black\">\n");
      out.write("            ");

                int totalcre=0;
            Connection connec=Mysql.MySqlConnection.getconnection();
            PreparedStatement prep=connec.prepareStatement("select credit from result where userid='"+session.getAttribute("userid")+"' and grade!='fail'");
            ResultSet resu=prep.executeQuery();
            while(resu.next()){
            totalcre=totalcre+Integer.valueOf(resu.getString(1));    
            }
            
      out.write("\n");
      out.write("        ");
  String sqli="select userid,name,email,stream,branch,class,sem,photo from register where userid='"+session.getAttribute("userid")+"'";
            String urli="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection(urli,"root","root");
            PreparedStatement pse=conn.prepareStatement(sqli);
            ResultSet res=pse.executeQuery();
            
      out.write("\n");
      out.write("            <table  id=\"table1\">\n");
      out.write("             ");
 while(res.next()){
      out.write("\n");
      out.write("             <tr>\n");
      out.write("                 <td>Enrollment NO.</td>\n");
      out.write("                 <td><input type=\"text\" name=\"enrollment\" value=\"");
      out.print(res.getString(1));
      out.write("\" disabled=\"disabled\"></td>\n");
      out.write("                 <td>Branch</td>\n");
      out.write("                 <td><input type=\"text\" name=\"branch\" value=\"");
      out.print(res.getString(5));
      out.write("\" disabled=\"disabled\"></td>\n");
      out.write("             </tr>\n");
      out.write("             <tr>\n");
      out.write("                 <td>Name</td>\n");
      out.write("                 <td><input type=\"text\" name=\"name\" value=\"");
      out.print(res.getString(2));
      out.write("\" disabled=\"disabled\"></td> \n");
      out.write("                 <td>Class</td>\n");
      out.write("                 <td><input type=\"text\" name=\"clas\" value=\"");
      out.print(res.getString(6));
      out.write("\" disabled=\"disabled\"></td>    \n");
      out.write("             </tr>\n");
      out.write("             <tr>\n");
      out.write("                 <td>Email</td>\n");
      out.write("                 <td><input type=\"text\" name=\"email\" value=\"");
      out.print(res.getString(3));
      out.write("\" disabled=\"disabled\"></td> \n");
      out.write("                 <td>Stream</td>\n");
      out.write("                 <td><input type=\"text\" name=\"stream\" value=\"");
      out.print(res.getString(4));
      out.write("\" disabled=\"disabled\"></td>\n");
      out.write("             </tr>\n");
      out.write("             <tr>\n");
      out.write("                 <td>Semester</td>\n");
      out.write("                 <td><input type=\"text\" name=\"email\" value=\"");
      out.print(res.getString(7));
      out.write("\" disabled=\"disabled\"></td> \n");
      out.write("                 <td><b>Total Earned Credits Up till Now:</b></td>\n");
      out.write("                 <td><input type=\"text\" name=\"stream\" value=\"");
      out.print(totalcre);
      out.write("\" disabled=\"disabled\"></td>\n");
      out.write("             </tr>\n");
      out.write("             ");
}
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <b><p>List Of Registered Courses:-</p></b>\n");
      out.write("            ");
 
            int totalcredit=0;
            String sq="select scholar_no,name,email,phno,password,userid,register.stream,register.branch,register.sem,course_code,course_name,credit,studentsubject.sem from studentsubject left join register on register.sem=studentsubject.sem and register.userid=studentsubject.enrollment_no  where userid='"+session.getAttribute("userid")+"'";
            String ur="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection co=DriverManager.getConnection(ur,"root","root");
            PreparedStatement p=co.prepareStatement(sq);
            ResultSet r=p.executeQuery();
            
      out.write("\n");
      out.write("            <form action=\"courseregistrationpdf\" method=\"post\">\n");
      out.write("              <table id=\"table3\" border=\"1\" width=\"99%\" align=\"center\">\n");
      out.write("                  ");

                      int total=0;
            String s="select userid,name,email,stream,branch,class,sem from register where userid='"+session.getAttribute("userid")+"'";
            String u="jdbc:mysql://localhost:3306/studant";
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection(u,"root","root");
            PreparedStatement pre=c.prepareStatement(s);
            ResultSet result=pre.executeQuery();
            
      out.write("\n");
      out.write("                  ");
while(result.next()){
      out.write("\n");
      out.write("                  <tr style=\"display:none\">\n");
      out.write("                 <td>Sem</td>\n");
      out.write("                 <td><input type=\"text\" name=\"sem\" value=\"");
      out.print(result.getString(7));
      out.write("\"></td></tr>\n");
      out.write("                  ");
}
      out.write("\n");
      out.write("                  <tr>\n");
      out.write("                      <th></th>\n");
      out.write("                      <th>Course Code</th>\n");
      out.write("                      <th>Course Name</th>\n");
      out.write("                      <th>Credits</th>\n");
      out.write("                      <th>Semester</th>\n");
      out.write("                  </tr>\n");
      out.write("                      ");
 while(r.next()){
      out.write("\n");
      out.write("                  <tr>\n");
      out.write("                      <td id=\"td1\"><input class=\"input2\" type=\"checkbox\" value=\"yes\" name=\"checkbox\" checked=\"checked\" disabled=\"disabled\"></td>\n");
      out.write("                      <td>");
      out.print(r.getString(10));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(r.getString(11));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(r.getString(12));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print(r.getString(9));
      out.write("</td>\n");
      out.write("                      ");
total=total+Integer.valueOf(r.getString(13).substring(0,1));
      out.write("\n");
      out.write("                      ");
totalcredit=totalcredit+Integer.valueOf(r.getString(12));
      out.write("\n");
      out.write("                  </tr>\n");
      out.write("                   ");
}
      out.write("\n");
      out.write("                   <input id=\"btn1\" type=\"button\" name=\"submit\" value=\"Save\" onclick=\"location.href='courseregistrationpdf'\">\n");
      out.write("                   <input id=\"btn2\" type=\"button\" onclick=\"printDiv('printableArea')\" value=\"print\" />\n");
      out.write("              </table>\n");
      out.write("                  <b><span style=\"margin-left: 3%;font-size: 16px\">Total Credit Applied For:</span></b>\n");
      out.write("                  <b><span style=\"margin-left: 50%;font-size: 16px\">");
      out.print(totalcredit);
      out.write("</span></b>\n");
      out.write("                  <hr style=\"border-style: inset;border-width: 1px;color: black;margin-top: 0.2em;margin-bottom: 0.2em\">\n");
      out.write("                  <b><span style=\"font-size: 14px\">Important Points:-</span></b>\n");
      out.write("                  <hr style=\"border-style: inset;border-width: 1px;color: black;margin-top: 0.2em;margin-bottom: 0.2em\">\n");
      out.write("                  <P style=\"color: skyblue\">1.The courses in which you wish to appear in Makeup sem MUST be registered either in EVEN or ODD sem.A non registered course of EVEN/ODD sem will not be visible on Makeup Registration Page.</p>\n");
      out.write("                  <hr style=\"border-style: inset;border-width: 1px;color: black;margin-top: 0.2em;margin-bottom: 0.2em\">\n");
      out.write("                  <p style=\"color:red\">2.SELECT COURSES CAREFULLY.FIRST VERIFY THE COURSE CODES FROM THE SCHEME.</p>\n");
      out.write("                  <hr style=\"border-style: inset;border-width: 1px;color: black;margin-top: 0.2em;margin-bottom: 0.2em\">\n");
      out.write("                  <p style=\"color: red;\">3.The same photograph will be seen on your Marksheets & Degree,which you will have to submit for job interviews.</p>\n");
      out.write("                 \n");
      out.write("                    </form>\n");
      out.write("                   </div>\n");
      out.write("            </div>\n");
      out.write("                  <script>\n");
      out.write("                      function printDiv(divName) {\n");
      out.write("     var printContents = document.getElementById(divName).innerHTML;\n");
      out.write("     var originalContents = document.body.innerHTML;\n");
      out.write("     document.body.innerHTML = printContents;\n");
      out.write("     window.print();\n");
      out.write("     document.body.innerHTML = originalContents;\n");
      out.write("}\n");
      out.write("                  </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
