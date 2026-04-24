package org.example.dao.bag;

import org.example.dao.DAOImpl;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.ProductBagDTO;
import org.example.model.Bag;
import org.example.model.Product;
import org.example.model.User;

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
    public List<ProductBagDTO> getBagList(Integer userId) {
        getEm().clear();
        return getEm()
                .createQuery("select new  org.example.dto.ProductBagDTO(p.id, p.productName, c.category, p.price, s.sellerName, b.count) " +
                        "from Product p JOIN p.productCategory c join p.seller s join Bag b on b.product = p and b.user.id=:user", ProductBagDTO.class)
                .setParameter("user", userId)
                .getResultList();
    }
}
