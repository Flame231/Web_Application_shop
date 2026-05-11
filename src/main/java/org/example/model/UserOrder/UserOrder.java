package org.example.model.UserOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.OrderPoint;
import org.example.model.additional.DataEntity;
import org.example.model.user.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
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
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "orderPoint_id")
    private OrderPoint orderPoint;

    @OneToMany(mappedBy = "userOrder", cascade = CascadeType.REMOVE)
    @OrderBy("userOrder desc")
    private Set<UserOrderProduct> userOrderProduct = new LinkedHashSet<>();

    private BigDecimal orderSum;
}
