package org.example.model.additional.primaryKeys;

import org.example.model.Product;
import org.example.model.user.User;

public class PrimaryKeyUtil {
    public static PrimaryKeyBag getPrimaryKeyBag(User user, Product product) {
        return PrimaryKeyBag.builder().user(user.getId()).product(product.getId()).build();
    }

    public static PrimaryKeyBag getPrimaryKeyBag(Integer userId, Integer productId) {
        return PrimaryKeyBag.builder().user(userId).product(productId).build();
    }

    public static PrimaryKeyUserOrderProduct getPrimaryKeyUserOrderProduct(Integer userOrderId, Integer productId) {
        return PrimaryKeyUserOrderProduct.builder().userOrder(userOrderId).product(productId).build();
    }
}
