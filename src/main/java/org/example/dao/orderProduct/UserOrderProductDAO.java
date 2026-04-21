package org.example.dao.orderProduct;

import org.example.dao.DAO;
import org.example.model.Product;
import org.example.model.UserOrder;
import org.example.model.UserOrderProduct;

public interface UserOrderProductDAO extends DAO<UserOrderProduct> {

    void addUserOrder(UserOrderProduct userOrderProduct, UserOrder userOrder);

    void addProduct(UserOrderProduct userOrderProduct, Product product);
}
