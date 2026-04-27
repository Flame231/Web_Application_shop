package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.model.UserOrder;
import org.example.model.additional.DataEntity;

import java.sql.Time;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrderPointDTO {

    private Integer id;

    private String orderPointAddress;

    private Time openingTime;

    private Time closeTime;

    private UserOrder userOrder;
}
