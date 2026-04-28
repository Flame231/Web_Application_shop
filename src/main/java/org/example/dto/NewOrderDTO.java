package org.example.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class NewOrderDTO {

    private Integer userId;

    private Integer userOrderId;

    private Integer orderPointId;

    private Integer productId;

    private Integer Count;

    private BigDecimal productPrice;

}
