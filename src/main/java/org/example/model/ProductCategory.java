package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductCategory extends DataEntity {

    @OneToMany(mappedBy = "productCategory")
    private Set<Product> products = new HashSet<>();

    @Column
    private String category;
}
