package org.example.controller.postConverters;

import org.example.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;

import javax.servlet.http.HttpServletRequest;

public class PostToProductCategoryDTO {
    public static ProductCategoryDTO toProductCategoryDTO(HttpServletRequest request) {

        String productCategoryName = request.getParameter("productCategoryName");

        if (request.getParameter("productCategoryId") != null) {

            Integer productCategoryId = Integer.parseInt(request.getParameter("productCategoryId"));
            return ProductCategoryDTO.builder().id(productCategoryId)
                    .category(productCategoryName).build();
        }
        return ProductCategoryDTO.builder().
                category(productCategoryName).build();
    }
}
