package org.example.model.additional;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrimaryKeyBag implements Serializable {

    private Integer user;

    private Integer product;
}
