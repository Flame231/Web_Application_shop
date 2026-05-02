package org.example.converterDTO;

import org.example.dto.ProductDTO;
import org.example.model.Product;

public class ProductConverter implements ConverterDTO<Product, ProductDTO> {


    @Override
    public Product toEntity(ProductDTO productDTO) {
        return Product.builder().id(productDTO.getId())
                .productName(productDTO.getProductName())
                .productCategory(productDTO.getProductCategory())
                .price(productDTO.getPrice())
                .seller(productDTO.getSeller())
                .userOrderProducts(null).build();
    }


    @Override
    public ProductDTO toDTO(Product product) {
        return ProductDTO.builder().id(product.getId())
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .price(product.getPrice())
                .seller(product.getSeller())
                .updateDateTime(product.getUpdateDateTime())
                .build();
    }


}
