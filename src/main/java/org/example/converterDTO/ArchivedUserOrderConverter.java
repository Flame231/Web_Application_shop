package org.example.converterDTO;

import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.userOrder.UserOrderDAO;
import org.example.dao.userOrder.UserOrderDAOImpl;
import org.example.model.ArchivedUserOrder;
import org.example.dto.ArchivedUserOrderDTO;

public class ArchivedUserOrderConverter implements ConverterDTO<ArchivedUserOrder, ArchivedUserOrderDTO> {
    ProductDAO productDAO = new ProductDAOImpl();
    UserOrderDAO userOrderDAO = new UserOrderDAOImpl();

    @Override
    public ArchivedUserOrder toEntity(ArchivedUserOrderDTO archivedUserOrderDTO) {
        return ArchivedUserOrder.builder().userOrderId(archivedUserOrderDTO.getUserOrderId())
                .userId(archivedUserOrderDTO.getUserId())
                .productName(archivedUserOrderDTO.getProductName()).productCount(archivedUserOrderDTO.getProductCount())
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
                .productName(archivedUserOrder.getProductName())
                .productCount(archivedUserOrder.getProductCount())
                .actualProductCount(archivedUserOrder.getActualProductCount())
                .productPrice(archivedUserOrder.getProductPrice())
                .orderStatus(archivedUserOrder.getOrderStatus()).orderSum(archivedUserOrder.getOrderSum())
                .finalOrderSum(archivedUserOrder.getFinalOrderSum())
                .userOrderCreateDateTime(archivedUserOrder.getUserOrderCreateDateTime())
                .userOrderCloseDateTime(archivedUserOrder.getUserOrderCloseDateTime()).build();
    }
}
