package org.example.service.userOrder;

import org.example.converterDTO.UserOrderConverter;
import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.dao.orderPoint.OrderPointDAO;
import org.example.dao.orderPoint.OrderPointDAOIml;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dao.userOrder.UserOrderDAO;
import org.example.dao.userOrder.UserOrderDAOImpl;
import org.example.dao.userOrderProduct.UserOrderProductDAO;
import org.example.dao.userOrderProduct.UserOrderProductDAOImpl;
import org.example.dto.NewOrderDTO;
import org.example.dto.UserOrderDTO;
import org.example.model.UserOrder;
import org.example.model.UserOrderProduct;
import org.example.model.additional.primaryKeys.PrimaryKeyBag;
import org.example.service.bag.BagServiceImpl;

import java.math.BigDecimal;
import java.util.List;

public class UserOrderServiceImpl implements UserOrderService {
    UserOrderDAO userOrderDAO = new UserOrderDAOImpl();

    @Override
    public void confirmOrder(List<NewOrderDTO> list) {
        UserDAO userDAO = new UserDAOImpl();
        OrderPointDAO orderPointDAO = new OrderPointDAOIml();
        ProductDAO productDAO = new ProductDAOImpl();
        UserOrderProductDAO userOrderProductDAO = new UserOrderProductDAOImpl();
        UserOrderDAO userOrderDAO = new UserOrderDAOImpl();
        BagDAO bagDAO = new BagDAOImpl();
        BigDecimal orderSum = BigDecimal.ZERO;
        UserOrder userOrder = UserOrder.builder().orderStatus("Оформлен")
                .user(userDAO.get(list.get(0).getUserId()))
                .orderPoint(orderPointDAO.get(list.get(0).getOrderPointId()))
                .build();
        userOrderDAO.save(userOrder);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCount() != 0) {
                UserOrderProduct userOrderProduct = UserOrderProduct.builder()
                        .userOrder(userOrder).product(productDAO.get(list.get(i).getProductId()))
                        .productCount(list.get(i).getCount()).productPrice(list.get(i).getProductPrice()).build();

                orderSum = orderSum.add((list.get(i).getProductPrice()));

                userOrderProductDAO.save(userOrderProduct);
                PrimaryKeyBag primaryKeyBag = new PrimaryKeyBag(list.get(i).getUserId(), list.get(i).getProductId());
                bagDAO.delete(primaryKeyBag);
            }
        }
        userOrder.setOrderSum(orderSum);
        userOrderDAO.update(userOrder);

    }

    @Override
    public List<UserOrderDTO> showAllUserOrders() {
        return userOrderDAO.getUserOrderList().stream().map(UserOrderConverter::toUserOrderDTO)
                .toList();
    }

}
