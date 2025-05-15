package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("    font-family: Arial, sans-serif;\n");
      out.write("    background-color: #f4f4f9;\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: center;\n");
      out.write("    align-items: center;\n");
      out.write("    height: 100vh;\n");
      out.write("    margin: 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("h2 {\n");
      out.write("    text-align: center;\n");
      out.write("    color: #333;\n");
      out.write("}\n");
      out.write("\n");
      out.write("form {\n");
      out.write("    background-color: white;\n");
      out.write("    padding: 20px;\n");
      out.write("    border-radius: 8px;\n");
      out.write("    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);\n");
      out.write("    width: 300px;\n");
      out.write("    display: flex;\n");
      out.write("    flex-direction: column;\n");
      out.write("    align-items: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=\"text\"],\n");
      out.write("input[type=\"password\"] {\n");
      out.write("    width: 100%;\n");
      out.write("    padding: 10px;\n");
      out.write("    margin: 10px 0;\n");
      out.write("    border: 1px solid #ccc;\n");
      out.write("    border-radius: 4px;\n");
      out.write("    font-size: 16px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=\"submit\"] {\n");
      out.write("    background-color: #4CAF50;\n");
      out.write("    color: white;\n");
      out.write("    padding: 10px 20px;\n");
      out.write("    border: none;\n");
      out.write("    border-radius: 4px;\n");
      out.write("    font-size: 16px;\n");
      out.write("    cursor: pointer;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=\"submit\"]:hover {\n");
      out.write("    background-color: #45a049;\n");
      out.write("}\n");
      out.write("\n");
      out.write("h4 {\n");
      out.write("    text-align: center;\n");
      out.write("    font-size: 14px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a {\n");
      out.write("    text-decoration: none;\n");
      out.write("    color: #4CAF50;\n");
      out.write("    font-size: 14px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a:hover {\n");
      out.write("    text-decoration: underline;\n");
      out.write("}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Personal Diary - Login</h2>\n");
      out.write("\n");
      out.write("        <form action=\"MainController\" method=\"post\">\n");
      out.write("            Username: <input type=\"text\" name=\"username\" placeholder=\"Username\"> <br>\n");
      out.write("            Password: <input type=\"password\" name=\"password\" placeholder=\"Password\"> <br>\n");
      out.write("            <input type=\"submit\" value=\"Login\" name=\"action\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <h4 style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("        <h4 style=\"color: green\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.success}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("        <h4 style=\"color: red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.loginAgain}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h4>\n");
      out.write("\n");
      out.write("        <a href=\"MainController?action=InputRegister\">Register</a>\n");
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
