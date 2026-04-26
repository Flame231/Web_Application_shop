package org.example.service.productCategory;

import org.example.converterDTO.ProductCategoryConverter;
import org.example.dao.productCategory.ProductCategoryDAO;
import org.example.dao.productCategory.ProductCategoryDAOImpl;
import org.example.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;

import java.io.Serializable;
import java.util.List;

public interface ProductCategoryService {
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAOImpl();

    List<ProductCategoryDTO> getProductCategoryDTOList();

    ProductCategory findProductCategory(Serializable id);

    void addProductCategory(ProductCategory productCategory);

    void updateProductCategory(ProductCategory productCategory);

    void deleteProductCategory(Serializable id);
}
