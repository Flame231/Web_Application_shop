package org.example.converterDTO;

import org.example.dto.ProductDTO;
import org.example.model.Bag;
import org.example.model.Product;
import org.example.model.User;

public class ProductConverter {

    public static ProductDTO toProductDTO(Product product) {
        return ProductDTO.builder().id(product.getId())
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .price(product.getPrice())
                .seller(product.getSeller()).build();
    }

    public static Product toProduct(ProductDTO productDTO){
        return Product.builder().id(productDTO.getId())
                .productName(productDTO.getProductName())
                .productCategory(productDTO.getProductCategory())
                .price(productDTO.getPrice())
                .seller(productDTO.getSeller())
                .userOrderProducts(null).build();
    }
}
