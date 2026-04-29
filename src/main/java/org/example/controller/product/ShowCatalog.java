package org.example.controller.product;

import org.example.controller.postConverters.PostConverter;
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

@WebServlet(SHOW_CATALOG_ROOT)
public class ShowCatalog extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(GET_ALL_PRODUCTS_ROOT);
        dispatcher.include(request, response);
        PostConverter postConverter = new PostConverter(request);
        Integer userId = postConverter.convert("userId", Integer.class);
        request.getSession().setAttribute("user", userService.getUser(userId));
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(CATALOG_JSP_ROOT);
        dispatcher1.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
