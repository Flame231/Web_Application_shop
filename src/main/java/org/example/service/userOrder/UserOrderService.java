package org.example.service.userOrder;

import org.example.dto.NewOrderDTO;

import java.util.List;

public interface UserOrderService {

    public void confirmOrder(List<NewOrderDTO> list);
}
