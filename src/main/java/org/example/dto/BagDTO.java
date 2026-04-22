package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class BagDTO {
    private Integer userId;
    private Integer product_id;
    private Integer count;
}