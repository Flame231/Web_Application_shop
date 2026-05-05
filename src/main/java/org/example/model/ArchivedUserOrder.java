package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.model.additional.DataEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "archivedUserOrder")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ArchivedUserOrder extends DataEntity {

    @Column(updatable = false, nullable = false)
    private Integer userId;

    @Column(updatable = false, nullable = false)
    private Integer userOrderId;

    @Column(updatable = false, nullable = false)
    private Integer productId;

    @Column(updatable = false, nullable = false)
    private Integer productCount;

    @Column(updatable = false, nullable = false)
    private Integer actualProductCount;

    @Column(updatable = false, nullable = false)
    private BigDecimal productPrice;

    @Column(updatable = false, nullable = false)
    private String orderStatus;

    @Column(updatable = false, nullable = false)
    private BigDecimal orderSum;

    @Column(updatable = false, nullable = false)
    private BigDecimal finalOrderSum;

    @Column(updatable = false, nullable = false)
    private Timestamp userOrderCreateDateTime;

    @Column(updatable = false, nullable = false)
    private Timestamp userOrderCloseDateTime;
}
