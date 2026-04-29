package org.example.controller.postConverters;

import org.example.dto.ProductCategoryDTO;

import javax.servlet.http.HttpServletRequest;

import static org.example.util.NamesUtil.PRODUCT_CATEGORY_ID_PARAMETER;
import static org.example.util.NamesUtil.PRODUCT_CATEGORY_NAME_PARAMETER;

public class PostToProductCategoryDTO {
    public static ProductCategoryDTO toProductCategoryDTO(HttpServletRequest request) {
        PostConverter postConverter = new PostConverter(request);
        String productCategoryName = postConverter.convert(PRODUCT_CATEGORY_NAME_PARAMETER, String.class);
        if (request.getParameter(PRODUCT_CATEGORY_ID_PARAMETER) != null) {
            Integer productCategoryId = postConverter.convert(PRODUCT_CATEGORY_ID_PARAMETER, Integer.class);
            return ProductCategoryDTO.builder().id(productCategoryId)
                    .category(productCategoryName).build();
        }
        return ProductCategoryDTO.builder().
                category(productCategoryName).build();
    }
}
