package org.example.postConverters;

import org.example.dto.ProductCategoryDTO;

import javax.servlet.http.HttpServletRequest;

import static org.example.util.NamesUtil.PRODUCT_CATEGORY_ID_PARAMETER;
import static org.example.util.NamesUtil.PRODUCT_CATEGORY_NAME_PARAMETER;

public class PostToProductCategoryDTO {
    public static ProductCategoryDTO toProductCategoryDTO(HttpServletRequest request) {
        ConverterPost converterPost = new ConverterPost(request);
        String productCategoryName = converterPost.convertParameter(PRODUCT_CATEGORY_NAME_PARAMETER, String.class);
        if (request.getParameter(PRODUCT_CATEGORY_ID_PARAMETER) != null) {
            Integer productCategoryId = converterPost.convertParameter(PRODUCT_CATEGORY_ID_PARAMETER, Integer.class);
            return ProductCategoryDTO.builder().id(productCategoryId)
                    .category(productCategoryName).build();
        }
        return ProductCategoryDTO.builder().
                category(productCategoryName).build();
    }
}
