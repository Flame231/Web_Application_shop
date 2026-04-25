package org.example.dao.productCategory;

import org.example.dao.DAOImpl;
import org.example.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;
import org.example.service.productCategory.ProductCategoryService;

import java.util.List;

public class ProductCategoryDAOImpl extends DAOImpl<ProductCategory> implements ProductCategoryDAO {
    public ProductCategoryDAOImpl() {
        super(ProductCategory.class);
    }
    public List<ProductCategory> getProductCategoryList(){
        getEm().clear();
        List<ProductCategory> list = getEm().createQuery("from ProductCategory p", ProductCategory.class).getResultList();

        return  list;
    }
}
