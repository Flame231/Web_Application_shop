package org.example.dao.userOrderProduct;

import org.example.dao.DAO;
import org.example.model.Product;
import org.example.model.UserOrder;
import org.example.model.UserOrderProductDTO;

public interface UserOrderProductDAO extends DAO<UserOrderProductDTO> {

    void addUserOrder(UserOrderProductDTO userOrderProduct, UserOrder userOrder);

    void addProduct(UserOrderProductDTO userOrderProduct, Product product);
}
