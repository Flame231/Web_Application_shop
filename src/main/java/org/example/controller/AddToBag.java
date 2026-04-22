package org.example.controller;

import org.example.controller.postConverters.PostToBagDTO;
import org.example.converterDTO.BagConverter;
import org.example.dto.BagDTO;
import org.example.dto.ProductBagDTO;
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
        BagDTO bagDTO = PostToBagDTO.toBagDTO(request);
        bagService.addProductToBag(BagConverter.toBagEntity(bagDTO));
        if("catalog".equals(request.getParameter("func"))){
            response.sendRedirect("showAllProducts");
        }
        else{
            response.sendRedirect("showBag");
        }
    }
}
