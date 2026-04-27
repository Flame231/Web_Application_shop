package org.example.dao.userOrderProduct;

import org.example.dao.DAOImpl;
import org.example.model.Product;
import org.example.model.UserOrder;
import org.example.model.UserOrderProduct;

public class UserOrderProductDAOImpl extends DAOImpl<UserOrderProduct> implements UserOrderProductDAO {
    public UserOrderProductDAOImpl() {
        super(UserOrderProduct.class);
    }

    public void addUserOrder(UserOrderProduct userOrderProduct, UserOrder userOrder) {
        begin();
        userOrderProduct.setUserOrder(userOrder);
        userOrder.getUserOrderProduct().add(userOrderProduct);
        commit();
    }

    public void addProduct(UserOrderProduct userOrderProduct, Product product) {
        begin();
        userOrderProduct.setProduct(product);
        product.getUserOrderProducts().add(userOrderProduct);
        commit();
    }
}
