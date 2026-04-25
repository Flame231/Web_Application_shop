package org.example.controller.product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.example.util.NamesUtil.*;

@WebServlet(EDIT_PRODUCT_ROOT)
public class EditProduct extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(GET_ALL_PRODUCTS_ROOT);
        dispatcher.include(request,response);
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(EDIT_PRODUCT_JSP_ROOT);
        dispatcher1.forward(request,response);
    }
}
