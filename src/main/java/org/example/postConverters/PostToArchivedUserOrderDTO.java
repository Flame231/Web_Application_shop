package org.example.postConverters;

import org.example.dto.ArchivedUserOrderDTO;
import org.example.model.ArchivedUserOrder;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostToArchivedUserOrderDTO {
    public static List<ArchivedUserOrderDTO> toArchivedUserOrderDTO(HttpServletRequest request) {
        ConverterPost converterPost = new ConverterPost(request);
        Integer userOrderId = converterPost.convertParameter("userOrderId", Integer.class);
        String orderStatus = converterPost.convertParameter("orderStatus", String.class);
        BigDecimal orderSum = converterPost.convertParameter("orderSum", BigDecimal.class);
        BigDecimal finalOrderSum = converterPost.convertParameter("finalOrderSum", BigDecimal.class);
        String userOrderCreateDateTime = converterPost.convertParameter("userOrderCreateDateTime", String.class);
        String userOrderUpdateDateTime = converterPost.convertParameter("userOrderUpdateDateTime", String.class);

        List<Integer> productId = converterPost.convertValues("productId", Integer.class);
        List<Integer> productCount = converterPost.convertValues("productCount", Integer.class);
        List<Integer> actualProductCount = converterPost.convertValues("actualProductCount", Integer.class);
        List<BigDecimal> productPrice = converterPost.convertValues("productPrice", BigDecimal.class);
        List<ArchivedUserOrderDTO> list = new ArrayList<>();
        for (int i = 0; i < productId.size(); i++) {
            ArchivedUserOrderDTO archivedUserOrderDTO = ArchivedUserOrderDTO.builder()
                    .userOrderId(userOrderId).productId(productId.get(i))
                    .productCount(productCount.get(i)).actualProductCount(actualProductCount.get(i))
                    .productPrice(productPrice.get(i)).orderStatus(orderStatus)
                    .orderSum(orderSum).finalOrderSum(finalOrderSum)
                    .userOrderCreateDateTime(Timestamp.valueOf(userOrderCreateDateTime))
                    .userOrderCloseDateTime(Timestamp.valueOf(userOrderUpdateDateTime))
                    .build();
            list.add(archivedUserOrderDTO);
        }
        return list;
    }

}
