package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;
import org.example.model.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "orderPoint_id")
    private OrderPoint orderPoint;

    @OneToMany(mappedBy = "userOrder")
    private Set<UserOrderProduct> userOrderProduct = new HashSet<>();

    private BigDecimal orderSum;
}
