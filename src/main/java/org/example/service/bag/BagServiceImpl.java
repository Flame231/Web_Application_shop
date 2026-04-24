package org.example.service.bag;

import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.ProductBagDTO;
import org.example.model.Bag;
import org.example.model.Product;
import org.example.model.User;
import org.example.model.additional.primaryKeys.PRUtil;
import org.example.model.additional.primaryKeys.PrimaryKeyBag;

import java.util.List;

public class BagServiceImpl implements BagService {

    private BagDAO bagDAO = new BagDAOImpl();

    @Override
    public void addProductToBag(Bag bag) {
        UserDAO userDAO = new UserDAOImpl();
        ProductDAO productDAO = new ProductDAOImpl();
        Product managedProduct = productDAO.get(bag.getProduct().getId());
        User managedUser = userDAO.get(bag.getUser().getId());
        PrimaryKeyBag primaryKeyBag = PRUtil.getPrimaryKeyBag(managedUser,managedProduct);
        Bag bag1 = bagDAO.get(primaryKeyBag);
        if (bag.getCount() != 0) {
            if (bag1 == null) {
                bagDAO.addUser(bag, managedUser);
                bagDAO.addProduct(bag, managedProduct, bag.getCount());
                bagDAO.save(bag);
            } else {
                bagDAO.begin();
                bag1.setCount(bag.getCount());
                bagDAO.commit();
            }
        }
        else{
            if(bag1!=null){
                bagDAO.delete(primaryKeyBag);
            }
        }

    }

    public List<ProductBagDTO> showAllBags(Integer userId) {
        return bagDAO.getBagList(userId);
    }

}
