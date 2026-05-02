package org.example.postConverters;

import org.example.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

import static org.example.util.NamesUtil.*;

public class PostToUserDTO {
    public static UserDTO toUserDTO(HttpServletRequest request) {
        ConverterPost converterPost = new ConverterPost(request);
        Integer userId = null;

        if (request.getParameter(USER_ID_PARAMETER) != null) {
            userId = converterPost.convertParameter(USER_ID_PARAMETER, Integer.class);
        }

        String name = converterPost.convertParameter(LOGIN_PARAMETER, String.class);
        String login = converterPost.convertParameter(LOGIN_PARAMETER, String.class);
        String oldPassword = converterPost.convertParameter(OLD_PASSWORD_PARAMETER, String.class);
        String newPassword = converterPost.convertParameter(NEW_PASSWORD_PARAMETER, String.class);
        String newPasswordRepeat = converterPost.convertParameter(NEW_PASSWORD_REPEAT_PARAMETER, String.class);
        LocalDate birthday = converterPost.convertParameter(BIRTHDAY_PARAMETER, LocalDate.class);
        String paymentMethods = converterPost.convertParameter(PAYMENT_METHODS_PARAMETER, String.class);
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
