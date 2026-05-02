package org.example.controller.productCategory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.ADD_PRODUCT_CATEGORY_JSP;
import static org.example.util.NamesUtil.ADD_PRODUCT_CATEGORY_PAGE;


@WebServlet(ADD_PRODUCT_CATEGORY_PAGE)
public class AddProductCategoryPage extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADD_PRODUCT_CATEGORY_JSP);
        dispatcher.forward(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}







