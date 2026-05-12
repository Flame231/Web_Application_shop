package org.example.dto.ConverterDTO;

import org.example.dto.dto.ProductDTO;
import org.example.dto.dto.UserOrderProductDTO;
import org.example.model.Product;
import org.example.model.UserOrder.UserOrderProduct;

public class UserOrderProductDTOConverter implements ConverterDTO<UserOrderProduct, UserOrderProductDTO> {
    private ConverterDTO<Product, ProductDTO> converterDTO = new ProductDTOConverter();

    @Override
    public UserOrderProduct toEntity(UserOrderProductDTO userOrderProductDTO) {
        return null;
    }

    @Override
    public UserOrderProductDTO toDTO(UserOrderProduct userOrderProduct) {
        return UserOrderProductDTO.builder()
                .userOrderId(userOrderProduct.getUserOrder().getId())
                .productDTO(converterDTO.toDTO(userOrderProduct.getProduct()))
                .productCount(userOrderProduct.getProductCount())
                .actualProductCount(userOrderProduct.getActualProductCount())
                .build();
    }
}
