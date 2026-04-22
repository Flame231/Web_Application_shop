package org.example.controller;

import org.example.service.bag.BagService;
import org.example.service.bag.BagServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowBag extends HttpServlet {
    BagService bagService = new BagServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("BagList",
                bagService.showAllBags((Integer) request.getSession().getAttribute("userId")));
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/bag.jsp");
        dispatcher.forward(request, response);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
