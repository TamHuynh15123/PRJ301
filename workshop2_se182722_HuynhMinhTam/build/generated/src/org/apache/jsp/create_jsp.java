package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dto.ExamCategoriesDTO;
import java.util.List;
import dto.userDTO;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css.css\">\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
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
      out.write("        <div class=\"container\">\n");
      out.write("        <h2>Create New Exam</h2>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <p class=\"form-error\">\n");
      out.write("            ");
      out.print( (request.getAttribute("message") != null) ? request.getAttribute("message") : "");
      out.write("\n");
      out.write("        </p>\n");
      out.write("        <div class=\"form-container\">\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"createExam\">\n");
      out.write("\n");
      out.write("            <label class=\"form-label\">Exam Title:</label>\n");
      out.write("            <input class=\"form-input\" type=\"text\" name=\"examTitle\" value=\"");
      out.print( (request.getAttribute("examTitle") != null) ? request.getAttribute("examTitle") : "");
      out.write("\">\n");
      out.write("            <span style=\"color:red;\">");
      out.print( (request.getAttribute("examTitleError") != null) ? request.getAttribute("examTitleError") : "");
      out.write("</span>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <label class=\"form-label\">Subject:</label>\n");
      out.write("            <input class=\"form-input\" type=\"text\" name=\"subject\" value=\"");
      out.print( (request.getAttribute("subject") != null) ? request.getAttribute("subject") : "");
      out.write("\">\n");
      out.write("            <span class=\"form-error\"\">");
      out.print( (request.getAttribute("subjectError") != null) ? request.getAttribute("subjectError") : "");
      out.write("</span>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <label class=\"form-label\">Category:</label>\n");
      out.write("            <select class=\"form-input\" name=\"categoryId\">\n");
      out.write("                <option value=\"\">-- Select Category --</option>\n");
      out.write("                ");

                    List<ExamCategoriesDTO> categories = (List<ExamCategoriesDTO>) request.getAttribute("categories");
                    if (categories != null) {
                        for (ExamCategoriesDTO category : categories) {
                            String selected = (request.getAttribute("categoryId") != null
                                    && request.getAttribute("categoryId").equals(String.valueOf(category.getCategoryId())))
                                    ? "selected" : "";
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print( category.getCategoryId());
      out.write('"');
      out.write(' ');
      out.print( selected);
      out.write('>');
      out.print( category.getCategoryName());
      out.write("</option>\n");
      out.write("                ");

                        }
                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <span class=\"form-error\"\">");
      out.print( (request.getAttribute("categoryError") != null) ? request.getAttribute("categoryError") : "");
      out.write("</span>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <label class=\"form-label\">Total Marks:</label>\n");
      out.write("            <input class=\"form-input\" type=\"number\" name=\"totalMarks\" min=\"1\" max=\"10\" value=\"");
      out.print( (request.getAttribute("totalMarks") != null) ? request.getAttribute("totalMarks") : "");
      out.write("\">\n");
      out.write("            <span class=\"form-error\">");
      out.print( (request.getAttribute("totalMarksError") != null) ? request.getAttribute("totalMarksError") : "");
      out.write("</span>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <label class=\"form-label\">Duration (minutes):</label>\n");
      out.write("            <input class=\"form-input\" type=\"number\" name=\"duration\" min=\"15\" value=\"");
      out.print( (request.getAttribute("duration") != null) ? request.getAttribute("duration") : "");
      out.write("\">\n");
      out.write("            <span class=\"form-error\">");
      out.print( (request.getAttribute("durationError") != null) ? request.getAttribute("durationError") : "");
      out.write("</span>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("            <button type=\"submit\">Create Exam</button>\n");
      out.write("        </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <a href=\"MainController?action=viewExamCategories\">Back to Exam Categories</a>\n");
      out.write("        </div>\n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <h1>403 Error</h1>\n");
      out.write("        <p>You do not have permission to access this content!</p>\n");
      out.write("        <a href=\"MainController?action=viewExamCategories\" class=\"back-link\">Back to List</a>\n");
      out.write("        </div>\n");
      out.write("        ");
}
        } else {
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("        <h1>Access Denied</h1>\n");
      out.write("        <p>Please log in to access this page.</p>\n");
      out.write("        <a href=\"login.jsp\" class=\"back-link\">Go to Login</a>\n");
      out.write("        </div>\n");
      out.write("        ");
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
}
