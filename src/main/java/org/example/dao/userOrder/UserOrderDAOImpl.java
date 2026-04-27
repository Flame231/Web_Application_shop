package org.example.dao.userOrder;

import org.example.dao.DAOImpl;
import org.example.model.OrderPoint;
import org.example.model.UserOrder;

public class UserOrderDAOImpl extends DAOImpl<UserOrder> implements UserOrderDAO {

    public UserOrderDAOImpl() {
        super(UserOrder.class);
    }



}
