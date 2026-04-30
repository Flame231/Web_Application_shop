package org.example.controller.bag;

import org.example.controller.postConverters.PostToBagDTO;
import org.example.converterDTO.BagConverter;
import org.example.dto.BagDTO;
import org.example.service.bag.BagService;
import org.example.service.bag.BagServiceImpl;
import org.example.util.NameUtils2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.util.NameUtils2.*;
import static org.example.util.NamesUtil.*;

@WebServlet("/" + ADD_TO_BAG)
public class AddToBag extends HttpServlet {
    BagService bagService = new BagServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<BagDTO> bagDTOList = PostToBagDTO.toBagDTO(request);

        bagDTOList.stream().map(BagConverter::toBagEntity).forEach(bagService::addProductToBag);
        if ("catalog".equals(request.getParameter("func"))) {
            response.sendRedirect(request.getContextPath() + "/" + SHOW_CATALOG);
        } else {
            response.sendRedirect(request.getContextPath() + "/" +  SHOW_BAG);
        }
    }
}
