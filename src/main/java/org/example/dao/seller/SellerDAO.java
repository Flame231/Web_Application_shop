package org.example.dao.seller;

import org.example.dao.DAO;
import org.example.model.Seller;
import org.example.model.User;

import java.util.List;

public interface SellerDAO extends DAO<Seller> {

    List<Seller> getSellerList();
}
