/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package filters;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

/**
 *
 * @author chait
 */
@WebFilter({"/dash.jsp", "/submitQuery.jsp", "/list"})
public class authFltr implements Filter {


@Override
public void doFilter(ServletRequest req, ServletResponse res,
                     FilterChain chain)
        throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    HttpSession session = request.getSession(false);

    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login");
        return;
    }

    chain.doFilter(request, response);
}}