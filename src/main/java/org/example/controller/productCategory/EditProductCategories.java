package org.example.controller.productCategory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.*;


@WebServlet(EDIT_PRODUCT_CATEGORIES)
public class EditProductCategories extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher includeDispatcher = getServletContext().getRequestDispatcher(GET_ALL_PRODUCT_CATEGORIES);
        includeDispatcher.include(request, response);
        RequestDispatcher forwardDispatcher = getServletContext().getRequestDispatcher(EDIT_PRODUCT_CATEGORIES_JSP);
        forwardDispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



