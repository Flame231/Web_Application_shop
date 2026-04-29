package org.example.controller.postConverters;

import org.example.dto.ProductDTO;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static org.example.util.NamesUtil.*;

public class PostToProductDTO {

    public static ProductDTO toProductDTO(HttpServletRequest request) {
        PostConverter postConverter = new PostConverter(request);

        String productName = postConverter.convert(PRODUCT_NAME_PARAMETER, String.class);
        Integer productCategoryId = postConverter.convert("productCategoryId", Integer.class);
        BigDecimal price = postConverter.convert(PRICE_PARAMETER, BigDecimal.class);
        Integer sellerId = postConverter.convert(SELLER_PARAMETER, Integer.class);

        ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();

        if (request.getParameter(PRODUCT_ID_PARAMETER) != null) {
            Integer productId = postConverter.convert(PRODUCT_ID_PARAMETER, Integer.class);
            return ProductDTO.builder().id(productId)
                    .productName(productName)
                    .productCategory(productCategoryService.findProductCategory(productCategoryId))
                    .price(price).seller(sellerService.findSeller(sellerId))
                    .build();
        }
        return ProductDTO.builder()
                .productName(productName)
                .productCategory(productCategoryService.findProductCategory(productCategoryId))
                .price(price).seller(sellerService.findSeller(sellerId))
                .build();
    }
}
