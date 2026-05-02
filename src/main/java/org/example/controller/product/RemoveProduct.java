package org.example.controller.product;

import org.example.postConverters.ConverterPost;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.EDIT_CATALOG;
import static org.example.util.NamesUtil.REMOVE_PRODUCT;

@WebServlet(REMOVE_PRODUCT)
public class RemoveProduct extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ConverterPost converterPost = new ConverterPost(request);
        Integer productId = converterPost.convertParameter("productId", Integer.class);
        productService.removeProduct(productId);
        response.sendRedirect(request.getContextPath() + EDIT_CATALOG);
    }
}
