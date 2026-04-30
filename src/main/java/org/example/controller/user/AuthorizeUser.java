package org.example.controller.user;

import org.example.controller.postConverters.PostToLoginDTO;
import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
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

import static org.example.util.NameUtils2.AUTHORIZE_USER;
import static org.example.util.NamesUtil.ACCOUNT_JSP_ROOT;
import static org.example.util.NamesUtil.LOGIN_JSP;

@WebServlet("/" + AUTHORIZE_USER)
public class AuthorizeUser extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDTO loginDTO = PostToLoginDTO.toLoginDTO(request);
        UserDTO userDTO = userService.authorizeUser(loginDTO);
        System.out.println(userDTO);
        if (userDTO != null) {
            HttpSession session = request.getSession(true);
            request.changeSessionId();
            session.setAttribute("userId", userDTO.getId());
            if (session.getAttribute("userId") != null) {
                RequestDispatcher dispatcher = getServletContext()
                        .getRequestDispatcher(ACCOUNT_JSP_ROOT);
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect(LOGIN_JSP);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
