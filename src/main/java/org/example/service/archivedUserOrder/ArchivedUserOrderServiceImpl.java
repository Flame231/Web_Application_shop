package org.example.service.archivedUserOrder;

import org.example.dao.archivedUserOrder.ArchivedUserOrderDAO;
import org.example.dao.archivedUserOrder.ArchivedUserOrderDAOImpl;
import org.example.dao.userOrder.UserOrderDAO;
import org.example.dao.userOrder.UserOrderDAOImpl;
import org.example.model.ArchivedUserOrder;
import org.example.model.UserOrder.OrderStatus;
import org.example.model.UserOrder.UserOrder;

import java.math.BigDecimal;

public class ArchivedUserOrderServiceImpl implements ArchivedUserOrderService {
    private ArchivedUserOrderDAO archivedUserOrderDAO = new ArchivedUserOrderDAOImpl();
    private UserOrderDAO userOrderDAO = new UserOrderDAOImpl();

    @Override
    public void createArchivedUserOrder(Integer userOrderId) {
        UserOrder userOrder = userOrderDAO.get(userOrderId);
        BigDecimal finalOrderSum = userOrder.getUserOrderProduct().stream().map(e ->
                        new BigDecimal(e.getActualProductCount()).multiply(e.getProductPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        userOrder.getUserOrderProduct().stream()
                .map((e) -> ArchivedUserOrder.builder().userOrderId(userOrderId)
                        .userId(userOrder.getUser().getId())
                        .productId(e.getProduct().getId()).productCount(e.getProductCount())
                        .actualProductCount(e.getActualProductCount()).productPrice(e.getProductPrice())
                        .orderStatus(OrderStatus.CLOSED.name()).orderSum(userOrder.getOrderSum())
                        .finalOrderSum(finalOrderSum)
                        .userOrderCreateDateTime(userOrder.getCreateDateTime())
                        .userOrderCloseDateTime(userOrder.getUpdateDateTime())
                        .build()).forEach(archivedUserOrderDAO::save);
        userOrderDAO.delete(userOrderId);
    }

    @Override
    public void readyUserOrder(Integer userOrderId) {
        UserOrder userOrder = userOrderDAO.get(userOrderId);
        userOrderDAO.begin();
        userOrder.setOrderStatus(OrderStatus.READY);
        userOrderDAO.commit();
    }

    @Override
    public void refuseUserOrder(Integer userOrderId) {
        UserOrder userOrder = userOrderDAO.get(userOrderId);
        userOrder.getUserOrderProduct().stream()
                .map((e) -> ArchivedUserOrder.builder().userOrderId(userOrderId)
                        .userId(userOrder.getUser().getId())
                        .productId(e.getProduct().getId()).productCount(e.getProductCount())
                        .actualProductCount(0).productPrice(e.getProductPrice())
                        .orderStatus(OrderStatus.REFUSED.name()).orderSum(userOrder.getOrderSum())
                        .finalOrderSum(BigDecimal.ZERO)
                        .userOrderCreateDateTime(userOrder.getCreateDateTime())
                        .userOrderCloseDateTime(userOrder.getUpdateDateTime())
                        .build()).forEach(archivedUserOrderDAO::save);
        userOrderDAO.delete(userOrderId);
        userOrderDAO.begin();
        userOrderDAO.commit();
    }

    @Override
    public void showArchivedUserOrders(Integer userId) {

    }

    @Override
    public void showAllArchivedUserOrders() {

    }
}
