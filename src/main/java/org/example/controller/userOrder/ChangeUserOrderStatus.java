package org.example.controller.userOrder;

import org.example.postConverters.ConverterPost;
import org.example.service.archivedUserOrder.ArchivedUserOrderService;
import org.example.service.archivedUserOrder.ArchivedUserOrderServiceImpl;
import org.example.service.userOrder.UserOrderService;
import org.example.service.userOrder.UserOrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.example.util.NamesUtil.*;

@WebServlet(CHANGE_USER_ORDER_STATUS)
public class ChangeUserOrderStatus extends HttpServlet {
    private ArchivedUserOrderService archivedUserOrderService = new ArchivedUserOrderServiceImpl();
    private UserOrderService userOrderService = new UserOrderServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConverterPost converterPost = new ConverterPost(request);
        String orderStatus = converterPost.convertParameter("orderStatus", String.class);
        Integer userOrderId = converterPost.convertParameter("userOrderId", Integer.class);
        if (orderStatus.equals("CLOSED")) {
            archivedUserOrderService.createArchivedUserOrder(userOrderId);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(SHOW_ORDER_POINT_ORDERS);
            dispatcher.forward(request, response);
        } else if (orderStatus.equals("READY")) {
            request.setAttribute("userOrderDTO", userOrderService.getUserOrderDTO(userOrderId));
            archivedUserOrderService.readyUserOrder(userOrderId);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(SHOW_ORDER_POINT_ORDER_PAGE);
            dispatcher.forward(request, response);
        } else if (orderStatus.equals("REFUSED")) {
            archivedUserOrderService.refuseUserOrder(userOrderId);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(SHOW_ORDER_POINT_ORDERS);
            dispatcher.forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
