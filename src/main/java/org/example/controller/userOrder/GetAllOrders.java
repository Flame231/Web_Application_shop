package org.example.controller.userOrder;

import org.example.dto.UserOrderDTO;
import org.example.service.userOrder.UserOrderService;
import org.example.service.userOrder.UserOrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.example.util.NamesUtil.GET_ALL_USER_ORDERS;

@WebServlet("/" + GET_ALL_USER_ORDERS)
public class GetAllOrders extends HttpServlet {
    UserOrderService userOrderService = new UserOrderServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        List<UserOrderDTO> list = userOrderService.showAllUserOrders();
        request.setAttribute("userOrderDTOList", list);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
