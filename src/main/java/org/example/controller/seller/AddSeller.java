package org.example.controller.seller;

import org.example.dto.SellerDTO;
import org.example.postConverters.PostToSellerDTO;
import org.example.service.seller.SellerService;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.ADD_SELLER;
import static org.example.util.NamesUtil.EDIT_SELLERS;


@WebServlet(ADD_SELLER)
public class AddSeller extends HttpServlet {
    private SellerService sellerService = new SellerServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SellerDTO sellerDTO = PostToSellerDTO.toSellerDTO(request);
        sellerService.addSeller(sellerDTO);
        response.sendRedirect(request.getContextPath() + EDIT_SELLERS);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



