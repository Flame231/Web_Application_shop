package org.example.dto.ConverterDTO;

import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.dto.BagDTO;
import org.example.dto.dto.ProductDTO;
import org.example.model.Bag;
import org.example.model.Product;

public class BagDTOConverter implements ConverterDTO<Bag, BagDTO> {
    private ConverterDTO<Product, ProductDTO> converter = new ProductDTOConverter();

    @Override
    public Bag toEntity(BagDTO bagDTO) {
        UserDAO userDAO = new UserDAOImpl();
        BagDAO bagDAO = new BagDAOImpl();
        return Bag.builder().user(userDAO.get(bagDTO.getUserId())).product(converter.toEntity(bagDTO.getProduct()))
                .count(bagDTO.getCount())
                .build();
    }

    @Override
    public BagDTO toDTO(Bag bag) {
        return BagDTO.builder().userId(bag.getUser().getId())
                .product(converter.toDTO(bag.getProduct()))
                .count(bag.getCount()).build();
    }
}