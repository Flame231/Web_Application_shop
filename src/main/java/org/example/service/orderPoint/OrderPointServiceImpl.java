package org.example.service.orderPoint;

import org.example.converterDTO.OrderPointConvertver;
import org.example.dao.orderPoint.OrderPointDAO;
import org.example.dao.orderPoint.OrderPointDAOIml;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dao.userOrder.UserOrderDAO;
import org.example.dao.userOrder.UserOrderDAOImpl;
import org.example.dto.NewOrderDTO;
import org.example.dto.OrderPointDTO;
import org.example.model.*;

import java.util.List;

public class OrderPointServiceImpl implements OrderPointService {

    OrderPointDAO orderPointDAO = new OrderPointDAOIml();
    UserOrderDAO userOrderDAO = new UserOrderDAOImpl();

    @Override
    public List<OrderPointDTO> getAllOrderPoints() {
        return orderPointDAO.getOrderPointList().stream().map(OrderPointConvertver::toOrderPointDTO)
                .toList();
    }



}
