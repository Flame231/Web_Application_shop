package org.example.service.product;

import org.example.converterDTO.ConverterDTO;
import org.example.converterDTO.ProductConverter;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dto.ProductDTO;
import org.example.model.Product;

import java.io.Serializable;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();
    private ConverterDTO<Product, ProductDTO> converterDTO = new ProductConverter();

    @Override
    public List<ProductDTO> getAllProducts() {
        ConverterDTO<Product, ProductDTO> converterDTO = new ProductConverter();
        return productDAO.getProductList().stream()
                .map(converterDTO::toDTO)
                .toList();
    }

    public ProductDTO findProduct(Serializable id) {
        return converterDTO.toDTO(productDAO.get(id));
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        ConverterDTO<Product, ProductDTO> converterDTO = new ProductConverter();
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
}
