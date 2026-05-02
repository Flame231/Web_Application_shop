package org.example.dao.bag;

import org.example.dao.DAO;
import org.example.model.Bag;

import java.util.List;

public interface BagDAO extends DAO<Bag> {

    List<Bag> getBagList(Integer userId);
}
