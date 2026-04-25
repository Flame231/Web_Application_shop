package org.example.converterDTO;

import org.example.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;

public class ProductCategoryConverter {
    public static ProductCategoryDTO toProductCategoryDTO(ProductCategory productCategory) {
        return ProductCategoryDTO.builder().id(productCategory.getId())
                .products(productCategory.getProducts())
                .category(productCategory.getCategory()).build();
    }
}
