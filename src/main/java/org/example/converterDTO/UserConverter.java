package org.example.converterDTO;

import jakarta.transaction.UserTransaction;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.UserDTO;
import org.example.model.User;

import java.time.LocalDate;
import java.util.Date;

public class UserConverter {
    public static UserDTO toUserDTO(User user) {
        if (user != null) {
            return UserDTO.builder().id(user.getId())
                    .name(user.getName())
                    .login(user.getLogin())
                    .password(user.getPassword())
                    .birthday(user.getBirthday())
                    .paymentMethods(user.getPaymentMethods())
                    .sumOfPurchases(user.getSumOfPurchases())
                    .userOrders(user.getUserOrders())
                    .discount(user.getDiscount()).build();
        } else {
            return null;
        }
    }

    public static User toUserEntity(UserDTO userDTO) {
        return User.builder().name(userDTO.getName())
                .login((userDTO.getLogin()))
                .password((userDTO.getPassword()))
                .birthday((userDTO.getBirthday()))
                .paymentMethods((userDTO.getPaymentMethods()))
                .sumOfPurchases((userDTO.getSumOfPurchases()))
                .userOrders((userDTO.getUserOrders()))
                .discount((userDTO.getDiscount())).build();
    }

    public static User userProfileToEntity(UserDTO userDTO) {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.get(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setBirthday(LocalDate.parse(userDTO.getBirthday().toString()));
        user.setPaymentMethods(userDTO.getPaymentMethods());
        return user;
    }


}
