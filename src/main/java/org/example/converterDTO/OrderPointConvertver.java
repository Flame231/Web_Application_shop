package org.example.converterDTO;


import org.example.dto.OrderPointDTO;
import org.example.model.OrderPoint;

public class OrderPointConvertver {
    public static OrderPointDTO toOrderPointDTO(OrderPoint orderPoint) {
        return OrderPointDTO.builder().id(orderPoint.getId()).
                orderPointAddress(orderPoint.getOrderPointAddress())
                .openingTime(orderPoint.getOpeningTime()).closeTime(orderPoint.getCloseTime())
                .userOrder(orderPoint.getUserOrder()).build();
    }
}
