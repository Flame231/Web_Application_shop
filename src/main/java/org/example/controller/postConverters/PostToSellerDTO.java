package org.example.controller.postConverters;

import org.example.dto.SellerDTO;

import javax.servlet.http.HttpServletRequest;

import static org.example.util.NamesUtil.*;

public class PostToSellerDTO {
    public static SellerDTO toSellerDTO(HttpServletRequest request) {
        PostConverter postConverter = new PostConverter(request);


        String sellerName = postConverter.convert(SELLER_NAME_PARAMETER, String.class);
        String sellerAddress = postConverter.convert(SELLER_ADDRESS_PARAMETER, String.class);

        if (request.getParameter(SELLER_ID_PARAMETER) != null) {
            Integer sellerId = postConverter.convert(SELLER_ID_PARAMETER, Integer.class);
            return SellerDTO.builder()
                    .id(sellerId).sellerName(sellerName)
                    .sellerAddress(sellerAddress)
                    .build();
        }
        return SellerDTO.builder()
                .sellerName(sellerName)
                .sellerAddress(sellerAddress)
                .build();
    }
}
