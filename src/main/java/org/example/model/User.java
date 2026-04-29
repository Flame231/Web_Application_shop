package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User extends DataEntity {

    @Column
    private String name;

    @Column(unique = true, nullable = false)
    private String login;

    @Column
    private String password;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthday;

    @Column
    private String paymentMethods;

    @Column
    private BigDecimal sumOfPurchases;

    @OneToMany(mappedBy = "user")
    private Set<UserOrder> userOrders;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @OneToMany(mappedBy = "user")
    private Set<Bag> bags = new HashSet<>();

}
