package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.OrderPoint;
import org.example.model.UserOrderProduct;
import org.example.model.user.User;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserOrderDTO {

    private Integer id;

    private String orderStatus;

    private User user;

    private OrderPoint orderPoint;

    private Set<UserOrderProduct> userOrderProduct = new HashSet<>();

    private BigDecimal orderSum;

    private Timestamp createDateTime;
}
