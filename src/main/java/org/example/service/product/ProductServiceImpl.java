package org.example.service.product;

import org.example.converterDTO.ProductConverter;
import org.example.converterDTO.UserConverter;
import org.example.dao.product.ProductDAO;
import org.example.dao.product.ProductDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.ProductDTO;
import org.example.dto.UserDTO;
import org.example.model.User;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public List<ProductDTO> getAllProducts() {
        return productDAO.getProductList().stream()
                .map(ProductConverter::toProductDTO)
                .toList();
    }
}
