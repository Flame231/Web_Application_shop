package org.example.service.productCategory;

import org.example.dao.productCategory.ProductCategoryDAO;
import org.example.dao.productCategory.ProductCategoryDAOImpl;
import org.example.dto.ConverterDTO.ConverterDTO;
import org.example.dto.ConverterDTO.ProductCategoryDTOConverter;
import org.example.dto.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;

import java.io.Serializable;
import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryDAO productCategoryDAO = new ProductCategoryDAOImpl();
    private ConverterDTO<ProductCategory, ProductCategoryDTO> converterDTO = new ProductCategoryDTOConverter();


    public List<ProductCategoryDTO> getProductCategoryDTOList() {
        ConverterDTO<ProductCategory, ProductCategoryDTO> converterDTO = new ProductCategoryDTOConverter();
        return productCategoryDAO.getProductCategoryList().stream()
                .map(converterDTO::toDTO)
                .toList();
    }

    public ProductCategory findProductCategory(Serializable id) {
        return productCategoryDAO.get(id);
    }

    @Override
    public void addProductCategory(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = converterDTO.toEntity(productCategoryDTO);
        productCategoryDAO.save(productCategory);
    }

    @Override
    public void updateProductCategory(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = converterDTO.toEntity(productCategoryDTO);
        productCategoryDAO.update(productCategory);
    }

    @Override
    public void deleteProductCategory(Serializable id) {
        productCategoryDAO.delete(id);
    }
}
