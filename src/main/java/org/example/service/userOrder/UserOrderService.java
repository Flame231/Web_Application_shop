package org.example.service.userOrder;

import org.example.dto.NewOrderDTO;
import org.example.dto.UserOrderDTO;
import org.example.model.UserOrder;

import java.util.List;

public interface UserOrderService {

    public void confirmOrder(List<NewOrderDTO> list);

    List<UserOrderDTO> showAllUserOrders();
}
