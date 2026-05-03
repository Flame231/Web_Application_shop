package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.primaryKeys.PrimaryKeyUserOrderProduct;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "userOrder_product")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@IdClass(PrimaryKeyUserOrderProduct.class)
public class UserOrderProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "userOrder_id")
    private UserOrder userOrder;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer productCount;

    @Column
    private BigDecimal productPrice;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp createDateTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updateDateTime;
}
