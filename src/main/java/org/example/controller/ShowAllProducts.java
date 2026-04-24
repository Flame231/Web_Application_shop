package org.example.controller;

import org.example.dto.ProductDTO;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.util.NamesUtil.CATALOG_JSP_ROOT_PATH;

public class ShowAllProducts extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<ProductDTO> list = productService.getAllProducts();
        request.setAttribute("productList", list);
        for(ProductDTO productDTO:list){
            System.out.println(productDTO);
        }
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(CATALOG_JSP_ROOT_PATH);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
