package org.example.connector;

import org.example.model.user.Role;
import org.example.util.HibernateUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.util.NamesUtil.*;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getServletPath();
        HttpSession session = httpRequest.getSession(false);
        System.out.println("DEBUG: Request Path = " + path);

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            if (path.equals(LOGIN_JSP) || path.equals(REGISTRATION_JSP) ||
                    (path.equals("/" + AUTHORIZE_USER)) || path.endsWith(REGISTER_USER)
                    || path.endsWith(LOGOUT_USER)) {
                chain.doFilter(request, response);
            } else if (session != null && session.getAttribute("userId") != null) {
                Role role = (Role) session.getAttribute("userRole");
                if (path.startsWith("/client") && role.name().equals("CLIENT") ||
                        path.startsWith("/administrator") && role.name().equals("ADMINISTRATOR") ||
                        path.startsWith("/operator") && role.name().equals("OPERATOR")) {
                    chain.doFilter(request, response);
                }
            } else {
                HttpServletResponse response1 = (HttpServletResponse) response;
                response1.sendRedirect(httpRequest.getContextPath() + LOGIN_JSP);
            }
        } finally {
            HibernateUtil.closeEntityManager();
        }
    }
}
