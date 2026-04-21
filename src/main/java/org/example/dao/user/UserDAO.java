package org.example.dao.user;

import org.example.dao.DAO;
import org.example.model.Discount;
import org.example.model.User;
import org.example.model.UserOrder;

public interface UserDAO extends DAO<User> {

    void addUserOrder(User user, UserOrder userOrder);

    void addDiscount(User user, Discount discount);

    User findUser(String login, String password);
}
