package org.example.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Discount;
import org.example.model.UserOrder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Getter
@Setter
public class UserDTO {

    private Integer id;

    private String name;

    private String login;

    private String oldPassword;

    private String newPassword;

    private String newPasswordRepeat;

    private LocalDate birthday;

    private String paymentMethods;

    private BigDecimal sumOfPurchases;

    private Set<UserOrder> userOrders;

    private Discount discount;

}
