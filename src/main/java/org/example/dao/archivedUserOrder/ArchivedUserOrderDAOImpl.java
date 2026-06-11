package org.example.dao.archivedUserOrder;

import org.example.dao.DAOImpl;
import org.example.model.ArchivedUserOrder;

import java.util.List;

public class ArchivedUserOrderDAOImpl extends DAOImpl<ArchivedUserOrder> implements ArchivedUserOrderDAO {

    public ArchivedUserOrderDAOImpl() {
        super(ArchivedUserOrder.class);
    }

    @Override
    public List<ArchivedUserOrder> getArchivedUserOrders(Integer userId) {
        return getEm().createQuery("select distinct a from ArchivedUserOrder a left join fetch a.archivedUserOrderProducts " +
                        "where a.userId=:userId order by a.userOrderId desc", ArchivedUserOrder.class)
                .setParameter("userId", userId).getResultList();
    }
}
