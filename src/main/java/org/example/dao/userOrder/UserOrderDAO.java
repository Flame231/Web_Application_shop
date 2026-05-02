package org.example.dao.userOrder;

import org.example.dao.DAO;
import org.example.model.UserOrder;

import java.io.Serializable;
import java.util.List;

public interface UserOrderDAO extends DAO<UserOrder> {

    List<UserOrder> getUserOrderList();

    List<UserOrder> getUserOrderByOrderPoint(Serializable orderPointId);
}
