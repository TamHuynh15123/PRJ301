package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.userDTO;

public final class question_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                font-family: Arial, sans-serif;\n");
      out.write("                background-color: #f4f4f4;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 20px;\n");
      out.write("            }\n");
      out.write("            .container {\n");
      out.write("                max-width: 600px;\n");
      out.write("                margin: auto;\n");
      out.write("                background: #fff;\n");
      out.write("                padding: 20px;\n");
      out.write("                border-radius: 8px;\n");
      out.write("                box-shadow: 0 0 10px rgba(0,0,0,0.1);\n");
      out.write("            }\n");
      out.write("            h2 {\n");
      out.write("                text-align: center;\n");
      out.write("                color: #333;\n");
      out.write("            }\n");
      out.write("            label {\n");
      out.write("                display: block;\n");
      out.write("                margin-top: 15px;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            input, textarea, select {\n");
      out.write("                width: 100%;\n");
      out.write("                padding: 8px;\n");
      out.write("                margin-top: 5px;\n");
      out.write("                border: 1px solid #ccc;\n");
      out.write("                border-radius: 4px;\n");
      out.write("            }\n");
      out.write("            button {\n");
      out.write("                margin-top: 20px;\n");
      out.write("                padding: 10px;\n");
      out.write("                width: 100%;\n");
      out.write("                background-color: #009879;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 4px;\n");
      out.write("                color: #fff;\n");
      out.write("                font-size: 16px;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            button:hover {\n");
      out.write("                background-color: #007f66;\n");
      out.write("            }\n");
      out.write("            a {\n");
      out.write("                display: block;\n");
      out.write("                text-align: center;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                color: #009879;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("            a:hover {\n");
      out.write("                color: #007f66;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <style>\n");
      out.write("            /* Header Styles */\n");
      out.write("            .user-section {\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: space-between;\n");
      out.write("                align-items: center;\n");
      out.write("                background: #2c3e50;\n");
      out.write("                padding: 15px 20px;\n");
      out.write("                color: white;\n");
      out.write("                border-bottom: 3px solid #3498db;\n");
      out.write("                font-size: 18px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .welcome-text {\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .user-name {\n");
      out.write("                color: #f1c40f;\n");
      out.write("                font-weight: bold;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Logout Button */\n");
      out.write("            .logout-btn {\n");
      out.write("                background: #e74c3c;\n");
      out.write("                color: white;\n");
      out.write("                border: none;\n");
      out.write("                padding: 8px 15px;\n");
      out.write("                font-size: 16px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                cursor: pointer;\n");
      out.write("                transition: 0.3s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .logout-btn:hover {\n");
      out.write("                background: #c0392b;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        ");
 if (session.getAttribute("user") != null) {
                userDTO user = (userDTO) session.getAttribute("user");
                if (user.getRole().equals("Instructor")) {
        
      out.write("\n");
      out.write("        <h2>Add a New Question</h2>\n");
      out.write("\n");
      out.write("        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"MainController\" method=\"post\" class=\"container\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"createExam\">\n");
      out.write("\n");
      out.write("            <label class=\"label\">Exam ID:</label>\n");
      out.write("            <input type=\"hidden\" name=\"exam_id\" value=\"");
      out.print( request.getParameter("exam_id"));
      out.write("\" >\n");
      out.write("\n");
      out.write("                <label for=\"question_text\">Question Text:</label>\n");
      out.write("                <textarea id=\"question_text\" name=\"question_text\" rows=\"4\" required></textarea>\n");
      out.write("\n");
      out.write("            <label for=\"option_a\">Option A:</label>\n");
      out.write("                <input type=\"text\" id=\"option_a\" name=\"option_a\" required />\n");
      out.write("\n");
      out.write("                <label for=\"option_b\">Option B:</label>\n");
      out.write("                <input type=\"text\" id=\"option_b\" name=\"option_b\" required />\n");
      out.write("\n");
      out.write("                <label for=\"option_c\">Option C:</label>\n");
      out.write("                <input type=\"text\" id=\"option_c\" name=\"option_c\" required />\n");
      out.write("\n");
      out.write("                <label for=\"option_d\">Option D:</label>\n");
      out.write("                <input type=\"text\" id=\"option_d\" name=\"option_d\" required />\n");
      out.write("\n");
      out.write("            <label class=\"label\">Correct Option (A/B/C/D):</label>\n");
      out.write("            <input type=\"text\" name=\"correct_option\" class=\"input\" maxlength=\"1\" pattern=\"[A-D]\" title=\"Only A, B, C, or D allowed\" required><br>\n");
      out.write("\n");
      out.write("            <button type=\"submit\" class=\"button\">Add Question</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <a href=\"MainController?action=addQuestion\">Back to Exam Categories</a>\n");
      out.write("\n");
      out.write("        ");
}
        }
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty sessionScope.user}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <div class=\"user-section\">\n");
        out.write("                <span class=\"welcome-text\">Welcome, <span class=\"user-name\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span>!</span>\n");
        out.write("                <form action=\"MainController\" method=\"post\" style=\"margin: 0;\">\n");
        out.write("                    <input type=\"hidden\" name=\"action\" value=\"logout\"/>\n");
        out.write("                    <input type=\"submit\" value=\"Log out\" class=\"logout-btn\"/>\n");
        out.write("                </form>\n");
        out.write("            </div>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty message}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            <p>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
