package org.example.dao.seller;

import org.example.dao.DAOImpl;
import org.example.model.Seller;
import org.example.model.User;

import java.util.List;

public class SellerDAOImpl extends DAOImpl<Seller> implements SellerDAO {
    public SellerDAOImpl() {
        super(Seller.class);
    }

    public List<Seller> getSellerList() {
        return getEm().createQuery("from Seller s", Seller.class)
                .getResultList();
    }
}
