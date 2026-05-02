package org.example.converterDTO;

import org.example.dao.bag.BagDAO;
import org.example.dao.bag.BagDAOImpl;
import org.example.dto.BagDTO;
import org.example.model.Bag;

public class BagConverter implements ConverterDTO<Bag, BagDTO> {
    @Override
    public Bag toEntity(BagDTO bagDTO) {
        BagDAO bagDAO = new BagDAOImpl();
        return Bag.builder().user(bagDTO.getUser()).product(bagDTO.getProduct())
                .count(bagDTO.getCount())
                .build();
    }

    @Override
    public BagDTO toDTO(Bag bag) {
        return BagDTO.builder().user(bag.getUser())
                .product(bag.getProduct())
                .count(bag.getCount()).build();
    }
}