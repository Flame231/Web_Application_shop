package org.example.dao.bag;

import org.example.dao.DAOImpl;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.model.Bag;
import org.example.model.Product;
import org.example.model.User;
import org.example.model.additional.PrimaryKeyBag;

import java.util.List;

public class BagDAOImpl extends DAOImpl<Bag> implements BagDAO {

    public BagDAOImpl() {
        super(Bag.class);
    }

    @Override
    public void addUser(Bag bag, User user) {
        begin();
        UserDAO userDAO = new UserDAOImpl();
        User user1 = userDAO.get(user.getId());
        bag.setUser(user1);
        commit();
    }

    @Override
    public void addProduct(Bag bag, Product product, Integer count) {
        begin();
        ProductDAO productDAO = new ProductDAOImpl();
        Product product1 = productDAO.get(product.getId());
        bag.setProduct(product1);
        bag.setCount(count);
        commit();
    }


    @Override
    public List<Product> getBagList(Integer userId) {
        getEm().clear();
        return getEm()
                .createQuery("select bag.product product from Bag bag where bag.user.id =:user", Product.class)
                .setParameter("user",userId)
                .getResultList();
    }
}
