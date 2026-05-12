package org.example.controller.userOrder;

import org.example.dto.dto.ArchivedUserOrderDTO;
import org.example.postConverters.ConverterPost;
import org.example.service.archivedUserOrder.ArchivedUserOrderService;
import org.example.service.archivedUserOrder.ArchivedUserOrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.util.NamesUtil.SHOW_ARCHIVED_ORDERS_JSP;
import static org.example.util.NamesUtil.SHOW_USERS_ORDER_HISTORY;

@WebServlet(SHOW_USERS_ORDER_HISTORY)
public class ShowUsersOrderHistory extends HttpServlet {
    private ArchivedUserOrderService archivedUserOrderService = new ArchivedUserOrderServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConverterPost converterPost = new ConverterPost(request);
        Integer userId = converterPost.convertSessionAttribute("userId");
        List<ArchivedUserOrderDTO> archivedUserOrderDTOList = archivedUserOrderService.showArchivedUserOrders(userId);
        request.setAttribute("archivedUserOrderDTOList", archivedUserOrderDTOList);
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(SHOW_ARCHIVED_ORDERS_JSP);
        dispatcher1.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
