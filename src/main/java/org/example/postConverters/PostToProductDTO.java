package org.example.postConverters;

import org.example.dao.productCategory.ProductCategoryDAO;
import org.example.dao.productCategory.ProductCategoryDAOImpl;
import org.example.dao.seller.SellerDAO;
import org.example.dao.seller.SellerDAOImpl;
import org.example.dto.NewDTO.NewConverterDTO.ConverterDTO;
import org.example.dto.NewDTO.NewConverterDTO.ProductCategoryDTOConverter;
import org.example.dto.NewDTO.NewConverterDTO.SellerDTOConverter;
import org.example.dto.NewDTO.NewProductDTO;
import org.example.dto.NewDTO.ProductCategoryDTO;
import org.example.dto.NewDTO.SellerDTO;
import org.example.model.ProductCategory;
import org.example.model.Seller;
import org.example.service.productCategory.ProductCategoryService;
import org.example.service.productCategory.ProductCategoryServiceImpl;
import org.example.service.seller.SellerServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static org.example.util.NamesUtil.*;

public class PostToProductDTO {

    public static NewProductDTO toProductDTO(HttpServletRequest request) {
        ConverterPost converterPost = new ConverterPost(request);
        ConverterDTO<ProductCategory, ProductCategoryDTO> converterDTO = new ProductCategoryDTOConverter();
        ConverterDTO<Seller, SellerDTO> converterDTO1 = new SellerDTOConverter();

        String productName = converterPost.convertParameter(PRODUCT_NAME_PARAMETER, String.class);
        Integer productCategoryId = converterPost.convertParameter(PRODUCT_CATEGORY_ID_PARAMETER, Integer.class);
        BigDecimal price = converterPost.convertParameter(PRICE_PARAMETER, BigDecimal.class);
        Integer sellerId = converterPost.convertParameter(SELLER_PARAMETER, Integer.class);

        ProductCategoryService productCategoryService = new ProductCategoryServiceImpl();
        SellerServiceImpl sellerService = new SellerServiceImpl();

        ProductCategoryDAO productCategoryDAO = new ProductCategoryDAOImpl();
        SellerDAO sellerDAO = new SellerDAOImpl();

        if (request.getParameter(PRODUCT_ID_PARAMETER) != null) {
            Integer productId = converterPost.convertParameter(PRODUCT_ID_PARAMETER, Integer.class);
            return NewProductDTO.builder().id(productId)
                    .productName(productName)
                    .productCategory(converterDTO.toDTO(productCategoryDAO.get(productCategoryId)))
                    .price(price).seller(converterDTO1.toDTO(sellerDAO.get(sellerId)))
                    .build();
        }
        return NewProductDTO.builder()
                .productName(productName)
                .productCategory(converterDTO.toDTO(productCategoryDAO.get(productCategoryId)))
                .price(price)
                .seller(converterDTO1.toDTO(sellerDAO.get(sellerId)))
                .build();
    }
}
