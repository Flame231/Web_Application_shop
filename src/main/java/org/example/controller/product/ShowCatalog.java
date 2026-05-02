package org.example.controller.product;

import org.example.postConverters.ConverterPost;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.*;


@WebServlet(SHOW_CATALOG)
public class ShowCatalog extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher includeDispatcher = getServletContext().getRequestDispatcher(GET_ALL_PRODUCTS);
        includeDispatcher.include(request, response);
        ConverterPost converterPost = new ConverterPost(request);
        Integer userId = converterPost.convertParameter("userId", Integer.class);
        request.getSession().setAttribute("user", userService.getUserDTO(userId));
        RequestDispatcher forwardDispatcher = getServletContext().getRequestDispatcher(CATALOG_JSP);
        forwardDispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
