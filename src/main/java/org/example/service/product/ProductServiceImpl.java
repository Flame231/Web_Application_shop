package org.example.service.product;

import org.example.converterDTO.ProductConverter;
import org.example.converterDTO.UserConverter;
import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.ProductDTO;
import org.example.dto.UserDTO;
import org.example.model.Bag;
import org.example.model.Product;
import org.example.model.User;
import org.example.model.additional.primaryKeys.PrimaryKeyBag;
import org.example.model.additional.primaryKeys.PrimaryKeyUtil;

import java.io.Serializable;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<ProductDTO> getAllProducts() {
        return productDAO.getProductList().stream()
                .map(ProductConverter::toProductDTO)
                .toList();
    }

    public Product findProduct(Serializable id) {
        return productDAO.get(id);
    }

    public void addProduct(Product product) {
        productDAO.save(product);
    }

    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    public void removeProduct(Product product) {
        productDAO.delete(product.getId());
    }
}
