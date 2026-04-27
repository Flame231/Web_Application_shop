package org.example.controller.seller;

import org.example.service.seller.SellerService;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeSeller")
public class RemoveSeller extends HttpServlet {
    SellerService sellerService = new SellerServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sellerService.removeSeller(request.getParameter("sellerId"));
        response.sendRedirect("editSellers");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
