package org.example.controller.productCategory;

import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.EDIT_PRODUCT_CATEGORIES;
import static org.example.util.NamesUtil.REMOVE_PRODUCT_CATEGORY;

@WebServlet(REMOVE_PRODUCT_CATEGORY)
public class RemoveProductCategory extends HttpServlet {
    ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        productCategoryService.deleteProductCategory(Integer.parseInt(request.getParameter("productCategoryId")));
        response.sendRedirect(request.getContextPath() + EDIT_PRODUCT_CATEGORIES);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
