package org.example.service.product;

import org.example.dto.ProductDTO;
import org.example.model.Product;

import java.io.Serializable;
import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    Product findProduct(Serializable id);

    void addProduct(Product product);

    public void updateProduct(Product product);

    public void removeProduct(Product product);
}
