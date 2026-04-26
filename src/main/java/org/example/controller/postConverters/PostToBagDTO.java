package org.example.controller.postConverters;

import org.example.dto.BagDTO;
import org.example.dto.ProductBagDTO;

import javax.servlet.http.HttpServletRequest;

public class PostToBagDTO {
    public static BagDTO toBagDTO(HttpServletRequest request) {

        Integer user_id =(Integer)(request.getSession().getAttribute("userId"));
        Integer product_id = Integer.parseInt(request.getParameter("product_id"));
        Integer count = Integer.parseInt(request.getParameter("count"));

        return BagDTO.builder()
                .userId(user_id)
                .product_id(product_id)
                .count(count)
                .build();
    }
}
