package org.example.controller.userOrder;

import org.example.postConverters.ConverterPost;
import org.example.service.userOrderProduct.UserOrderProductService;
import org.example.service.userOrderProduct.UserOrderProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.CHANGE_BAG;
import static org.example.util.NamesUtil.SHOW_ORDER_POINT_ORDER_PAGE;

@WebServlet(CHANGE_BAG)
public class ChangeBag extends HttpServlet {
    UserOrderProductService userOrderProductService = new UserOrderProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConverterPost converterPost = new ConverterPost(request);
        Integer count = converterPost.convertParameter("count", Integer.class);
        Integer userOrderId = converterPost.convertParameter("userOrderId", Integer.class);
        Integer productId = converterPost.convertParameter("productId", Integer.class);
        userOrderProductService.changeProductCount(userOrderId, productId, count);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(SHOW_ORDER_POINT_ORDER_PAGE);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
