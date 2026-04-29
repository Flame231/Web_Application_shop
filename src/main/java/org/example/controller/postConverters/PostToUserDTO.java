package org.example.controller.postConverters;

import org.example.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

import static org.example.util.NamesUtil.*;

public class PostToUserDTO {
    public static UserDTO toUserDTO(HttpServletRequest request) {
        PostConverter postConverter = new PostConverter(request);
        Integer userId = null;

        if (request.getParameter(USER_ID_PARAMETER) != null) {
            userId = postConverter.convert(USER_ID_PARAMETER, Integer.class);
        }

        String name = postConverter.convert(LOGIN_PARAMETER, String.class);
        String login = postConverter.convert(LOGIN_PARAMETER, String.class);
        String oldPassword = postConverter.convert(OLD_PASSWORD_PARAMETER, String.class);
        String newPassword = postConverter.convert(NEW_PASSWORD_PARAMETER, String.class);
        String newPasswordRepeat = postConverter.convert(NEW_PASSWORD_REPEAT_PARAMETER, String.class);
        LocalDate birthday = postConverter.convert(BIRTHDAY_PARAMETER, LocalDate.class);
        String paymentMethods = postConverter.convert(PAYMENT_METHODS_PARAMETER, String.class);
        return UserDTO.builder().id(userId)
                .name(name).login(login)
                .oldPassword(oldPassword)
                .newPassword(newPassword)
                .newPasswordRepeat(newPasswordRepeat)
                .birthday(birthday)
                .paymentMethods(paymentMethods).sumOfPurchases(null)
                .userOrders(null)
                .discount(null).build();
    }
}
