package org.example.service.userOrder;

import org.example.dao.orderPoint.OrderPointDAO;
import org.example.dao.orderPoint.OrderPointDAOIml;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dao.userOrderProduct.UserOrderProductDAO;
import org.example.dao.userOrderProduct.UserOrderProductDAOImpl;
import org.example.dto.NewOrderDTO;
import org.example.model.UserOrder;
import org.example.model.UserOrderProduct;

import java.util.List;

public class UserOrderServiceImpl implements UserOrderService {

    @Override
    public void confirmOrder(List<NewOrderDTO> list) {
        UserDAO userDAO = new UserDAOImpl();
        OrderPointDAO orderPointDAO = new OrderPointDAOIml();
        ProductDAO productDAO = new ProductDAOImpl();
        UserOrderProductDAO userOrderProductDAO = new UserOrderProductDAOImpl();

        for (int i = 0; i < list.size(); i++) {
            UserOrder userOrder = UserOrder.builder().orderStatus("Оформлен")
                    .user(userDAO.get(list.get(i).getUserId()))
                    .orderPoint(orderPointDAO.get(list.get(i).getOrderPointId()))
                    .build();
            UserOrderProduct userOrderProduct = UserOrderProduct.builder()
                    .userOrder(userOrder).product(productDAO.get(list.get(i).getProductId()))
                    .productCount(list.get(i).getCount()).build();
            userOrderProductDAO.save(userOrderProduct);
        }
    }
}
