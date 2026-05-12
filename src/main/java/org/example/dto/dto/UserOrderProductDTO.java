package org.example.dto.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserOrderProductDTO {

    private Integer userOrderId;

    private ProductDTO productDTO;

    private Integer productCount;

    private Integer actualProductCount;
}
