package org.example.dao.productCategory;

import org.example.dao.DAOImpl;
import org.example.model.ProductCategory;

public class ProductCategoryDAOImpl extends DAOImpl<ProductCategory> implements ProductCategoryDAO {
    public ProductCategoryDAOImpl() {
        super(ProductCategory.class);
    }
}
