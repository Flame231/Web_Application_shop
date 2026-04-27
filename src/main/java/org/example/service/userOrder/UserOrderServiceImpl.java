package org.example.service.userOrder;

import org.example.dao.orderPoint.OrderPointDAO;
import org.example.dao.orderPoint.OrderPointDAOIml;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.NewOrderDTO;
import org.example.model.UserOrder;
import org.example.model.UserOrderProduct;

public class UserOrderServiceImpl implements UserOrderService{

    @Override
    public void confirmOrder(NewOrderDTO newOrderDTO) {
        UserDAO userDAO = new UserDAOImpl();
        OrderPointDAO orderPointDAO = new OrderPointDAOIml();
        ProductDAO productDAO = new ProductDAOImpl();

        UserOrder userOrder = UserOrder.builder()
                .user(userDAO.get(newOrderDTO.getUserId()))
                .orderPoint(orderPointDAO.get(newOrderDTO.getOrderPointId()))
                .build();

        UserOrderProduct userOrderProduct = UserOrderProduct.builder()
                .userOrder(userOrder).product(productDAO.get(newOrderDTO.getProductId()))
                .productCount(newOrderDTO.getCount()).build();

    }
}
