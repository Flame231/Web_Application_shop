package org.example.controller.product;

import org.example.dto.dto.ProductCategoryDTO;
import org.example.dto.dto.ProductDTO;
import org.example.dto.dto.SellerDTO;
import org.example.model.Product;
import org.example.postConverters.ConverterPost;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;
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

@WebServlet(EDIT_PRODUCT)
public class EditProduct extends HttpServlet {
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private SellerService sellerService = new SellerServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConverterPost converterPost = new ConverterPost(request);
        Integer productId = converterPost.convertParameter("productId", Integer.class);
        ProductDTO productDTO = productService.findProduct(productId);
        request.setAttribute("productDTO", productDTO);
        List<ProductCategoryDTO> list = productCategoryService.getProductCategoryDTOList();
        List<SellerDTO> listSeller = sellerService.getSellerDTOList();
        request.setAttribute("productCategoryDTOList", list);
        request.setAttribute("sellerDTOList", listSeller);
        RequestDispatcher includeDispatcher = getServletContext().getRequestDispatcher(GET_ALL_PRODUCTS);
        includeDispatcher.include(request, response);
        RequestDispatcher forwardDispatcher = getServletContext().getRequestDispatcher(EDIT_PRODUCT_JSP);
        forwardDispatcher.forward(request, response);
    }
}
