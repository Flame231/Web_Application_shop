package org.example.service.userOrder;

import org.example.dto.NewDTO.NewOrderDTO;
import org.example.dto.NewDTO.NewUserOrderDTO;

import java.io.Serializable;
import java.util.List;

public interface UserOrderService {

    void confirmOrder(List<NewOrderDTO> list);

    List<org.example.dto.NewDTO.NewUserOrderDTO> showAllUserOrders();

    List<org.example.dto.NewDTO.NewUserOrderDTO> showUserOrdersByOrderPoint(Serializable userId);

    List<NewUserOrderDTO> showArrivedUserOrdersByOrderPoint(Serializable userId);

    NewUserOrderDTO getUserOrderDTO(Serializable id);

}
