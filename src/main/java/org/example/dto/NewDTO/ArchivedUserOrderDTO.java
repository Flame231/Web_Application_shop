package org.example.dto.NewDTO;

import lombok.Builder;
import lombok.Getter;
import org.example.model.UserOrder.OrderStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Builder
@Getter
public class ArchivedUserOrderDTO {

    private Integer UserOrderId;

    private OrderStatus orderStatus;

    private Integer userId;

    private String OrderPoint;

    private BigDecimal orderSum;

    private BigDecimal finalOrderSum;

    private Timestamp userOrderCreateDateTime;

    private Timestamp createDateTime;

    private Set<ArchivedUserOrderProductDTO> archivedUserOrderProducts;

}
