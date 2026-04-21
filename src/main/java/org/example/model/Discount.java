package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Discount extends DataEntity {

    @Column
    private Integer discount;

    @Column
    private BigDecimal totalSum;

    @OneToMany(mappedBy = "discount")
    private Set<User> users = new HashSet<>();
}
