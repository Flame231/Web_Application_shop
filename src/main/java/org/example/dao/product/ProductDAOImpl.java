package org.example.dao.product;

import org.example.dao.DAOImpl;
import org.example.model.Product;
import org.example.model.ProductCategory;
import org.example.model.Seller;
import org.example.model.User;

import java.util.List;

public class ProductDAOImpl extends DAOImpl<Product> implements ProductDAO {
    public ProductDAOImpl() {
        super(Product.class);
    }

    @Override
    public void addSeller(Product product, Seller seller) {
        begin();
        product.setSeller(seller);
        seller.getProduct().add(product);
        commit();
    }

    @Override
    public void addProductCategory(Product product, ProductCategory productCategory) {
        begin();
        product.setProductCategory(productCategory);
        productCategory.getProducts().add(product);
        commit();
    }

    @Override
    public List<Product> getProductList() {
        getEm().clear();
        return getEm().createQuery("from Product product", Product.class).getResultList();
    }
}
