package org.example.controller.product;

import org.example.dto.ProductDTO;
import org.example.postConverters.PostToProductDTO;
import org.example.service.product.ProductService;
import org.example.service.product.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.ADD_PRODUCT;
import static org.example.util.NamesUtil.EDIT_CATALOG;

@WebServlet(ADD_PRODUCT)
public class AddProduct1111111111111111111111111 extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDTO productDTO = PostToProductDTO.toProductDTO(request);
        productService.addProduct(productDTO);
        response.sendRedirect(request.getContextPath() + EDIT_CATALOG);
    }

}
