package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProductCategory extends DataEntity {

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.REMOVE)
    private Set<Product> products = new HashSet<>();

    @Column
    private String category;

    @Override
    public String toString() {
        return "ProductCategory{" +
                ", category='" + category + '\'' +
                '}';
    }
}
