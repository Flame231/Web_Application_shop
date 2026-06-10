package org.example.controller.seller;

import org.example.dto.dto.SellerDTO;
import org.example.postConverters.ConverterPost;
import org.example.service.seller.SellerService;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.EDIT_SELLER;
import static org.example.util.NamesUtil.EDIT_SELLER_JSP;


@WebServlet(EDIT_SELLER)
public class EditSeller extends HttpServlet {
    SellerService sellerService = new SellerServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConverterPost converterPost = new ConverterPost(request);
        Integer sellerId = converterPost.convertParameter("sellerId", Integer.class);
        SellerDTO sellerDTO = sellerService.getSeller(sellerId);
        request.setAttribute("sellerDTO", sellerDTO);
        RequestDispatcher dispatcher = request.getRequestDispatcher(EDIT_SELLER_JSP);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



