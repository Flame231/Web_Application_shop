package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.model.ProductCategory;
import org.example.model.Seller;

import java.math.BigDecimal;
@Builder
@Getter
public class ProductDTO{

    private Integer id;

    private String productName;

    private ProductCategory productCategory;

    private BigDecimal price;

    private Seller seller;

    private Integer count;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productCategory=" + productCategory +
                ", price=" + price +
                ", seller=" + seller +
                ", count=" + count +
                '}';
    }
}
