package org.example.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BagDTO {
    private Integer userId;
    private Integer product_id;
    private Integer count;

    @Override
    public String toString() {
        return "BagDTO{" +
                "userId=" + userId +
                ", product_id=" + product_id +
                ", count=" + count +
                '}';
    }
}
