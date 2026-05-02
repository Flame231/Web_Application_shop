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

import static org.example.util.NamesUtil.BAG_JSP;
import static org.example.util.NamesUtil.SHOW_BAG;

@WebServlet(SHOW_BAG)
public class ShowBag extends HttpServlet {
    private BagService bagService = new BagServiceImpl();
    private OrderPointService orderPointService = new OrderPointServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("BagList", bagService.showAllBags(request));
        request.setAttribute("orderPointList", orderPointService.getAllOrderPoints());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(BAG_JSP);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
