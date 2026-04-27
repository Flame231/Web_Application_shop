package org.example.dao.orderPoint;

import org.example.dao.DAOImpl;
import org.example.model.OrderPoint;
import org.example.model.Product;

import java.util.List;

public class OrderPointDAOIml extends DAOImpl<OrderPoint> implements OrderPointDAO {
    public OrderPointDAOIml() {
        super(OrderPoint.class);
    }

    @Override
    public List<OrderPoint> getOrderPointList() {
        getEm().clear();
        return getEm().createQuery("from OrderPoint orderPoint", OrderPoint.class).getResultList();
    }
}
