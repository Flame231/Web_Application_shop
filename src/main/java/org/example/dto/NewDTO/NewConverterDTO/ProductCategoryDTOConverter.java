package org.example.dto.NewDTO.NewConverterDTO;

import org.example.dto.NewDTO.ProductCategoryDTO;
import org.example.model.ProductCategory;

public class ProductCategoryDTOConverter implements ConverterDTO<ProductCategory, ProductCategoryDTO> {

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
