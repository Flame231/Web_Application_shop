package org.example.controller.userOrder;

import org.example.dto.UserOrderDTO;
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
import java.util.List;

import static org.example.util.NamesUtil.SHOW_ORDER_POINT_ORDERS;
import static org.example.util.NamesUtil.SHOW_ORDER_POINT_ORDERS_JSP;

@WebServlet(SHOW_ORDER_POINT_ORDERS)
public class ShowOrderPointOrders extends HttpServlet {
    private UserOrderService userOrderService = new UserOrderServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConverterPost converterPost = new ConverterPost(request);
        Integer userId = converterPost.convertSessionAttribute("userId");
        List<UserOrderDTO> userOrderDTOList = userOrderService.showUserOrdersByOrderPoint(userId);
        long count = userOrderDTOList.stream().peek(System.out::println).count();
        request.setAttribute("userOrderDTOList", userOrderDTOList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(SHOW_ORDER_POINT_ORDERS_JSP);
        dispatcher.forward(request, response);
    }
}
