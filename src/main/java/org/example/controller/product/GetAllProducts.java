package org.example.controller.product;

import org.example.dto.NewDTO.NewProductDTO;
import org.example.postConverters.ConverterPost;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.util.NamesUtil.GET_ALL_PRODUCTS;

@WebServlet(GET_ALL_PRODUCTS)
public class GetAllProducts extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConverterPost converterPost = new ConverterPost(request);

        int currentPage;
        currentPage = 1;
        if (converterPost.convertParameter("currentPage", Integer.class) != null) {
            currentPage = converterPost.convertParameter("currentPage", Integer.class);
        }
        List<NewProductDTO> productList = productService.getAllProducts(currentPage);
        int productCountResult = productService.getProductCountResult();
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("productCountResult", productCountResult);
        request.setAttribute("productList", productList);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
