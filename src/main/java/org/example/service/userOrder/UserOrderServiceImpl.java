package org.example.service.userOrder;

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
import org.example.dto.ConverterDTO.ConverterDTO;
import org.example.dto.ConverterDTO.UserOrderDTOConverter;
import org.example.dto.dto.OrderDTO;
import org.example.dto.dto.UserOrderDTO;
import org.example.model.UserOrder.OrderStatus;
import org.example.model.UserOrder.UserOrder;
import org.example.model.UserOrder.UserOrderProduct;
import org.example.model.additional.primaryKeys.PrimaryKeyBag;
import org.example.model.user.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class UserOrderServiceImpl implements UserOrderService {
    private UserOrderDAO userOrderDAO = new UserOrderDAOImpl();
    private UserDAO userDAO = new UserDAOImpl();
    private ConverterDTO<UserOrder, UserOrderDTO> converterDTO = new UserOrderDTOConverter();

    @Override
    public void confirmOrder(List<OrderDTO> list) {

        OrderPointDAO orderPointDAO = new OrderPointDAOIml();
        ProductDAO productDAO = new ProductDAOImpl();
        UserOrderProductDAO userOrderProductDAO = new UserOrderProductDAOImpl();
        UserOrderDAO userOrderDAO = new UserOrderDAOImpl();
        BagDAO bagDAO = new BagDAOImpl();
        BigDecimal orderSum = BigDecimal.ZERO;
        UserOrder userOrder = UserOrder.builder().orderStatus(OrderStatus.CREATED)
                .user(userDAO.get(list.get(0).getUserId()))
                .orderPoint(orderPointDAO.get(list.get(0).getOrderPointId()))
                .build();
        userOrderDAO.save(userOrder);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCount() != 0) {
                UserOrderProduct userOrderProduct = UserOrderProduct.builder()
                        .userOrder(userOrder).product(productDAO.get(list.get(i).getProductId()))
                        .productCount(list.get(i).getCount()).actualProductCount(list.get(i).getCount()).productPrice(list.get(i).getProductPrice()).build();

                orderSum = orderSum.add(((list.get(i).getProductPrice()).multiply(new BigDecimal(list.get(i).getCount()))));

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
        ConverterDTO<UserOrder, UserOrderDTO> converterDTO = new UserOrderDTOConverter();
        return userOrderDAO.getUserOrderList().stream().map(converterDTO::toDTO)
                .toList();
    }

    @Override
    public List<UserOrderDTO> showUserOrdersByOrderPoint(Serializable userId) {
        User user = userDAO.get(userId);
        Integer orderPointId = user.getOrderPoint().getId();
        List<UserOrder> userOrderList = userOrderDAO.getUserOrderByOrderPoint(orderPointId);
        return userOrderList.stream().map(converterDTO::toDTO).toList();
    }

    @Override
    public List<UserOrderDTO> showArrivedUserOrdersByOrderPoint(Serializable userId) {
        User user = userDAO.get(userId);
        Integer orderPointId = user.getOrderPoint().getId();
        List<UserOrder> userOrderList = userOrderDAO.getArrivedUserOrderByOrderPoint(orderPointId);
        return userOrderList.stream().map(converterDTO::toDTO).toList();
    }

    @Override
    public UserOrderDTO getUserOrderDTO(Serializable id) {
        UserOrder userOrder = userOrderDAO.get(id);
        return converterDTO.toDTO(userOrder);
    }

}
