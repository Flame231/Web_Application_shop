package org.example.controller.postConverters;

import org.example.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class PostToUserDTO {
    public static UserDTO toUserDTO(HttpServletRequest request) {
        Integer id = null;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String newPasswordRepeat = request.getParameter("newPasswordRepeat");
        String birthday = request.getParameter("birthday");
        String paymentMethods = request.getParameter("paymentMethods");
        return UserDTO.builder().id(id)
                .name(name).login(login)
                .oldPassword(oldPassword)
                .newPassword(newPassword)
                .newPasswordRepeat(newPasswordRepeat)
                .birthday(LocalDate.parse(birthday))
                .paymentMethods(paymentMethods).sumOfPurchases(null)
                .userOrders(null)
                .discount(null).build();
    }
}
