package org.example.service.product;

import org.example.dto.NewDTO.NewProductDTO;

import java.io.Serializable;
import java.util.List;

public interface ProductService {

    List<NewProductDTO> getAllProducts(int currentPage);

    NewProductDTO findProduct(Serializable id);

    void addProduct(NewProductDTO productDTO);

    void updateProduct(NewProductDTO productDTO);

    void removeProduct(Serializable id);

    Integer getProductCountResult();
}
