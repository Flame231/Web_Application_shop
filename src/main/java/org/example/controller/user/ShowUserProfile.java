package org.example.controller.user;

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

import static org.example.util.NamesUtil.USER_PROFILE_JSP_ROOT;

@WebServlet("/ShowUserProfile")
public class ShowUserProfile extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("userId");
        UserDTO userDTO = userService.getUserData(id);
        request.setAttribute("userDTO", userDTO);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(USER_PROFILE_JSP_ROOT);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
