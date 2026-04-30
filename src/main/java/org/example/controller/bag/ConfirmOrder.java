package org.example.controller.bag;

import org.example.controller.postConverters.PostToNewOrderDTO;
import org.example.dto.NewOrderDTO;
import org.example.service.userOrder.UserOrderService;
import org.example.service.userOrder.UserOrderServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.util.NameUtils2.CONFIRM_ORDER;
import static org.example.util.NameUtils2.SHOW_USER_ORDERS;

@WebServlet("/" + CONFIRM_ORDER)
public class ConfirmOrder extends HttpServlet {
    UserOrderService userOrderService = new UserOrderServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<NewOrderDTO> list = PostToNewOrderDTO.toNewOrderDTO(request);
        userOrderService.confirmOrder(list);
        response.sendRedirect(request.getContextPath() + "/" +  SHOW_USER_ORDERS);
    }

    public void goGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
