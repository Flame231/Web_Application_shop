package org.example.service.userOrder;

import org.example.dto.dto.OrderDTO;
import org.example.dto.dto.UserOrderDTO;

import java.io.Serializable;
import java.util.List;

public interface UserOrderService {

    void confirmOrder(List<OrderDTO> list);

    List<UserOrderDTO> showAllUserOrders();

    List<UserOrderDTO> showUserOrdersByOrderPoint(Serializable userId);

    List<UserOrderDTO> showArrivedUserOrdersByOrderPoint(Serializable userId);

    UserOrderDTO getUserOrderDTO(Serializable id);

}
