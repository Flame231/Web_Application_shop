package org.example.controller.postConverters;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.*;


@WebServlet(EDIT_PRODUCT_CATEGORIES_ROOT)
public class EditCategories extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(GET_PRODUCT_CATEGORIES_ROOT);
        dispatcher1.include(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(EDIT_PRODUCT_CATEGORIES_JSP);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



