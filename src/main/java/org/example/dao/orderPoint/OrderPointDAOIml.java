package org.example.dao.orderPoint;

import org.example.dao.DAOImpl;
import org.example.model.OrderPoint;

public class OrderPointDAOIml extends DAOImpl<OrderPoint> implements OrderPointDAO {
    public OrderPointDAOIml() {
        super(OrderPoint.class);
    }
}
