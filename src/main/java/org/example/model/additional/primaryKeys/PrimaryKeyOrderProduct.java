package org.example.model.additional.primaryKeys;

import lombok.Data;

import java.io.Serializable;
@Data
public class PrimaryKeyOrderProduct implements Serializable {

    private Integer userOrder;

    private Integer product;
}
