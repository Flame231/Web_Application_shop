package org.example.controller;

import org.example.controller.postConverters.PostToBagDTO;
import org.example.converterDTO.BagConverter;
import org.example.dto.BagDTO;
import org.example.service.bag.BagService;
import org.example.service.bag.BagServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToBag extends HttpServlet {
    BagService bagService = new BagServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111111111111111111111111111111");
        BagDTO bagDTO = PostToBagDTO.toBagDTO(request);
        System.out.println("111111111111111111111111111111");

        bagService.addProductToBag(BagConverter.toBagEntity(bagDTO));
        response.sendRedirect("showAllProducts");
    }
}
