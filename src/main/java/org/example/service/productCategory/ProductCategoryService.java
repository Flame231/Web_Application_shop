package org.example.service.productCategory;

import org.example.dao.productCategory.ProductCategoryDAO;
import org.example.dao.productCategory.ProductCategoryDAOImpl;
import org.example.dto.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;

import java.io.Serializable;
import java.util.List;

public interface ProductCategoryService {

    List<ProductCategoryDTO> getProductCategoryDTOList();

    ProductCategory findProductCategory(Serializable id);

    void addProductCategory(ProductCategoryDTO productCategoryDTO);

    void updateProductCategory(ProductCategoryDTO productCategoryDTO);

    void deleteProductCategory(Serializable id);
}
