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

import static org.example.util.NamesUtil.*;

public class AddToBag extends HttpServlet {
    BagService bagService = new BagServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BagDTO bagDTO = PostToBagDTO.toBagDTO(request);

        bagService.addProductToBag(BagConverter.toBagEntity(bagDTO));
        if(CATALOG_NAME.equals(request.getParameter("func"))){
            response.sendRedirect(SHOW_ALL_PRODUCTS);
        }
        else{
            response.sendRedirect(SHOW_BAG);
        }
    }
}
