package org.example.dto.ConverterDTO;

import org.example.dto.dto.UserOrderDTO;
import org.example.dto.dto.UserOrderProductDTO;
import org.example.model.UserOrder.UserOrder;
import org.example.model.UserOrder.UserOrderProduct;

import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class UserOrderDTOConverter implements ConverterDTO<UserOrder, UserOrderDTO> {
    private ConverterDTO<UserOrderProduct, UserOrderProductDTO> converterDTO = new UserOrderProductDTOConverter();

    @Override
    public UserOrder toEntity(UserOrderDTO userOrderDTO) {
        return null;
    }

    @Override
    public UserOrderDTO toDTO(UserOrder userOrder) {
        return UserOrderDTO.builder().orderId(userOrder.getId()).orderStatus(userOrder.getOrderStatus()).orderPoint(userOrder.getOrderPoint().getOrderPointAddress()).orderSum(userOrder.getOrderSum())
                .OrderCreateDateTime(userOrder.getCreateDateTime())
                .userOrderProducts(userOrder.getUserOrderProduct()
                        .stream().map(converterDTO::toDTO)
                        .collect(Collectors.toCollection(LinkedHashSet::new)))
                .build();
    }
}
