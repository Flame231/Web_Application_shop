package org.example.controller.product;

import org.example.dto.ProductDTO;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.util.NameUtils2.GET_ALL_PRODUCTS;

@WebServlet("/" + GET_ALL_PRODUCTS)
public class GetAllProducts extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDTO> list = productService.getAllProducts();
        request.setAttribute("productList", list);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
