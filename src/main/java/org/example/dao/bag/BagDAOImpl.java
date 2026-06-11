package org.example.dao.bag;

import org.example.dao.DAOImpl;
import org.example.model.Bag;

import java.util.List;

public class BagDAOImpl extends DAOImpl<Bag> implements BagDAO {

    public BagDAOImpl() {
        super(Bag.class);
    }

    @Override
    public List<Bag> getBagList(Integer userId) {
        getEm().clear();
        return getEm()
                .createQuery("select distinct bag from Bag bag left join fetch bag.product p left join fetch p.productCategory " +
                        "left join fetch p.seller where bag.user.id = :userId", Bag.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
