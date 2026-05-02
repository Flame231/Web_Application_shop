package org.example.dao.userOrderProduct;

import org.example.dao.DAOImpl;
import org.example.model.Product;
import org.example.model.UserOrder;
import org.example.model.UserOrderProductDTO;

public class UserOrderProductDAOImpl extends DAOImpl<UserOrderProductDTO> implements UserOrderProductDAO {
    public UserOrderProductDAOImpl() {
        super(UserOrderProductDTO.class);
    }

    @Override
    public void addUserOrder(UserOrderProductDTO userOrderProduct, UserOrder userOrder) {
        begin();
        userOrderProduct.setUserOrder(userOrder);
        userOrder.getUserOrderProduct().add(userOrderProduct);
        commit();
    }

    @Override
    public void addProduct(UserOrderProductDTO userOrderProduct, Product product) {
        begin();
        userOrderProduct.setProduct(product);
        product.getUserOrderProducts().add(userOrderProduct);
        commit();
    }
}
