package org.example.controller.product;

import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NameUtils2.*;


@WebServlet("/" + EDIT_CATALOG)
public class EditCatalog extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + GET_ALL_PRODUCTS);
        dispatcher.include(request, response);
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/superUser/product/" + EDIT_CATALOG_JSP);
        dispatcher1.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
