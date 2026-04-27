package org.example.controller.postConverters;

import org.example.dto.NewOrderDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PostToNewOrderDTO {

    public static List<NewOrderDTO> toNewOrderDTO(HttpServletRequest request) {
        Integer userId = (Integer) (request.getSession().getAttribute("userId"));
        String[] orderPointId = request.getParameterValues("orderPointId");
        String[] productId = request.getParameterValues("productId");
        String[] count = request.getParameterValues("count");
        System.out.println(orderPointId.length + "длина массива");
        System.out.println(productId.length + "длина массива");
        System.out.println(count.length + "длина массива");

        List<Integer> orderPointIdList = Arrays.stream(orderPointId)
                .map(Integer::parseInt).toList();
        List<Integer> productIdList = Arrays.stream(productId)
                .map(Integer::parseInt).toList();
        List<Integer> countList = Arrays.stream(count)
                .map(Integer::parseInt).toList();

        List<NewOrderDTO> list = new ArrayList<>();

        for (int i = 0; i < orderPointIdList.size(); i++) {
            NewOrderDTO newOrderDTO = NewOrderDTO.builder()
                    .userId(userId).orderPointId(orderPointIdList.get(i))
                    .productId(productIdList.get(i)).Count(countList.get(i))
                    .build();
            list.add(newOrderDTO);
        }
        return list;
    }
}
