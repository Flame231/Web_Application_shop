package org.example.controller.productCategory;

import org.example.controller.postConverters.PostToProductCategoryDTO;
import org.example.converterDTO.ProductCategoryConverter;
import org.example.model.ProductCategory;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.*;


@WebServlet("/addProductCategoryPage")
public class AddProductCategoryPage extends HttpServlet {
    ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("superUser/productCategory/addProductCategory.jsp");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}







