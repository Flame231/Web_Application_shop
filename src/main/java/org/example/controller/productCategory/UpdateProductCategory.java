package org.example.controller.productCategory;

import org.example.controller.postConverters.PostToProductCategoryDTO;
import org.example.converterDTO.ProductCategoryConverter;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NameUtils2.UPDATE_PRODUCT_CATEGORY;

@WebServlet("/" + UPDATE_PRODUCT_CATEGORY)
public class UpdateProductCategory extends HttpServlet {
    ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        productCategoryService.updateProductCategory(ProductCategoryConverter
                .toProductCategory(PostToProductCategoryDTO.toProductCategoryDTO(request)));
        response.sendRedirect("EditProductCategories");
    }
}
