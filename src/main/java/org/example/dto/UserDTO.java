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

    private String password;

    private LocalDate birthday;

    private String paymentMethods;

    private BigDecimal sumOfPurchases;

    private Set<UserOrder> userOrders;

    private Discount discount;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", paymentMethods='" + paymentMethods + '\'' +
                ", discount=" + discount +
                ", sumOfPurchases=" + sumOfPurchases +
                ", birthday=" + birthday +
                '}';
    }
}
