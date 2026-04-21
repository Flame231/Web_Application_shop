package org.example.dao.discount;

import org.example.dao.DAOImpl;
import org.example.model.Discount;

public class DiscountDAOImpl extends DAOImpl<Discount> implements DiscountDAO {
    public DiscountDAOImpl() {
        super(Discount.class);
    }
}
