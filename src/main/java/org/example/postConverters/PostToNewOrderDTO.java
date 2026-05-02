package org.example.postConverters;

import org.example.dto.NewOrderDTO;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostToNewOrderDTO {

    public static List<NewOrderDTO> toNewOrderDTO(HttpServletRequest request) {
        Integer userId = (Integer) (request.getSession().getAttribute("userId"));
        Integer orderPointId = Integer.parseInt(request.getParameter("orderPointId"));
        String[] productId = request.getParameterValues("productId");
        String[] count = request.getParameterValues("count");
        String[] productPrice = request.getParameterValues("productPrice");

        List<Integer> productIdList = Arrays.stream(productId)
                .map(Integer::parseInt).toList();
        List<Integer> countList = Arrays.stream(count)
                .map(Integer::parseInt).toList();
        List<BigDecimal> productPriceList = Arrays.stream(productPrice)
                .map(BigDecimal::new).toList();

        List<NewOrderDTO> list = new ArrayList<>();

        for (int i = 0; i < productIdList.size(); i++) {
            NewOrderDTO newOrderDTO = NewOrderDTO.builder()
                    .userId(userId).orderPointId(orderPointId)
                    .productId(productIdList.get(i)).Count(countList.get(i))
                    .productPrice(productPriceList.get(i))
                    .build();
            list.add(newOrderDTO);
        }
        return list;
    }
}
