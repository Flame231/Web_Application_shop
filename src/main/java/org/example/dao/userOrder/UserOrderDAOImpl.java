package org.example.dao.userOrder;

import org.example.dao.DAOImpl;
import org.example.model.UserOrder;

import java.util.List;

public class UserOrderDAOImpl extends DAOImpl<UserOrder> implements UserOrderDAO {

    public UserOrderDAOImpl() {
        super(UserOrder.class);
    }

    @Override
    public List<UserOrder> getUserOrderList() {
        return getEm().createQuery("from UserOrder userOrder", UserOrder.class).getResultList();
    }


}
