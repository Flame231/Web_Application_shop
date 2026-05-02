package org.example.postConverters;

import org.example.dto.ProductDTO;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static org.example.util.NamesUtil.*;

public class PostToProductDTO {

    public static ProductDTO toProductDTO(HttpServletRequest request) {
        ConverterPost converterPost = new ConverterPost(request);

        String productName = converterPost.convertParameter(PRODUCT_NAME_PARAMETER, String.class);
        Integer productCategoryId = converterPost.convertParameter("productCategoryId", Integer.class);
        BigDecimal price = converterPost.convertParameter(PRICE_PARAMETER, BigDecimal.class);
        Integer sellerId = converterPost.convertParameter(SELLER_PARAMETER, Integer.class);

        ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();

        if (request.getParameter(PRODUCT_ID_PARAMETER) != null) {
            Integer productId = converterPost.convertParameter(PRODUCT_ID_PARAMETER, Integer.class);
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
