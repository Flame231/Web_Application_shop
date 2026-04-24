package org.example.connector;

import org.example.util.HibernateUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class JpaFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getServletPath();
        HttpSession session = httpRequest.getSession(false);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            if (path.equals("/login.jsp") || (path.equals("/registration.jsp") ||
                    (path.equals("/authorizeUser")) || path.equals("/registerUser") ||
                            (session != null && session.getAttribute("userId") != null)))
            {
                chain.doFilter(request, response);
            }
            else{
                HttpServletResponse response1 = (HttpServletResponse) response;
                response1.sendRedirect("login.jsp");
            }
        } finally {
            HibernateUtil.closeEntityManager();
        }
    }

    @Override
    public void destroy() {
    }
}
