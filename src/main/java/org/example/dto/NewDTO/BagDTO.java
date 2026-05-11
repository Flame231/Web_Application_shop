package org.example.dto.NewDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class BagDTO {

    private Integer userId;

    private NewProductDTO product;

    private Integer count;
}