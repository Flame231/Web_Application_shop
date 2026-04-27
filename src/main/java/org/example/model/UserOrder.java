package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserOrder extends DataEntity {

    @Column
    private String orderStatus = "Оформлен";

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "orderPoint_id")
    private OrderPoint orderPoint;

    @OneToMany(mappedBy = "userOrder")
    private Set<UserOrderProduct> userOrderProduct = new HashSet<>();
}
