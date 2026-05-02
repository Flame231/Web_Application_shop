package org.example.controller.seller;

import org.example.postConverters.ConverterPost;
import org.example.service.seller.SellerService;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.EDIT_SELLERS;
import static org.example.util.NamesUtil.REMOVE_SELLER;

@WebServlet(REMOVE_SELLER)
public class RemoveSeller extends HttpServlet {
    private SellerService sellerService = new SellerServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ConverterPost converterPost = new ConverterPost(request);
        Integer sellerId = converterPost.convertParameter("sellerId", Integer.class);
        sellerService.removeSeller(sellerId);
        response.sendRedirect(request.getContextPath() + EDIT_SELLERS);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
