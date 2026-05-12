package org.example.dao.user;

import org.example.dao.DAOImpl;
import org.example.model.Discount;
import org.example.model.UserOrder.UserOrder;
import org.example.model.user.User;

import javax.persistence.NoResultException;

public class UserDAOImpl extends DAOImpl<User> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    public void addUserOrder(User user, UserOrder userOrder) {
        begin();
        user.getUserOrders().add(userOrder);
        userOrder.setUser(user);
        commit();
    }

    @Override
    public void addDiscount(User user, Discount discount) {
        begin();
        user.setDiscount(discount);
        discount.getUsers().add(user);
        commit();
    }

    @Override
    public User findUser(String login) {
        getEm().clear();
        User user = null;
        try {
            user = getEm().createQuery("from User user where user.login =: login", User.class)
                    .setParameter("login", login).getSingleResult();
        } catch (NoResultException e) {
        }
        return user;
    }
}
