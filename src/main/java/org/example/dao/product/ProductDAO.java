package org.example.dao.product;

import org.example.dao.DAO;
import org.example.model.Product;
import org.example.model.ProductCategory;
import org.example.model.Seller;
import org.example.model.User;

import java.util.List;

public interface ProductDAO extends DAO<Product> {

    void addSeller(Product product, Seller seller);

    void addProductCategory(Product product, ProductCategory productCategory);

    List<Product> getProductList();


}
