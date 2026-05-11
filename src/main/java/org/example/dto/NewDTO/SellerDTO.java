package org.example.dto.NewDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SellerDTO {

    private Integer id;

    private String sellerName;

    private String sellerAddress;
}
