package org.example.converterDTO;

import org.example.dto.UserOrderDTO;
import org.example.model.UserOrder;

public class UserOrderConverter {
    public static UserOrderDTO toUserOrderDTO(UserOrder userOrder) {
        return UserOrderDTO.builder().id(userOrder.getId()).orderStatus(userOrder.getOrderStatus())
                .user(userOrder.getUser()).orderPoint(userOrder.getOrderPoint())
                .userOrderProduct(userOrder.getUserOrderProduct())
                .orderSum(userOrder.getOrderSum()).createDateTime(userOrder.getCreateDateTime()).build();
    }
}
