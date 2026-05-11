package org.example.service.product;

import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dto.NewDTO.NewConverterDTO.ConverterDTO;
import org.example.dto.NewDTO.NewConverterDTO.ProductDTOConverter;
import org.example.dto.NewDTO.NewProductDTO;
import org.example.model.Product;

import java.io.Serializable;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();
    private ConverterDTO<Product, NewProductDTO> converterDTO = new ProductDTOConverter();

    @Override
    public List<NewProductDTO> getAllProducts() {
        return productDAO.getProductList().stream()
                .map(converterDTO::toDTO)
                .toList();
    }

    public NewProductDTO findProduct(Serializable id) {
        return converterDTO.toDTO(productDAO.get(id));
    }

    @Override
    public void addProduct(NewProductDTO productDTO) {
        Product product = converterDTO.toEntity(productDTO);
        productDAO.save(product);
    }

    @Override
    public void updateProduct(NewProductDTO productDTO) {
        Product product = converterDTO.toEntity(productDTO);
        productDAO.update(product);
    }

    @Override
    public void removeProduct(Serializable id) {

        productDAO.delete(id);
    }
}
