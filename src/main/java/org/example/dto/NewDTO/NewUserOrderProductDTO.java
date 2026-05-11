package org.example.dto.NewDTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NewUserOrderProductDTO {

    private Integer userOrderId;

    private NewProductDTO newProductDTO;

    private Integer productCount;

    private Integer actualProductCount;
}
