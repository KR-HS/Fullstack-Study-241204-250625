/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.100
 * Generated at: 2025-03-20 02:23:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mygroup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <!-- <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"> -->\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=400, initial-scale=1, maximum-scale=1, user-scalable=no\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/link.html", out, false);
      out.write("\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/mygroup.css\">\r\n");
      out.write("	<script src=\"js/mygroup.js\" defer></script>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    \r\n");
      out.write("<div class='wrap'>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/header.html", out, false);
      out.write("   \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("    <div id=\"contents\">\r\n");
      out.write("        <h6>내 그룹보기</h6>\r\n");
      out.write("        <div class=\"mygroup\">\r\n");
      out.write("            <div class=\"group\">\r\n");
      out.write("                <div class=\"groupinfo\">\r\n");
      out.write("                   <div class=\"groupCreator\">\r\n");
      out.write("                       <img src=\"img/profile.jpg\" alt=\"#\"> \r\n");
      out.write("                       <p>rivermoon___</p>\r\n");
      out.write("                   </div>\r\n");
      out.write("                   <div class=\"groupDate\">24.09.08 ~ 24.09.19</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"groupimg\">\r\n");
      out.write("                    <div class=\"groupimgInfo\">\r\n");
      out.write("                        <div class=\"titleWrap\">\r\n");
      out.write("                            <p class=\"titleOpen\">\"</p>\r\n");
      out.write("                            <p class=\"title\">날이 좋아서, 날이 좋지 않아서, 날이 적당해서 모든 날이 좋았다.</p>\r\n");
      out.write("                            <p class=\"titleClose\">\"</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <p class=\"groupName\">그룹명</p>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"groupmember\">\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member1\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member2\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member3\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member4\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member5\"></span>\r\n");
      out.write("                 </div>\r\n");
      out.write("                 <div class=\"grouptag\">\r\n");
      out.write("                    <p>#활발</p>\r\n");
      out.write("                    <p>#여름</p>\r\n");
      out.write("                    <p>#카페</p>\r\n");
      out.write("                    <p>#맑음</p>\r\n");
      out.write("                 </div>\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("           </div>\r\n");
      out.write("            <div class=\"group\">\r\n");
      out.write("                <div class=\"groupinfo\">\r\n");
      out.write("                   <div class=\"groupCreator\">\r\n");
      out.write("                       <img src=\"img/profile.jpg\" alt=\"#\">\r\n");
      out.write("                       <p>rivermoon___</p>\r\n");
      out.write("                   </div>\r\n");
      out.write("                   <div class=\"groupDate\">24.09.08 ~ 24.09.19</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"groupimg\">\r\n");
      out.write("                    <div class=\"groupimgInfo\">\r\n");
      out.write("                        <div class=\"titleWrap\">\r\n");
      out.write("                            <p class=\"titleOpen\">\"</p>\r\n");
      out.write("                            <p class=\"title\">날이 좋아서, 날이 좋지 않아서, 날이 적당해서 모든 날이 좋았다.</p>\r\n");
      out.write("                            <p class=\"titleClose\">\"</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <p class=\"groupName\">그룹명</p>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"groupmember\">\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member1\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member2\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member3\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member4\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member5\"></span>\r\n");
      out.write("                 </div>\r\n");
      out.write("                 <div class=\"grouptag\">\r\n");
      out.write("                    <p>#활발</p>\r\n");
      out.write("                    <p>#여름</p>\r\n");
      out.write("                    <p>#카페</p>\r\n");
      out.write("                    <p>#맑음</p>\r\n");
      out.write("                 </div>\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("           </div>\r\n");
      out.write("            <div class=\"group\">\r\n");
      out.write("                <div class=\"groupinfo\">\r\n");
      out.write("                   <div class=\"groupCreator\">\r\n");
      out.write("                       <img src=\"img/profile.jpg\" alt=\"#\">\r\n");
      out.write("                       <p>rivermoon___</p>\r\n");
      out.write("                   </div>\r\n");
      out.write("                   <div class=\"groupDate\">24.09.08 ~ 24.09.19</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"groupimg\">\r\n");
      out.write("                    <div class=\"groupimgInfo\">\r\n");
      out.write("                        <div class=\"titleWrap\">\r\n");
      out.write("                            <p class=\"titleOpen\">\"</p>\r\n");
      out.write("                            <p class=\"title\">날이 좋아서, 날이 좋지 않아서, 날이 적당해서 모든 날이 좋았다.</p>\r\n");
      out.write("                            <p class=\"titleClose\">\"</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <p class=\"groupName\">그룹명</p>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"groupmember\">\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member1\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member2\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member3\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member4\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member5\"></span>\r\n");
      out.write("                 </div>\r\n");
      out.write("                 <div class=\"grouptag\">\r\n");
      out.write("                    <p>#활발</p>\r\n");
      out.write("                    <p>#여름</p>\r\n");
      out.write("                    <p>#카페</p>\r\n");
      out.write("                    <p>#맑음</p>\r\n");
      out.write("                 </div>\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("           </div>\r\n");
      out.write("            <div class=\"group\">\r\n");
      out.write("                <div class=\"groupinfo\">\r\n");
      out.write("                   <div class=\"groupCreator\">\r\n");
      out.write("                       <img src=\"img/profile.jpg\" alt=\"#\">\r\n");
      out.write("                       <p>rivermoon___</p>\r\n");
      out.write("                   </div>\r\n");
      out.write("                   <div class=\"groupDate\">24.09.08 ~ 24.09.19</div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"groupimg\">\r\n");
      out.write("                    <div class=\"groupimgInfo\">\r\n");
      out.write("                        <div class=\"titleWrap\">\r\n");
      out.write("                            <p class=\"titleOpen\">\"</p>\r\n");
      out.write("                            <p class=\"title\">날이 좋아서, 날이 좋지 않아서, 날이 적당해서 모든 날이 좋았다.</p>\r\n");
      out.write("                            <p class=\"titleClose\">\"</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <p class=\"groupName\">그룹명</p>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"groupmember\">\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member1\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member2\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member3\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member4\"></span>\r\n");
      out.write("                    <span><img src=\"img/profile.jpg\" alt=\"#\" class=\"member5\"></span>\r\n");
      out.write("                 </div>\r\n");
      out.write("                 <div class=\"grouptag\">\r\n");
      out.write("                    <p>#활발</p>\r\n");
      out.write("                    <p>#여름</p>\r\n");
      out.write("                    <p>#카페</p>\r\n");
      out.write("                    <p>#맑음</p>\r\n");
      out.write("                 </div>\r\n");
      out.write("\r\n");
      out.write("                \r\n");
      out.write("           </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div>       \r\n");
      out.write("    </div>\r\n");
      out.write("		");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "include/footer.html", out, false);
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
