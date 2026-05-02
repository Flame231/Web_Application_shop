package org.example.service.orderPoint;

import org.example.converterDTO.ConverterDTO;
import org.example.converterDTO.OrderPointConverter;
import org.example.dao.orderPoint.OrderPointDAO;
import org.example.dao.orderPoint.OrderPointDAOIml;
import org.example.dao.userOrder.UserOrderDAO;
import org.example.dao.userOrder.UserOrderDAOImpl;
import org.example.dto.OrderPointDTO;
import org.example.model.OrderPoint;

import java.util.List;

public class OrderPointServiceImpl implements OrderPointService {

    OrderPointDAO orderPointDAO = new OrderPointDAOIml();
    UserOrderDAO userOrderDAO = new UserOrderDAOImpl();

    @Override
    public List<OrderPointDTO> getAllOrderPoints() {
        ConverterDTO<OrderPoint, OrderPointDTO> converterDTO = new OrderPointConverter();
        return orderPointDAO.getOrderPointList().stream().map(converterDTO::toDTO)
                .toList();
    }


}
