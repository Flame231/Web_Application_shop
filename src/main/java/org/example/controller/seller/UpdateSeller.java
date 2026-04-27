package org.example.controller.seller;

import org.example.controller.postConverters.PostToSellerDTO;
import org.example.converterDTO.SellerConverter;
import org.example.dto.SellerDTO;
import org.example.service.seller.SellerService;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateSeller")
public class UpdateSeller extends HttpServlet {
    SellerService sellerService = new SellerServiceImpl();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SellerDTO sellerDTO = PostToSellerDTO.toSellerDTO(request);
        sellerService.updateSeller(SellerConverter.toSeller(sellerDTO));
        response.sendRedirect("editSellers");



    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



