package org.example.controller.postConverters;

import org.example.dto.NewOrderDTO;

import javax.servlet.http.HttpServletRequest;

public class PostToNewOrderDTO {

    public static NewOrderDTO toNewOrderDTO(HttpServletRequest request) {
        Integer userId = (Integer) (request.getSession().getAttribute("userId"));
       /* Integer userOrderId = Integer.parseInt(request.getParameter("userOrderId"));*/
        Integer orderPointId = Integer.parseInt(request.getParameter("orderPointId"));
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        Integer count = Integer.parseInt(request.getParameter("count"));
        String orderStatus = request.getParameter("orderStatus");

        return NewOrderDTO.builder().userId(userId).orderPointId(orderPointId)
                .productId(productId).Count(count).build();
    }
}
