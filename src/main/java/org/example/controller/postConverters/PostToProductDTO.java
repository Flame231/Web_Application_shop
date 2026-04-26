package org.example.controller.postConverters;

import org.example.dto.ProductDTO;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public class PostToProductDTO {

    public static ProductDTO toProductDTO(HttpServletRequest request) {


        String productName = request.getParameter("productName");
        Integer productCategoryId = Integer.parseInt(request.getParameter("productCategory"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        Integer sellerId = Integer.parseInt(request.getParameter("seller"));

        ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();

        if (request.getParameter("productId") != null) {
            Integer productId = Integer.parseInt(request.getParameter("productId"));
            return ProductDTO.builder().id(productId)
                    .productName(productName)
                    .productCategory(productCategoryService.findProductCategory(productCategoryId))
                    .price(price).seller(sellerService.findSeller(sellerId))
                    .build();
        }
        return  ProductDTO.builder()
                .productName(productName)
                .productCategory(productCategoryService.findProductCategory(productCategoryId))
                .price(price).seller(sellerService.findSeller(sellerId))
                .build();
    }
}
