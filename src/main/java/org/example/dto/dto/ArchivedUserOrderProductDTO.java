package org.example.dto.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.model.ArchivedUserOrder;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Builder
public class ArchivedUserOrderProductDTO {

    private ArchivedUserOrder archivedUserOrder;

    private Integer productId;

    private String productName;

    private Integer productCount;

    private Integer finalProductCount;

    private BigDecimal price;

    private Timestamp createDateTime;

}
