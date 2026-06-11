package org.example.dao.userOrder;

import org.example.dao.DAOImpl;
import org.example.model.UserOrder.OrderStatus;
import org.example.model.UserOrder.UserOrder;

import java.io.Serializable;
import java.util.List;

public class UserOrderDAOImpl extends DAOImpl<UserOrder> implements UserOrderDAO {

    public UserOrderDAOImpl() {
        super(UserOrder.class);
    }

    @Override
    public List<UserOrder> getUserOrderList() {
        return getEm().createQuery("select distinct uo from UserOrder uo left join fetch uo.userOrderProduct uop left join fetch uop.product p" +
                " left join fetch p.productCategory left join fetch p.seller" +
                " ORDER BY uo.id DESC", UserOrder.class).getResultList();
    }

    @Override
    public List<UserOrder> getUserOrderByOrderPoint(Serializable orderPointId) {
        return getEm().createQuery("select distinct uo from UserOrder uo left join fetch uo.userOrderProduct uop left join fetch uop.product p" +
                " left join fetch p.productCategory left join fetch p.seller where" +
                " uo.orderPoint.id =:orderPointId", UserOrder.class).setParameter(
                "orderPointId", orderPointId).getResultList();
    }

    @Override
    public List<UserOrder> getArrivedUserOrderByOrderPoint(Serializable orderPointId) {
        return getEm().createQuery("select distinct uo from UserOrder uo left join fetch uo.userOrderProduct uop left join fetch uop.product p" +
                " left join fetch p.productCategory left join fetch p.seller where" +
                " uo.orderPoint.id =:orderPointId AND uo.orderStatus=:orderStatus", UserOrder.class).setParameter(
                "orderPointId", orderPointId).setParameter("orderStatus", OrderStatus.READY).getResultList();
    }
}
