package org.example.converterDTO;

import org.example.dto.SellerDTO;
import org.example.model.Seller;

public class SellerConverter implements ConverterDTO<Seller, SellerDTO> {

    @Override
    public SellerDTO toDTO(Seller seller) {
        return SellerDTO.builder().id(seller.getId()).sellerName(seller.getSellerName())
                .sellerAddress(seller.getSellerAddress()).product(seller.getProduct()).build();
    }

    @Override
    public Seller toEntity(SellerDTO seller) {
        return Seller.builder().sellerName(seller.getSellerName()).sellerAddress(seller.getSellerAddress())
                .product(seller.getProduct()).id(seller.getId())
                .build();
    }
}
