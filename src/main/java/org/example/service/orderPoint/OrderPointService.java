package org.example.service.orderPoint;

import org.example.dto.NewOrderDTO;
import org.example.dto.OrderPointDTO;
import org.example.model.OrderPoint;

import java.util.List;

public interface OrderPointService {

    List<OrderPointDTO> getAllOrderPoints();

}
