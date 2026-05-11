package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.UserOrder.OrderStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ArchivedUserOrder {

    @Id
    private Integer userOrderId;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private OrderStatus orderStatus;

    @Column(updatable = false)
    private Integer userId;

    @Column(updatable = false)
    private String OrderPoint;

    @Column(updatable = false)
    private BigDecimal orderSum;

    @Column(updatable = false)
    private BigDecimal finalOrderSum;

    @Column(updatable = false, nullable = false)
    private Timestamp userOrderCreateDateTime;

    @OneToMany(mappedBy = "archivedUserOrder", cascade = CascadeType.PERSIST)
    private Set<ArchivedUserOrderProduct> archivedUserOrderProducts = new HashSet<>();

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp CreateDateTime;
}
