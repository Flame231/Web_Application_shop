package org.example.controller.product;

import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NameUtils2.EDIT_CATALOG;
import static org.example.util.NameUtils2.REMOVE_PRODUCT;

@WebServlet("/" + REMOVE_PRODUCT)
public class RemoveProduct extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        productService.removeProduct(productService.findProduct(productId));
        response.sendRedirect(EDIT_CATALOG);
    }
}
