package org.example.dto.NewDTO.NewConverterDTO;

import org.example.dto.NewDTO.NewProductDTO;
import org.example.dto.NewDTO.ProductCategoryDTO;
import org.example.dto.NewDTO.SellerDTO;
import org.example.model.Product;
import org.example.model.ProductCategory;
import org.example.model.Seller;

public class ProductDTOConverter implements ConverterDTO<Product, NewProductDTO> {
    private ConverterDTO<ProductCategory, ProductCategoryDTO> converter = new ProductCategoryDTOConverter();
    private ConverterDTO<Seller, SellerDTO> converter1 = new SellerDTOConverter();

    @Override
    public Product toEntity(NewProductDTO newProductDTO) {
        return Product.builder()
                .productName(newProductDTO.getProductName())
                .productCategory(converter.toEntity(newProductDTO.getProductCategory()))
                .price(newProductDTO.getPrice())
                .seller(converter1.toEntity(newProductDTO.getSeller()))
                .id(newProductDTO.getId())
                .updateDateTime(newProductDTO.getUpdateDateTime())
                .build();
    }

    @Override
    public NewProductDTO toDTO(Product product) {
        return NewProductDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .productCategory(converter.toDTO(product.getProductCategory()))
                .price(product.getPrice())
                .seller(converter1.toDTO(product.getSeller()))
                .updateDateTime(product.getUpdateDateTime())
                .build();
    }
}
