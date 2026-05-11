package org.example.service.archivedUserOrder;

import org.example.dao.archivedUserOrder.ArchivedUserOrderDAO;
import org.example.dao.archivedUserOrder.ArchivedUserOrderDAOImpl;
import org.example.dao.archivedUserOrderProduct.ArchivedUserOrderDAOProductImpl;
import org.example.dao.archivedUserOrderProduct.ArchivedUserOrderProductDAO;
import org.example.dao.userOrder.UserOrderDAO;
import org.example.dao.userOrder.UserOrderDAOImpl;
import org.example.dto.NewDTO.ArchivedUserOrderDTO;
import org.example.dto.NewDTO.NewConverterDTO.ArchivedUserOrderDTOConverter;
import org.example.dto.NewDTO.NewConverterDTO.ConverterDTO;
import org.example.model.ArchivedUserOrder;
import org.example.model.ArchivedUserOrderProduct;
import org.example.model.UserOrder.OrderStatus;
import org.example.model.UserOrder.UserOrder;
import org.example.service.archivedUserOrderProduct.ArchivedUserOrderProductService;
import org.example.service.archivedUserOrderProduct.ArchivedUserOrderProductServiceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArchivedUserOrderServiceImpl implements ArchivedUserOrderService {
    private ArchivedUserOrderDAO archivedUserOrderDAO = new ArchivedUserOrderDAOImpl();
    private ArchivedUserOrderProductDAO archivedUserOrderProductDAO = new ArchivedUserOrderDAOProductImpl();
    private UserOrderDAO userOrderDAO = new UserOrderDAOImpl();
    private ArchivedUserOrderProductService archivedUserOrderProductService = new ArchivedUserOrderProductServiceImpl();

    @Override
    public void readyUserOrder(Integer userOrderId) {
        UserOrder userOrder = userOrderDAO.get(userOrderId);
        userOrderDAO.begin();
        userOrder.setOrderStatus(OrderStatus.READY);
        userOrderDAO.commit();
    }

    @Override
    public void createArchivedUserOrder(Integer userOrderId) {
        UserOrder userOrder = userOrderDAO.get(userOrderId);
        Set<ArchivedUserOrderProduct> archivedUserOrderProduct = archivedUserOrderProductService.createUserOrderProduct(
                userOrder.getUserOrderProduct(), null);
        BigDecimal finalOrderSum = archivedUserOrderProduct.stream().map(e -> e.getPrice()
                .multiply(new BigDecimal(e.getFinalProductCount()))).reduce(
                BigDecimal.ZERO, BigDecimal::add);
        
        ArchivedUserOrder archivedUserOrder = ArchivedUserOrder
                .builder()
                .userOrderId(userOrder.getId())
                .orderStatus(OrderStatus.CLOSED)
                .userId(userOrder.getUser().getId())
                .OrderPoint(userOrder.getOrderPoint().getOrderPointAddress())
                .orderSum(userOrder.getOrderSum())
                .finalOrderSum(finalOrderSum)
                .userOrderCreateDateTime(userOrder.getCreateDateTime())
                .archivedUserOrderProducts(archivedUserOrderProduct)
                .build();
        archivedUserOrderProduct.forEach(e -> e.setArchivedUserOrder(archivedUserOrder));
        archivedUserOrderDAO.save(archivedUserOrder);
        userOrderDAO.delete(userOrderId);
    }

    @Override
    public void refuseUserOrder(Integer userOrderId) {
        UserOrder userOrder = userOrderDAO.get(userOrderId);
        Set<ArchivedUserOrderProduct> archivedUserOrderProduct = archivedUserOrderProductService.createUserOrderProduct(
                userOrder.getUserOrderProduct(), null);
        ArchivedUserOrder archivedUserOrder = ArchivedUserOrder
                .builder()
                .userOrderId(userOrder.getId())
                .orderStatus(OrderStatus.REFUSED)
                .userId(userOrder.getUser().getId())
                .OrderPoint(userOrder.getOrderPoint().getOrderPointAddress())
                .orderSum(userOrder.getOrderSum())
                .finalOrderSum(BigDecimal.ZERO)
                .userOrderCreateDateTime(userOrder.getCreateDateTime())
                .archivedUserOrderProducts(archivedUserOrderProduct)
                .build();
        archivedUserOrderProduct.forEach(e -> e.setArchivedUserOrder(archivedUserOrder));
        archivedUserOrderDAO.save(archivedUserOrder);
        userOrderDAO.delete(userOrderId);
    }


    @Override
    public List<ArchivedUserOrderDTO> showArchivedUserOrders(Integer userId) {
        ConverterDTO<ArchivedUserOrder, ArchivedUserOrderDTO> converterDTO = new ArchivedUserOrderDTOConverter();
        return archivedUserOrderDAO
                .getArchivedUserOrders(userId)
                .stream()
                .map(converterDTO::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }
}
