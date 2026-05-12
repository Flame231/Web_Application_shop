package org.example.dto.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class OrderDTO {

    private Integer userId;

    private Integer userOrderId;

    private Integer orderPointId;

    private Integer productId;

    private Integer Count;

    private BigDecimal productPrice;

}
