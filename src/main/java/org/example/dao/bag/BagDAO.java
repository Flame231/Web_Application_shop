package org.example.dao.bag;

import org.example.dao.DAO;
import org.example.model.Bag;
import org.example.model.Product;
import org.example.model.User;

import java.util.List;

public interface BagDAO extends DAO<Bag> {

    void addUser(Bag bag, User user);

    void addProduct(Bag bag, Product product, Integer count);

    List<Product> getBagList(Integer userId);
}
