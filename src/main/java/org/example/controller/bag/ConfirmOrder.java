package org.example.controller.bag;

import org.example.controller.postConverters.PostToNewOrderDTO;
import org.example.dto.NewOrderDTO;
import org.example.model.UserOrder;
import org.example.service.userOrder.UserOrderService;
import org.example.service.userOrder.UserOrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/confirmOrder")
public class ConfirmOrder extends HttpServlet {
    UserOrderService userOrderService = new UserOrderServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        NewOrderDTO newOrderDTO = PostToNewOrderDTO.toNewOrderDTO(request);
        userOrderService.confirmOrder(newOrderDTO);
    }

    public void goGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
