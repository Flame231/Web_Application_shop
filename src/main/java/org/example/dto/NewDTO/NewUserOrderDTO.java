package org.example.dto.NewDTO;

import lombok.Builder;
import lombok.Getter;
import org.example.model.UserOrder.OrderStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


@Builder
@Getter
public class NewUserOrderDTO {

    private Integer orderId;

    private OrderStatus orderStatus;

    private String orderPoint;

    private BigDecimal orderSum;

    private Timestamp OrderCreateDateTime;

    private Set<NewUserOrderProductDTO> userOrderProducts;
}
