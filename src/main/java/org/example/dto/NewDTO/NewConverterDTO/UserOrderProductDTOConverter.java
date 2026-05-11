package org.example.dto.NewDTO.NewConverterDTO;

import org.example.dto.NewDTO.NewProductDTO;
import org.example.dto.NewDTO.NewUserOrderProductDTO;
import org.example.model.Product;
import org.example.model.UserOrder.UserOrderProduct;

public class UserOrderProductDTOConverter implements ConverterDTO<UserOrderProduct, NewUserOrderProductDTO> {
    private ConverterDTO<Product, NewProductDTO> converterDTO = new ProductDTOConverter();

    @Override
    public UserOrderProduct toEntity(NewUserOrderProductDTO newUserOrderProductDTO) {
        return null;
    }

    @Override
    public NewUserOrderProductDTO toDTO(UserOrderProduct userOrderProduct) {
        return NewUserOrderProductDTO.builder()
                .userOrderId(userOrderProduct.getUserOrder().getId())
                .newProductDTO(converterDTO.toDTO(userOrderProduct.getProduct()))
                .productCount(userOrderProduct.getProductCount())
                .actualProductCount(userOrderProduct.getActualProductCount())
                .build();
    }
}
