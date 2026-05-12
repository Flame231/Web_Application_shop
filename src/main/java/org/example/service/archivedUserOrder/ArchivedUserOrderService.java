package org.example.service.archivedUserOrder;

import org.example.dto.dto.ArchivedUserOrderDTO;

import java.util.List;

public interface ArchivedUserOrderService {

    void createArchivedUserOrder(Integer userOrderId);

    void readyUserOrder(Integer userOrderId);

    void refuseUserOrder(Integer userOrderId);

    List<ArchivedUserOrderDTO> showArchivedUserOrders(Integer userId);

}
