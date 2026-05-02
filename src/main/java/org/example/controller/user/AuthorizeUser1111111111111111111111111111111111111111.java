package org.example.controller.user;

import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.model.user.Role;
import org.example.postConverters.PostToLoginDTO;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.example.util.NamesUtil.*;

@WebServlet("/" + AUTHORIZE_USER)
public class AuthorizeUser1111111111111111111111111111111111111111 extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDTO loginDTO = PostToLoginDTO.toLoginDTO(request);
        UserDTO userDTO = userService.authorizeUser(loginDTO);
        if (userDTO != null) {
            HttpSession session = request.getSession(true);
            request.changeSessionId();
            session.setAttribute("userId", userDTO.getId());
            session.setAttribute("userRole", userDTO.getRole());
            if (session.getAttribute("userId") != null) {
                Role role = (Role) session.getAttribute("userRole");
                if (role.name().equals(Role.CLIENT.name())) {
                    RequestDispatcher dispatcher = getServletContext()
                            .getRequestDispatcher(ACCOUNT_CLIENT_JSP);
                    dispatcher.forward(request, response);
                } else if (role.name().equals(Role.ADMINISTRATOR.name())) {
                    RequestDispatcher dispatcher = getServletContext()
                            .getRequestDispatcher(ACCOUNT_ADMINISTRATOR_JSP);
                    dispatcher.forward(request, response);
                } else if (role.name().equals(Role.OPERATOR.name())) {
                    RequestDispatcher dispatcher = getServletContext()
                            .getRequestDispatcher(ACCOUNT_OPERATOR_JSP);
                    dispatcher.forward(request, response);
                }
            }
        } else {
            response.sendRedirect(request.getContextPath() + LOGIN_JSP);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
