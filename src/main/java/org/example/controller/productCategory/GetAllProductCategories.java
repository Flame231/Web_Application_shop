package org.example.controller.productCategory;

import org.example.dto.ProductCategoryDTO;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.example.util.NamesUtil.GET_ALL_PRODUCT_CATEGORIES;

@WebServlet(GET_ALL_PRODUCT_CATEGORIES)
public class GetAllProductCategories extends HttpServlet {
    private ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategoryDTO> productCategoriesList = productCategoryService.getProductCategoryDTOList();
        request.setAttribute("productCategoriesList", productCategoriesList);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
