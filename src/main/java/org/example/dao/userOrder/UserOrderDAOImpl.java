package org.example.dao.userOrder;

import org.example.dao.DAOImpl;
import org.example.model.UserOrder;

import java.io.Serializable;
import java.util.List;

public class UserOrderDAOImpl extends DAOImpl<UserOrder> implements UserOrderDAO {

    public UserOrderDAOImpl() {
        super(UserOrder.class);
    }

    @Override
    public List<UserOrder> getUserOrderList() {
        return getEm().createQuery("from UserOrder userOrder", UserOrder.class).getResultList();
    }

    @Override
    public List<UserOrder> getUserOrderByOrderPoint(Serializable orderPointId) {
        return getEm().createQuery("from UserOrder userOrder where" +
                " userOrder.orderPoint.id =:orderPointId", UserOrder.class).setParameter(
                "orderPointId", orderPointId).getResultList();
    }
}
