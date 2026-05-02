package org.example.controller.product;

import org.example.dto.ProductCategoryDTO;
import org.example.dto.SellerDTO;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;
import org.example.service.seller.SellerService;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.util.NamesUtil.ADD_PRODUCT_JSP;
import static org.example.util.NamesUtil.ADD_PRODUCT_PAGE;

@WebServlet(ADD_PRODUCT_PAGE)
public class AddProductPage extends HttpServlet {
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    private SellerService sellerService = new SellerServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategoryDTO> productCategoryDTOList = productCategoryService.getProductCategoryDTOList();
        List<SellerDTO> sellerDTOList = sellerService.getSellerDTOList();
        request.setAttribute("productCategoryDTOList", productCategoryDTOList);
        request.setAttribute("sellerDTOList", sellerDTOList);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(ADD_PRODUCT_JSP);
        dispatcher.forward(request, response);
    }
}
