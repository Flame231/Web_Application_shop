package org.example.dao.userOrder;

import org.example.dao.DAO;
import org.example.model.OrderPoint;
import org.example.model.UserOrder;

import java.util.List;

public interface UserOrderDAO extends DAO<UserOrder> {

    List<UserOrder> getUserOrderList();
    
}
