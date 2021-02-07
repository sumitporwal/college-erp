package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Maharishi Insitute Of Technology</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"css/css1.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body id=\"body1\">\n");
      out.write("        <div id=\"bgimg\">\n");
      out.write("                <div class=\"container-fluid\" style=\"background-color: transparent\">\n");
      out.write("                    <span class=\"span1\"><i class=\"fa fa-phone\"></i><a id=\"ph\" href=\"tel:0731-4259500\"><span>0731-4259500</span></a>\n");
      out.write("                           <span class=\"span1\"><i class=\"fa fa-envelope-o\"></i><a id=\"ph\" href=\"mailto:princecr7singh@gmail.com\"><span>princecr7singh@gmail.com</span></a></span>\n");
      out.write("                    <span class=\"span2\"><a id=\"ph\" href=\"register.jsp\">SIGN UP</a></span>\n");
      out.write("                </div>\n");
      out.write("             \n");
      out.write("        <header>\n");
      out.write("         <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("             <div class=\"container-fluid\">\n");
      out.write("                 <div class=\"navbar-brand\">\n");
      out.write("                <a href=\"#\"><img src=\"images/medicaps-logo.jpg\" alt=\"Medi-Caps University Logo\" width=\"80px\" height=\"80px\"></a>\n");
      out.write("                <a id=\"medi\" class=\"navbar-brand text-warning font-weight-bold\" href=\"#\">Medi-Caps University</a>\n");
      out.write("                 </div>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <div class=\"collapse navbar-collapse text-center\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav ml-auto \">\n");
      out.write("                       <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link text-white\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                         <a class=\"nav-link text-white\" href=\"Gallery.jsp\">Gallery <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                         <a class=\"nav-link text-white\" href=\"#\">Contact US <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link text-white\" href=\"#about\">About Us <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link text-white\" href=\"login.jsp\">Login<span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                       </ul>\n");
      out.write("                </div>\n");
      out.write("             </div>\n");
      out.write("           </nav>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"container-fluid text-center text-white headerset\">\n");
      out.write("              <h2>Discover Your Future<br/> With US</h2>\n");
      out.write("        </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("            <div  id=\"about\" class=\"card col-xs-12\">\n");
      out.write("                <img class=\"card-img-top\" src=\"images/group-of-people-in-conference-room-1181304_1.jpg\" style=\"width: 60%;height: 300px;display: inline-block\">\n");
      out.write("                <div class=\"card-body\" id=\"divh2\" style=\"display: inline-block\"><h2 class=\"text-center\">Welcome to Medi-Caps University</h2>\n");
      out.write("                    <p>Medi-Caps has been a brand name in the arena of technical education. Since its inception in July 2000, Medi-Caps has consistently aimed at creating an ideal ambiance for budding technocrats and managers; and helping them to grow like true professionals. With its highly qualified faculty there seems an optimal blend of academic brilliance and industry exposure, supplemented by highly specialized visiting faculty and industry experts, senior professionals from various segments of different industries and business houses. It was time now to spread wings and move out for more exposure and widening of the periphery.\n");
      out.write("                            Hence the foundation of Medi-Caps University has been laid down. With a strong foundation of the Group since 15 years, Medi-Caps University wishes to maintain the same objective of imparting quality education and producing sound professionals for the benefit of the society at large.</p></div>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("            <section class=\"container-fluid sec1\">\n");
      out.write("                        <h2>EVENTS AT COLLEGE</h2>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto\">\n");
      out.write("                        <img class=\"img\" src=\"images/IMG_20200430_104127.jpg\" alt=\"Graduation image\"></div>\n");
      out.write("                        <div class=\"col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto\"><img class=\"img\" src=\"images/classroom.jpg\" alt=\"classroom\"></div>\n");
      out.write("                        <div class=\"col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto\"><img class=\"img\" src=\"images/event.jpg\" alt=\"Event at the college\"></div>\n");
      out.write("                        <div class=\"col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto\"><img class=\"img\" src=\"images/convocation.jpg\" alt=\"convocation\"></div>\n");
      out.write("                        <div class=\"col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto\"><img class=\"img\" src=\"images/alphabet-blur-books-close-up-301920.jpg\" alt=\"Study\"></div>\n");
      out.write("                        <div class=\"col-lg-4 col-md-6 col-sm-6 col-12 d-block m-auto\"><img class=\"img\" src=\"images/visit.jpg\" alt=\"Industrial Visit\"></div>\n");
      out.write("        \n");
      out.write("                        </div>\n");
      out.write("            </section>\n");
      out.write("        <div class=\"container-fluid\" id=\"foot\">\n");
      out.write("        <footer>  \n");
      out.write("            <h3>All Rights Reserved</h3>\n");
      out.write("        </footer>\n");
      out.write("            </div>\n");
      out.write("     <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\n");
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
