package org.example.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ProductBagDTO {
    public ProductBagDTO(Integer productId, String productName, String category, BigDecimal price, String sellerName, Integer count) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.sellerName = sellerName;
        this.count = count;
    }

    private Integer productId;
    private String productName;
    private String category;
    private BigDecimal price;
    private String sellerName;
    private Integer count;

    @Override
    public String toString() {
        return "ProductBagDTO{" +
                "productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", sellerName='" + sellerName + '\'' +
                ", count=" + count +
                '}';
    }
}
