package org.example.dao.archivedUserOrder;

import org.example.dao.DAO;
import org.example.model.ArchivedUserOrder;

import java.util.List;

public interface ArchivedUserOrderDAO extends DAO <ArchivedUserOrder>{

    List<ArchivedUserOrder> getArchivedUserOrders(Integer userId);

}
