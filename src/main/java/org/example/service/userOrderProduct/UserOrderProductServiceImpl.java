package org.example.service.userOrderProduct;

import org.example.dao.userOrderProduct.UserOrderProductDAO;
import org.example.dao.userOrderProduct.UserOrderProductDAOImpl;
import org.example.model.UserOrderProduct;
import org.example.model.additional.primaryKeys.PrimaryKeyUserOrderProduct;
import org.example.model.additional.primaryKeys.PrimaryKeyUtil;

public class UserOrderProductServiceImpl implements UserOrderProductService {
    UserOrderProductDAO userOrderProductDAO = new UserOrderProductDAOImpl();

    @Override
    public void changeProductCount(Integer userOrderId, Integer productId,
                                   Integer count) {
        PrimaryKeyUserOrderProduct primaryKeyUserOrderProduct =
                PrimaryKeyUtil.getPrimaryKeyUserOrderProduct(userOrderId, productId);
        UserOrderProduct userOrderProduct = userOrderProductDAO.get(primaryKeyUserOrderProduct);
        if (userOrderProduct.getProductCount() + count >= 0) {
            Integer newCount = userOrderProduct.getProductCount() + count;
            userOrderProductDAO.begin();
            userOrderProduct.setProductCount(newCount);
            userOrderProductDAO.commit();
        } else {
            userOrderProductDAO.delete(primaryKeyUserOrderProduct);
        }
    }
}
