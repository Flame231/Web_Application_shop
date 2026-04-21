package org.example.service.bag;

import org.example.converterDTO.ProductConverter;
import org.example.converterDTO.UserConverter;
import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.BagDTO;
import org.example.dto.LoginDTO;
import org.example.dto.ProductDTO;
import org.example.dto.UserDTO;
import org.example.model.Bag;
import org.example.model.Product;
import org.example.model.User;
import org.example.model.additional.PrimaryKeyBag;

import java.io.Serializable;
import java.util.List;

public class BagServiceImpl implements BagService {

    private BagDAO bagDAO = new BagDAOImpl();

    @Override
    public void addProductToBag(Bag bag) {
        UserDAO userDAO = new UserDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();
        Product product = productDAO.get(bag.getProduct().getId());
        User user = userDAO.get(bag.getUser().getId());
        PrimaryKeyBag primaryKeyBag = new PrimaryKeyBag();
        primaryKeyBag.setProduct(product.getId());
        primaryKeyBag.setUser(user.getId());
        Bag bag1 = bagDAO.get(primaryKeyBag);
        if (bag1 == null) {
            bagDAO.addUser(bag, user);
            bagDAO.addProduct(bag, product, bag.getCount());
            bagDAO.save(bag);
        } else {
            bagDAO.begin();
            bag1.setCount(bag.getCount() + bag1.getCount());
            bagDAO.commit();
        }
    }

    public List<ProductDTO> showAllBags(Integer userId){
        return bagDAO.getBagList(userId).stream()
            .map(ProductConverter::toProductDTO)
            .toList();
    }

}
