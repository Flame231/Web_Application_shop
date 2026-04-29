package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.primaryKeys.PrimaryKeyBag;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@SuperBuilder
@Table
@NoArgsConstructor
@Setter
@Getter
@IdClass(PrimaryKeyBag.class)
public class Bag {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer count;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp createDateTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updateDateTime;

    @Override
    public String toString() {
        return "Bag{" +
                "user=" + user +
                ", product=" + product +
                ", count=" + count +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
