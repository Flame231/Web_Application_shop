package org.example.converterDTO;

import org.example.dto.UserOrderDTO;
import org.example.model.UserOrder;

public class UserOrderConverter implements ConverterDTO<UserOrder, UserOrderDTO> {
    @Override
    public UserOrder toEntity(UserOrderDTO userOrderDTO) {
        return UserOrder.builder().orderStatus(userOrderDTO.getOrderStatus())
                .user(userOrderDTO.getUser())
                .orderPoint(userOrderDTO.getOrderPoint())
                .userOrderProduct(userOrderDTO.getUserOrderProduct())
                .orderSum(userOrderDTO.getOrderSum()).id(userOrderDTO.getId()).build();
    }

    @Override
    public UserOrderDTO toDTO(UserOrder userOrder) {
        return UserOrderDTO.builder().id(userOrder.getId()).orderStatus(userOrder.getOrderStatus())
                .user(userOrder.getUser()).orderPoint(userOrder.getOrderPoint())
                .userOrderProduct(userOrder.getUserOrderProduct())
                .orderSum(userOrder.getOrderSum()).createDateTime(userOrder.getCreateDateTime()).build();
    }
}
