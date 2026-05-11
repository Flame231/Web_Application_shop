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
public class PrimaryKeyArchivedUserOrderProduct implements Serializable {

    private Integer archivedUserOrder;

    private Integer productId;
}
