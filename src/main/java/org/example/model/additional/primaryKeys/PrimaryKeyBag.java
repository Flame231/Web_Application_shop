package org.example.model.additional.primaryKeys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrimaryKeyBag implements Serializable {

    private Integer user;

    private Integer product;
}
