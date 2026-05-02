package org.example.controller.bag;

import org.example.dto.BagDTO;
import org.example.postConverters.PostToBagDTO;
import org.example.service.bag.BagService;
import org.example.service.bag.BagServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.*;

@WebServlet(ADD_TO_BAG)
public class AddToBag extends HttpServlet {
    private BagService bagService = new BagServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BagDTO bagDTO = PostToBagDTO.toBagDTO(request);
        bagService.addProductToBag(bagDTO);
        if ("catalog".equals(request.getParameter("func"))) {
            response.sendRedirect(request.getContextPath() + SHOW_CATALOG);
        } else if ("bag".equals(request.getParameter("func"))) {
            response.sendRedirect(request.getContextPath() + SHOW_BAG);
        }
    }
}
