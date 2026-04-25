package org.example.controller;

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

import static org.example.util.NamesUtil.GET_PRODUCT_CATEGORIES_ROOT;

@WebServlet(GET_PRODUCT_CATEGORIES_ROOT)
public class GetAllProductCategories extends HttpServlet {
    ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCategoryDTO> list = productCategoryService.getProductCategoryDTOList();
        request.setAttribute("productCategoriesList", list);
        for(ProductCategoryDTO p: (List<ProductCategoryDTO>)(request.getAttribute("productCategoriesList"))){
            System.out.println(p);
        }
    }
}
