package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
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
public class Seller extends DataEntity {

    @Column
    private String sellerName;

    @Column
    private String sellerAddress;

    @OneToMany(mappedBy = "seller")
    private Set<Product> product = new HashSet<>();
}
