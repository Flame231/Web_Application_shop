package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;
import org.example.model.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderPoint extends DataEntity {

    @Column
    private String orderPointAddress;

    @Column
    private Time openingTime;

    @Column
    private Time closeTime;

    @OneToMany(mappedBy = "orderPoint")
    private Set<UserOrder> userOrder = new HashSet<>();

    @OneToMany(mappedBy = "orderPoint")
    private Set<User> users;
}
