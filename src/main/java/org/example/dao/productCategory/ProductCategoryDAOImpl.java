package org.example.dao.productCategory;

import org.example.dao.DAOImpl;
import org.example.model.ProductCategory;

import java.util.List;

public class ProductCategoryDAOImpl extends DAOImpl<ProductCategory> implements ProductCategoryDAO {
    public ProductCategoryDAOImpl() {
        super(ProductCategory.class);
    }

    @Override
    public List<ProductCategory> getProductCategoryList() {
        getEm().clear();
        return getEm().createQuery("from ProductCategory p", ProductCategory.class).getResultList();
    }


}
