package org.example.dto.NewDTO.NewConverterDTO;

import org.example.dto.NewDTO.NewUserOrderDTO;
import org.example.dto.NewDTO.NewUserOrderProductDTO;
import org.example.model.UserOrder.UserOrder;
import org.example.model.UserOrder.UserOrderProduct;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class UserOrderDTOConverter implements ConverterDTO<UserOrder, NewUserOrderDTO> {
    private ConverterDTO<UserOrderProduct, NewUserOrderProductDTO> converterDTO = new UserOrderProductDTOConverter();

    @Override
    public UserOrder toEntity(NewUserOrderDTO newUserOrderDTO) {
        return null;
    }

    @Override
    public NewUserOrderDTO toDTO(UserOrder userOrder) {
        return NewUserOrderDTO.builder().orderId(userOrder.getId()).orderStatus(userOrder.getOrderStatus()).orderPoint(userOrder.getOrderPoint().getOrderPointAddress()).orderSum(userOrder.getOrderSum())
                .OrderCreateDateTime(userOrder.getCreateDateTime())
                .userOrderProducts(userOrder.getUserOrderProduct()
                        .stream().map(converterDTO::toDTO)
                        .collect(Collectors.toCollection(LinkedHashSet::new)))
                .build();
    }
}
