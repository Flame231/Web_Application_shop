package org.example.dto.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Getter
public class ProductDTO {

    private Integer id;

    private String productName;

    private ProductCategoryDTO productCategory;

    private BigDecimal price;

    private SellerDTO seller;

    private Timestamp updateDateTime;

    @Override
    public String toString() {
        return "NewProductDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCategory=" + productCategory +
                ", price=" + price +
                ", seller=" + seller +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
