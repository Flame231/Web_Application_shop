package org.example.service.productCategory;

import org.example.converterDTO.ProductCategoryConverter;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.productCategory.ProductCategoryDAO;
import org.example.dao.productCategory.ProductCategoryDAOImpl;
import org.example.dto.ProductCategoryDTO;
import org.example.model.Product;
import org.example.model.ProductCategory;

import java.io.Serializable;
import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {
    ProductCategoryDAO productCategoryDAO = new ProductCategoryDAOImpl();

    public List<ProductCategoryDTO> getProductCategoryDTOList() {
        return productCategoryDAO.getProductCategoryList().stream()
                .map(ProductCategoryConverter::toProductCategoryDTO)
                .toList();
    }

    public ProductCategory findProductCategory(Serializable id) {
        return productCategoryDAO.get(id);
    }

    public void addProductCategory(ProductCategory productCategory){

        productCategoryDAO.save(productCategory);
    }

    public void updateProductCategory(ProductCategory productCategory){
        productCategoryDAO.update(productCategory);
    }

    @Override
    public void deleteProductCategory(Serializable id) {
        ProductDAO productDAO = new ProductDAOImpl();
        ProductCategory productCategory = productCategoryDAO.get(id);
        productCategoryDAO.delete(id);
    }
}
