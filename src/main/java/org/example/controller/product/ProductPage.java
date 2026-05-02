package org.example.controller.product;

import org.example.dto.ProductDTO;
import org.example.postConverters.ConverterPost;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.PRODUCT_PAGE;
import static org.example.util.NamesUtil.PRODUCT_PAGE_JSP;

@WebServlet(PRODUCT_PAGE)
public class ProductPage extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer productId = new ConverterPost(request).convertParameter("productId", Integer.class);
        ProductDTO productDTO = productService.findProduct(productId);
        request.setAttribute("productDTO", productDTO);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(PRODUCT_PAGE_JSP);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
