package org.example.controller.postConverters;

import org.example.dto.ProductCategoryDTO;
import org.example.dto.SellerDTO;
import org.example.model.Seller;

import javax.servlet.http.HttpServletRequest;

public class PostToSellerDTO {
    public static SellerDTO toSellerDTO(HttpServletRequest request) {
        String sellerName = request.getParameter("sellerName");
        String sellerAddress = request.getParameter("sellerAddress");
        if (request.getParameter("sellerId") != null) {
            Integer sellerId = Integer.parseInt(request.getParameter("sellerId"));
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
