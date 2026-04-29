package org.example.controller.bag;

import org.example.service.bag.BagService;
import org.example.service.bag.BagServiceImpl;
import org.example.service.orderPoint.OrderPointService;
import org.example.service.orderPoint.OrderPointServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.BAG_JSP_ROOT;

@WebServlet("/ShowBag")
public class ShowBag extends HttpServlet {
    BagService bagService = new BagServiceImpl();
    OrderPointService orderPointService = new OrderPointServiceImpl();


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("BagList",
                bagService.showAllBags((Integer) request.getSession().getAttribute("userId")));
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(BAG_JSP_ROOT);
        request.setAttribute("orderPointList", orderPointService.getAllOrderPoints());
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
