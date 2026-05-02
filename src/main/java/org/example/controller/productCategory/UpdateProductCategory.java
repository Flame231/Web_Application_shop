package org.example.controller.productCategory;

import org.example.dto.ProductCategoryDTO;
import org.example.postConverters.PostToProductCategoryDTO;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.EDIT_PRODUCT_CATEGORIES;
import static org.example.util.NamesUtil.UPDATE_PRODUCT_CATEGORY;

@WebServlet(UPDATE_PRODUCT_CATEGORY)
public class UpdateProductCategory extends HttpServlet {
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductCategoryDTO productCategoryDTO = PostToProductCategoryDTO.toProductCategoryDTO(request);
        productCategoryService.updateProductCategory(productCategoryDTO);
        response.sendRedirect(request.getContextPath() + EDIT_PRODUCT_CATEGORIES);
    }
}
