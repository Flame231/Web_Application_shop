package org.example.model.additional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@Getter
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Timestamp createDateTime;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updateDateTime;
}
