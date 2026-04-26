package org.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.model.Product;
import org.example.model.additional.DataEntity;

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
