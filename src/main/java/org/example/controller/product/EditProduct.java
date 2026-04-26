package org.example.controller.product;

import org.example.dao.productCategory.ProductCategoryDAO;
import org.example.dao.productCategory.ProductCategoryDAOImpl;
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

import static org.example.util.NamesUtil.*;

@WebServlet(EDIT_PRODUCT_ROOT)
public class EditProduct extends HttpServlet {
    ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    SellerService sellerService = new SellerServiceImpl();
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAOImpl();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategoryDTO> list = productCategoryService.getProductCategoryDTOList();
        List<SellerDTO> listSeller = sellerService.getSellerDTOList();
        request.setAttribute("productCategoryDTOList", list);
        request.setAttribute("sellerDTOList", listSeller);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(GET_ALL_PRODUCTS_ROOT);
        dispatcher.include(request,response);
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(EDIT_PRODUCT_JSP_ROOT);
        dispatcher1.forward(request,response);
    }
}
