package org.example.service.userOrder;

import org.example.dto.NewOrderDTO;
import org.example.dto.UserOrderDTO;

import java.io.Serializable;
import java.util.List;

public interface UserOrderService {

    void confirmOrder(List<NewOrderDTO> list);

    List<UserOrderDTO> showAllUserOrders();

    List<UserOrderDTO> showUserOrdersByOrderPoint(Serializable userId);

    UserOrderDTO getUserOrderDTO(Serializable id);

}
