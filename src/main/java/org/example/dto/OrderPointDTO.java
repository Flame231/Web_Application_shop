package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.UserOrder;

import java.sql.Time;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderPointDTO {

    private Integer id;

    private String orderPointAddress;

    private Time openingTime;

    private Time closeTime;

    private Set<UserOrder> userOrder;
}
