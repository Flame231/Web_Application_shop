package org.example.controller.userOrder;

import org.example.postConverters.ConverterPost;
import org.example.service.userOrder.UserOrderService;
import org.example.service.userOrder.UserOrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.SHOW_ORDER_POINT_ORDER_PAGE;
import static org.example.util.NamesUtil.SHOW_ORDER_POINT_ORDER_PAGE_JSP;

@WebServlet(SHOW_ORDER_POINT_ORDER_PAGE)
public class ShowOrderPointOrderPage extends HttpServlet {
    private UserOrderService userOrderService = new UserOrderServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConverterPost converterPost = new ConverterPost(request);
        Integer userOrderId = converterPost.convertParameter("userOrderId", Integer.class);
        request.setAttribute("userOrderDTO", userOrderService.getUserOrderDTO(userOrderId));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(SHOW_ORDER_POINT_ORDER_PAGE_JSP);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
