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
        return getEm().createQuery("from ArchivedUserOrder a where a.userId=:userId order by a.userOrderId desc", ArchivedUserOrder.class)
                .setParameter("userId", userId).getResultList();
    }

    @Override
    public List<ArchivedUserOrder> getAllArchivedUserOrders() {
        return List.of();
    }
}
