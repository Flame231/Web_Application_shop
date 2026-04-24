package org.example.converterDTO;

import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.BagDTO;
import org.example.model.Bag;

public class BagConverter {
    public static Bag toBagEntity(BagDTO bagDTO) {
        UserDAO userDAO = new UserDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();
        Bag bag = Bag.builder().user(userDAO.get(bagDTO.getUserId())).count(bagDTO.getCount())
                .product(productDAO.get(bagDTO.getProduct_id())).build();
        return bag;
    }
}