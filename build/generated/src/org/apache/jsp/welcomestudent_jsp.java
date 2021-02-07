package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class welcomestudent_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>JSP Page</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width ,initial-scale=1\">\n");
      out.write("        <link href='css/welcome.css' type=\"text/css\" rel=\"stylesheet\">\n");
      out.write("        <style>\n");
      out.write("            #input1{\n");
      out.write("                border-radius: 30px;\n");
      out.write("                position: absolute;\n");
      out.write("                top: 0px;\n");
      out.write("            }\n");
      out.write("            #course{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 90px;\n");
      out.write("                left: 32%;\n");
      out.write("                text-align: center;\n");
      out.write("                background-color:powderblue;\n");
      out.write("                width: 25%;\n");
      out.write("                height: 40px;\n");
      out.write("                border: 1px solid silver; \n");
      out.write("                box-shadow: 2px turquoise;\n");
      out.write("            }\n");
      out.write("            #course1{\n");
      out.write("                position: absolute;\n");
      out.write("                top: 90px;\n");
      out.write("                left: 62%;\n");
      out.write("                text-align: center;\n");
      out.write("                background-color:powderblue;\n");
      out.write("                width: 25%;\n");
      out.write("                height: 40px;\n");
      out.write("                border: 1px solid silver; \n");
      out.write("                box-shadow: 2px turquoise;\n");
      out.write("            }\n");
      out.write("            #a1{\n");
      out.write("                text-decoration: none;\n");
      out.write("                position: relative;\n");
      out.write("                top: 10px; \n");
      out.write("                font-size: 20px;\n");
      out.write("                color: white;\n");
      out.write("                animation-name: a;\n");
      out.write("                animation-iteration-count: infinite;\n");
      out.write("                animation-duration: 1.2s;\n");
      out.write("            }\n");
      out.write("             @keyframes a{\n");
      out.write("                 0%{\n");
      out.write("                     opacity:1;\n");
      out.write("                 }\n");
      out.write("                 100%{\n");
      out.write("                     opacity:0;\n");
      out.write("                 }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("       ");

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
        
      out.write("\n");
      out.write("            <div id=\"div1\">\n");
      out.write("            <header>\n");
      out.write("                <nav>\n");
      out.write("                    <span>\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Scholar NO.</th>\n");
      out.write("                                <th>Stream</th>\n");
      out.write("                                <th>Sem</th>\n");
      out.write("                                <th>Student Name</th>\n");
      out.write("                            </tr>\n");
      out.write("                <tr>\n");
      out.write("                    ");
while(r.next()){
      out.write("\n");
      out.write("                                <td>");
      out.print(r.getInt(1));
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(r.getString(2).toUpperCase());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(r.getString(3).toUpperCase()+" "+r.getString(4).toUpperCase());
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(r.getString(5).toUpperCase());
      out.write("</td>\n");
      out.write("                                <td><img id=\"input1\" src=\"");
      out.print(r.getString(6));
      out.write("\" width=\"60\" height=\"45\"/></td>\n");
      out.write("                                ");
sem=r.getString(4);
      out.write("\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                    </span>\n");
      out.write("                </nav>\n");
      out.write("            </header> \n");
      out.write("                            ");

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
            
      out.write(" \n");
      out.write("            <main>\n");
      out.write("                ");
if(n>0){
      out.write("\n");
      out.write("                <span id=\"course\"><a id=\"a1\" href=\"courseregistrationslip.jsp\">COURSE REGISTRATION FORM</a></span>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
if(n==0){
      out.write("\n");
      out.write("                <span id=\"course\"><a id=\"a1\" href=\"studentsubject.jsp\">COURSE REGISTRATION FORM</a></span>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                <span id=\"course1\"><a id=\"a1\" href=\"result.jsp\">View Result</a></span>\n");
      out.write("                <section>\n");
      out.write("                    <article>\n");
      out.write("                        <h1>Fees Information</h1>\n");
      out.write("                        <a class=\"link\" href=\"receipt.jsp\">fee receipt</a>\n");
      out.write("                        <a class=\"link\" href=\"fee.jsp\">Pay Fee Online</a>\n");
      out.write("                    </article>\n");
      out.write("                    <article>\n");
      out.write("                        <h1>General Information</h1>\n");
      out.write("                        <a class=\"link\" href=\"Academic_Calendar.pdf\">Academic Calender</a>\n");
      out.write("                        <a class=\"link\"href=\"profile.jsp\">Your Profile</a>\n");
      out.write("                    </article>\n");
      out.write("                    <article>\n");
      out.write("                        <h1>Academics</h1>\n");
      out.write("                        <a class=\"link\" href=\"assignment.jsp\">Assignments</a>\n");
      out.write("                        <a class=\"link\" href=\"attendance.jsp\">Attendance SubjectWise</a>\n");
      out.write("                        <a class=\"link\" href=\"attendancedate.jsp\">Attendance DateWise</a>\n");
      out.write("                        <a class=\"link\" href=\"studentassignmentupload.jsp\">Assignments</a>\n");
      out.write("                    </article>\n");
      out.write("                    <article>\n");
      out.write("                        <h1>Bus Information</h1>\n");
      out.write("                        <a class=\"link\" href=\"stop.jsp\">Bus Stops</a>\n");
      out.write("                        <a class=\"link\" href=\"route.jsp\">Bus Routes</a>\n");
      out.write("                    </article>\n");
      out.write("                     </section>\n");
      out.write("                <aside>\n");
      out.write("                    <details>\n");
      out.write("                        <summary>General Information</summary>\n");
      out.write("                        <div style=\"background-color: white;border-radius: 5px;text-align: center\">\n");
      out.write("                        <a class=\"link1\" href='profile.jsp'>Your Profile</a></br>\n");
      out.write("                        <a class=\"link1\" href='Academic_Calendar.pdf'>Academic Calender</a></br>\n");
      out.write("                        <a class=\"link1\" href='news.jsp'>News/Notices</a></br>\n");
      out.write("                        </div>\n");
      out.write("                    </details>\n");
      out.write("                    <details>\n");
      out.write("                        <summary>Academics</summary>\n");
      out.write("                        <div style=\"background-color: white;border-radius: 5px;text-align: center\">\n");
      out.write("                        <a class=\"link1\" href='attendance.jsp'>Exam Schedule</a></br>\n");
      out.write("                        <a class=\"link1\" href='attendance.jsp'>Syllabus</a></br>\n");
      out.write("                        <a class=\"link1\" href='attendancedate.jsp'>Attendance DateWise</a></br>\n");
      out.write("                        <a class=\"link1\"href='attendance.jsp'>Attendance SubjectWise</a><br>\n");
      out.write("                        </div>\n");
      out.write("                    </details>\n");
      out.write("                    <a style=\"color: white;font-size: 24px;margin:20px 10px\" class=\"link\" href='setpassword.jsp'>Change Password</a></br>\n");
      out.write("                  <form action=\"logoutservlet\" method=\"post\">\n");
      out.write("                        <input  style=\"color: white;font-size: 24px;margin:15px 25px;border:solid 0px black;background-color: lightblue;cursor: pointer\" type=\"submit\" value=\"Logout\"></input>\n");
      out.write("                    </form>\n");
      out.write("                </aside>\n");
      out.write("            </main>\n");
      out.write("            <footer>\n");
      out.write("                \n");
      out.write("            </footer>\n");
      out.write("            </div>\n");
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
