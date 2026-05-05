package org.example.service.archivedUserOrder;

public interface ArchivedUserOrderService {

    void createArchivedUserOrder(Integer userOrderId);

    void readyUserOrder(Integer userOrderId);

    void refuseUserOrder(Integer userOrderId);

    void showArchivedUserOrders(Integer userId);

    void showAllArchivedUserOrders();
}
