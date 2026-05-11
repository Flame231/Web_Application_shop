package org.example.dto.NewDTO.NewConverterDTO;


import org.example.dto.NewDTO.SellerDTO;
import org.example.model.Seller;

public class SellerDTOConverter implements ConverterDTO<Seller, SellerDTO> {

    @Override
    public SellerDTO toDTO(Seller seller) {
        return SellerDTO.builder().id(seller.getId()).sellerName(seller.getSellerName())
                .sellerAddress(seller.getSellerAddress()).build();
    }

    @Override
    public Seller toEntity(SellerDTO seller) {
        return Seller.builder().sellerName(seller.getSellerName()).sellerAddress(seller.getSellerAddress())
                .id(seller.getId())
                .build();
    }
}
