package org.example.converterDTO;

import org.example.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;

public class ProductCategoryConverter implements ConverterDTO<ProductCategory, ProductCategoryDTO> {

    @Override
    public ProductCategoryDTO toDTO(ProductCategory productCategory) {
        return ProductCategoryDTO.builder().id(productCategory.getId())
                .category(productCategory.getCategory()).build();
    }

    @Override
    public ProductCategory toEntity(ProductCategoryDTO productCategoryDTO) {
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
