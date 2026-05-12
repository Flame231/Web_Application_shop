package org.example.service.product;

import org.example.dto.dto.ProductDTO;

import java.util.List;

public record ProductPagesDivide(List<ProductDTO> productDTOList, Integer productCountResult, Integer currentPage) {
}
