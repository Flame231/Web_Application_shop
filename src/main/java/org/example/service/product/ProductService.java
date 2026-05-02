package org.example.service.product;

import org.example.dto.ProductDTO;

import java.io.Serializable;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO findProduct(Serializable id);

    void addProduct(ProductDTO productDTO);

    void updateProduct(ProductDTO productDTO);

    void removeProduct(Serializable id);
}
