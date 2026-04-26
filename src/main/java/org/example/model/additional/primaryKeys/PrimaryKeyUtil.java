package org.example.model.additional.primaryKeys;

import org.example.model.Product;
import org.example.model.User;

public class PrimaryKeyUtil {
    public static PrimaryKeyBag getPrimaryKeyBag(User user, Product product) {
        new PrimaryKeyBag();
        return PrimaryKeyBag.builder().user(user.getId()).product(product.getId()).build();
    }

    public static PrimaryKeyBag getPrimaryKeyBag(Integer userId, Integer productId) {
        new PrimaryKeyBag();
        return PrimaryKeyBag.builder().user(userId).product(productId).build();
    }
}
