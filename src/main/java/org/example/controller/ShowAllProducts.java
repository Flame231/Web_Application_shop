package org.example.controller;

import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.service.bag.BagService;
import org.example.service.bag.BagServiceImpl;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowAllProducts extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    BagService bagService = new BagServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("bag".equals(request.getParameter("page"))) {
            request.setAttribute("function","bag");
            request.setAttribute("productList",
                    bagService.showAllBags((Integer) request.getSession().getAttribute("userId")));
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/catalog.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("function","catalog");
            request.setAttribute("productList", productService.getAllProducts());
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher("/catalog.jsp");
            dispatcher.forward(request, response);
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
