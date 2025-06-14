package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("        /* Định dạng toàn bộ trang */\n");
      out.write("        * {\n");
      out.write("            box-sizing: border-box;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            font-family: 'Poppins', sans-serif;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        body {\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("            background: linear-gradient(to right, #3498db, #8e44ad);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-container {\n");
      out.write("            width: 400px;\n");
      out.write("            background: white;\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 12px;\n");
      out.write("            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.2);\n");
      out.write("            text-align: center;\n");
      out.write("            animation: fadeIn 0.8s ease-in-out;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        @keyframes fadeIn {\n");
      out.write("            from {\n");
      out.write("                opacity: 0;\n");
      out.write("                transform: translateY(-20px);\n");
      out.write("            }\n");
      out.write("            to {\n");
      out.write("                opacity: 1;\n");
      out.write("                transform: translateY(0);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-container h2 {\n");
      out.write("            color: #333;\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-container input {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            margin: 10px 0;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 6px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-container input:focus {\n");
      out.write("            border-color: #3498db;\n");
      out.write("            outline: none;\n");
      out.write("            box-shadow: 0px 0px 5px rgba(52, 152, 219, 0.5);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-container input[type=\"submit\"] {\n");
      out.write("            background: #3498db;\n");
      out.write("            color: white;\n");
      out.write("            font-size: 18px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            cursor: pointer;\n");
      out.write("            border: none;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-container input[type=\"submit\"]:hover {\n");
      out.write("            background: #2980b9;\n");
      out.write("            transform: scale(1.05);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .error-message {\n");
      out.write("            color: red;\n");
      out.write("            font-weight: bold;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"login-container\">\n");
      out.write("        <h2>Login to Exam System</h2>\n");
      out.write("        ");

                String message = request.getAttribute("message") + "";
                message = message.equals("null") ? "" : message;
            
      out.write("\n");
      out.write("        <form action=\"MainController\" method=\"post\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"login\">\n");
      out.write("            <label>Username:</label> <input type=\"text\" name=\"txtUserID\" required><br>\n");
      out.write("            <label>Password:</label> <input type=\"password\" name=\"txtPassword\" required><br>\n");
      out.write("            <input type=\"submit\" value=\"Login\">\n");
      out.write("        </form>\n");
      out.write("        <p style=\"color:red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        </div>\n");
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
