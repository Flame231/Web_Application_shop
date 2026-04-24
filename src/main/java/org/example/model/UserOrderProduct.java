package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.primaryKeys.PrimaryKeyOrderProduct;

@Entity
@Table(name = "userOrder_product")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@IdClass(PrimaryKeyOrderProduct.class)
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
}
