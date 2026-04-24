package org.example.model.additional.primaryKeys;

import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.model.Product;
import org.example.model.User;

public class PRUtil {
    public static PrimaryKeyBag getPrimaryKeyBag(User user, Product product) {
        new PrimaryKeyBag();
        return PrimaryKeyBag.builder().user(user.getId()).product(product.getId()).build();
    }
}
