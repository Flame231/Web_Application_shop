package org.example.converterDTO;

import org.example.model.ArchivedUserOrder;
import org.example.dto.ArchivedUserOrderDTO;

public class ArchivedUserOrderConverter implements ConverterDTO<ArchivedUserOrder, ArchivedUserOrderDTO> {
    @Override
    public ArchivedUserOrder toEntity(ArchivedUserOrderDTO archivedUserOrderDTO) {
        return ArchivedUserOrder.builder().userOrderId(archivedUserOrderDTO.getUserOrderId())
                .userId(archivedUserOrderDTO.getUserId())
                .productId(archivedUserOrderDTO.getProductId()).productCount(archivedUserOrderDTO.getProductCount())
                .actualProductCount(archivedUserOrderDTO.getProductCount())
                .productPrice(archivedUserOrderDTO.getProductPrice())
                .orderStatus(archivedUserOrderDTO.getOrderStatus()).orderSum(archivedUserOrderDTO.getOrderSum())
                .finalOrderSum(archivedUserOrderDTO.getOrderSum())
                .userOrderCreateDateTime(archivedUserOrderDTO.getUserOrderCreateDateTime())
                .userOrderCloseDateTime(archivedUserOrderDTO.getUserOrderCloseDateTime()).build();
    }

    @Override
    public ArchivedUserOrderDTO toDTO(ArchivedUserOrder archivedUserOrder) {
        return ArchivedUserOrderDTO.builder().id(archivedUserOrder.getId())
                .userId(archivedUserOrder.getUserId())
                .userOrderId(archivedUserOrder.getUserOrderId())
                .productId(archivedUserOrder.getProductId())
                .productCount(archivedUserOrder.getProductCount())
                .actualProductCount(archivedUserOrder.getActualProductCount())
                .productPrice(archivedUserOrder.getProductPrice())
                .orderStatus(archivedUserOrder.getOrderStatus()).orderSum(archivedUserOrder.getOrderSum())
                .finalOrderSum(archivedUserOrder.getFinalOrderSum())
                .userOrderCreateDateTime(archivedUserOrder.getUserOrderCreateDateTime())
                .userOrderCloseDateTime(archivedUserOrder.getUserOrderCloseDateTime()).build();
    }
}
