package org.example.controller.product;

import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeProduct")
public class RemoveProduct extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        productService.removeProduct(productService.findProduct(productId));
        response.sendRedirect("editCatalog");
    }
}
