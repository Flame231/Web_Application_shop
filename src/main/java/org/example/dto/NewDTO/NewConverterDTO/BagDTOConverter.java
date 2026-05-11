package org.example.dto.NewDTO.NewConverterDTO;

import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.NewDTO.BagDTO;
import org.example.dto.NewDTO.NewProductDTO;
import org.example.model.Bag;
import org.example.model.Product;

public class BagDTOConverter implements ConverterDTO<Bag, BagDTO> {
    private ConverterDTO<Product, NewProductDTO> converter = new ProductDTOConverter();

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