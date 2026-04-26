package org.example.converterDTO;

import org.example.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;

public class ProductCategoryConverter {

    public static ProductCategoryDTO toProductCategoryDTO(ProductCategory productCategory) {
        return ProductCategoryDTO.builder().id(productCategory.getId())
                .category(productCategory.getCategory()).build();
    }

    public static ProductCategory toProductCategory(ProductCategoryDTO productCategoryDTO) {
        if (productCategoryDTO.getId() != null) {
            return ProductCategory.builder()
                    .products(null).category(productCategoryDTO.getCategory())
                    .id(productCategoryDTO.getId()).build();
        }
        return ProductCategory.builder()
                .products(null).category(productCategoryDTO.getCategory())
                .build();
    }

}
