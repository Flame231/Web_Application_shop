package org.example.converterDTO;

import org.example.dto.UserDTO;
import org.example.model.user.User;

public class UserConverter implements ConverterDTO<User, UserDTO> {
    @Override
    public UserDTO toDTO(User user) {
        if (user != null) {
            return UserDTO.builder().id(user.getId())
                    .name(user.getName())
                    .login(user.getLogin())
                    .birthday(user.getBirthday())
                    .paymentMethods(user.getPaymentMethods())
                    .sumOfPurchases(user.getSumOfPurchases())
                    .userOrders(user.getUserOrders())
                    .discount(user.getDiscount())
                    .bags(user.getBags())
                    .role(user.getRole())
                    .build();
        } else {
            return null;
        }
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return User.builder().name(userDTO.getName())
                .id(userDTO.getId())
                .login((userDTO.getLogin()))
                .password((userDTO.getNewPassword()))
                .birthday((userDTO.getBirthday()))
                .paymentMethods((userDTO.getPaymentMethods()))
                .sumOfPurchases((userDTO.getSumOfPurchases()))
                .userOrders((userDTO.getUserOrders()))
                .discount((userDTO.getDiscount())).build();
    }

 /*   public static User userProfileToEntity(UserDTO userDTO) {
        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.get(userDTO.getId());
        user.setName(userDTO.getName());
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getNewPassword());
        user.setBirthday(LocalDate.parse(userDTO.getBirthday().toString()));
        user.setPaymentMethods(userDTO.getPaymentMethods());
        return user;
    }*/


}
