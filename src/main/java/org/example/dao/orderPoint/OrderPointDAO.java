package org.example.dao.orderPoint;

import org.example.dao.DAO;
import org.example.model.OrderPoint;

import java.util.List;

public interface OrderPointDAO extends DAO<OrderPoint> {

    public List<OrderPoint> getOrderPointList();
}
