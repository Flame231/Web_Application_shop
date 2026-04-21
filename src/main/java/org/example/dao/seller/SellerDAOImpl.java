package org.example.dao.seller;

import org.example.dao.DAOImpl;
import org.example.model.Seller;
import org.example.model.User;

public class SellerDAOImpl extends DAOImpl<Seller> implements SellerDAO {
    public SellerDAOImpl() {
        super(Seller.class);
    }
}
