package org.example.service.product;

import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dto.ConverterDTO.ConverterDTO;
import org.example.dto.ConverterDTO.ProductDTOConverter;
import org.example.dto.dto.ProductDTO;
import org.example.model.Product;

import java.io.Serializable;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();
    private ConverterDTO<Product, ProductDTO> converterDTO = new ProductDTOConverter();

    @Override
    public List<ProductDTO> getAllProducts(int currentPage) {
        return productDAO.getProductList(currentPage).stream()
                .map(converterDTO::toDTO)
                .toList();
    }

    public ProductDTO findProduct(Serializable id) {
        return converterDTO.toDTO(productDAO.get(id));
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = converterDTO.toEntity(productDTO);
        productDAO.save(product);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = converterDTO.toEntity(productDTO);
        productDAO.update(product);
    }

    @Override
    public void removeProduct(Serializable id) {
        productDAO.delete(id);
    }

    @Override
    public Integer getProductCountResult() {
        return productDAO.getProductsCount();
    }

    @Override
    public ProductPagesDivide getProductsAndList(Integer currentPage) {
        List<ProductDTO> productList = null;
        if (currentPage != null) {
        } else {
            currentPage = 1;
        }
        productList = this.getAllProducts(currentPage);
        int productCountResult = this.getProductCountResult();
        return new ProductPagesDivide(productList, productCountResult, currentPage);
    }
}
