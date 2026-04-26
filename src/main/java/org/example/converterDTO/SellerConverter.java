package org.example.converterDTO;

import org.example.dto.SellerDTO;
import org.example.model.Seller;

public class SellerConverter {
    public static SellerDTO toSellerDTO(Seller seller) {
        return SellerDTO.builder().id(seller.getId())
                .sellerName(seller.getSellerName())
                .sellerAddress(seller.getSellerAddress())
                .product(seller.getProduct()).build();
    }
}
