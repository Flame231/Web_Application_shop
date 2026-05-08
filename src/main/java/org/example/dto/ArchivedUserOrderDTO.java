package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.model.Product;
import org.example.model.UserOrder.UserOrder;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Builder
@Getter
public class ArchivedUserOrderDTO {

    private Integer id;

    private Timestamp createDateTime;

    private Timestamp updateDateTime;

    private Integer userOrderId;

    private Integer userId;

    private String productName;

    private Integer productCount;

    private Integer actualProductCount;

    private BigDecimal productPrice;

    private String orderStatus;

    private BigDecimal orderSum;

    private BigDecimal finalOrderSum;

    private Timestamp userOrderCreateDateTime;

    private Timestamp userOrderCloseDateTime;
}
