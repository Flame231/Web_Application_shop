package org.example.service.productCategory;

import org.example.converterDTO.ProductCategoryConverter;
import org.example.dto.ProductCategoryDTO;
import org.example.model.ProductCategory;

import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {

    public List<ProductCategoryDTO> getProductCategoryDTOList() {
        return productCategoryDAO.getProductCategoryList().stream()
                .map(ProductCategoryConverter::toProductCategoryDTO)
                .toList();
    }
}
