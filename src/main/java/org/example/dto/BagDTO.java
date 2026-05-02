package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.example.model.Product;
import org.example.model.user.User;

@ToString
@Builder
@Getter
public class BagDTO {


    private User user;

    private Product product;

    private Integer count;
}