package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.primaryKeys.PrimaryKeyUserOrderProduct;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "userOrder_product")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@IdClass(PrimaryKeyUserOrderProduct.class)
public class UserOrderProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "userOrder_id")
    private UserOrder userOrder;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer productCount;

    @Column
    @CreationTimestamp
    private Timestamp createDateTime;

    @Column
    @UpdateTimestamp
    private Timestamp updateDateTime;
}
