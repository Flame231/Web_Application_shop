package org.example.controller.product;

import org.example.controller.postConverters.PostToProductDTO;
import org.example.converterDTO.ProductConverter;
import org.example.dto.ProductDTO;
import org.example.model.Product;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ProductDTO productDTO = PostToProductDTO.toProductDTO(request);
        Product product = ProductConverter.toProduct(productDTO);
        productService.addProduct(product);
        response.sendRedirect("EditCatalog");
    }

}
