package org.example.converterDTO;


import org.example.dto.OrderPointDTO;
import org.example.model.OrderPoint;

public class OrderPointConverter implements ConverterDTO<OrderPoint, OrderPointDTO> {
    @Override
    public OrderPointDTO toDTO(OrderPoint orderPoint) {
        return OrderPointDTO.builder().id(orderPoint.getId()).
                orderPointAddress(orderPoint.getOrderPointAddress())
                .openingTime(orderPoint.getOpeningTime()).closeTime(orderPoint.getCloseTime())
                .userOrder(orderPoint.getUserOrder()).build();
    }

    @Override
    public OrderPoint toEntity(OrderPointDTO orderPointDTO) {
        return OrderPoint.builder().orderPointAddress(orderPointDTO.getOrderPointAddress())
                .openingTime(orderPointDTO.getOpeningTime())
                .closeTime(orderPointDTO.getCloseTime())
                .userOrder(orderPointDTO.getUserOrder())
                .id(orderPointDTO.getId())
                .build();
    }
}
