package org.example.service.userOrderProduct;

import org.example.dao.userOrderProduct.UserOrderProductDAO;
import org.example.dao.userOrderProduct.UserOrderProductDAOImpl;
import org.example.model.UserOrder.UserOrderProduct;
import org.example.model.additional.primaryKeys.PrimaryKeyUserOrderProduct;
import org.example.model.additional.primaryKeys.PrimaryKeyUtil;

public class UserOrderProductServiceImpl implements UserOrderProductService {
    private UserOrderProductDAO userOrderProductDAO = new UserOrderProductDAOImpl();

    @Override
    public void changeProductCount(Integer userOrderId, Integer productId,
                                   Integer count) {
        PrimaryKeyUserOrderProduct primaryKeyUserOrderProduct =
                PrimaryKeyUtil.getPrimaryKeyUserOrderProduct(userOrderId, productId);
        UserOrderProduct userOrderProduct = userOrderProductDAO.get(primaryKeyUserOrderProduct);
        userOrderProductDAO.refresh(userOrderProduct);
        if (userOrderProduct.getActualProductCount() + count >= 0) {
            if (userOrderProduct.getActualProductCount() + count <= userOrderProduct.getProductCount()) {
                Integer newCount = userOrderProduct.getActualProductCount() + count;
                userOrderProductDAO.begin();
                userOrderProduct.setActualProductCount(newCount);
                userOrderProductDAO.flush();
                userOrderProductDAO.commit();
            }
        }
    }
}
