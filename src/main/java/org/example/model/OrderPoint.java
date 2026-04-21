package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;

import java.sql.Time;

@Entity
@Table
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class OrderPoint extends DataEntity {

    @Column
    private String orderPointAddress;

    @Column
    private Time openingTime;

    @Column
    private Time closeTime;

    @OneToOne(mappedBy = "orderPoint")
    private UserOrder userOrder;
}
