package org.example.dao.productCategory;

import org.example.dao.DAO;
import org.example.model.ProductCategory;

import java.util.List;

public interface ProductCategoryDAO extends DAO<ProductCategory> {

    List<ProductCategory> getProductCategoryList();
}
