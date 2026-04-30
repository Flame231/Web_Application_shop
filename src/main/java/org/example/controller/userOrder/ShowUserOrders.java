package org.example.controller.userOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NameUtils2.GET_ALL_USER_ORDERS;
import static org.example.util.NameUtils2.SHOW_USER_ORDERS;

@WebServlet("/" + SHOW_USER_ORDERS)
public class ShowUserOrders extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/" + GET_ALL_USER_ORDERS);
        dispatcher.include(request, response);
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher("/order/orders.jsp");
        dispatcher1.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
