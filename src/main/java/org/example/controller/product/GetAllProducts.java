package org.example.controller.product;

import org.example.postConverters.ConverterPost;
import org.example.service.product.ProductPagesDivide;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.GET_ALL_PRODUCTS;

@WebServlet(GET_ALL_PRODUCTS)
public class GetAllProducts extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        ConverterPost converterPost = new ConverterPost(request);
        ProductPagesDivide pagesDivide = productService.getProductsAndList(converterPost.convertParameter("currentPage", Integer.class));
        request.setAttribute("currentPage", pagesDivide.currentPage());
        request.setAttribute("productCountResult", pagesDivide.productCountResult());
        request.setAttribute("productList", pagesDivide.productDTOList());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
