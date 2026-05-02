package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.model.Product;

import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SellerDTO {

    private Integer id;

    private String sellerName;

    private String sellerAddress;

    private Set<Product> product = new HashSet<>();
}
