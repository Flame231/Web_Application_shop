package org.example.model.additional;

import lombok.Data;

import java.io.Serializable;
@Data
public class PrimaryKeyOrderProduct implements Serializable {

    private Integer userOrder;

    private Integer product;
}
