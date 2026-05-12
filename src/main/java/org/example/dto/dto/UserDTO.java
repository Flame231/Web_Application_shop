package org.example.dto.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Discount;
import org.example.model.user.Role;

import java.math.BigDecimal;
import java.time.LocalDate;

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

    private Discount discount;

    private Role role;

}
