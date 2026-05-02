package org.example.service.user;

import org.example.converterDTO.ConverterDTO;
import org.example.converterDTO.UserConverter;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.model.user.User;

import java.io.Serializable;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();
    private ConverterDTO<User, UserDTO> converterDTO = new UserConverter();


    @Override
    public void registerUser(UserDTO userDTO) {
        if (passwordValidation(userDTO)) {
            userDAO.save(converterDTO.toEntity(userDTO));
        }
    }

    @Override
    public UserDTO authorizeUser(LoginDTO loginDTO) {
        return converterDTO.toDTO(userDAO.findUser(loginDTO.getLogin(), loginDTO.getPassword()));
    }

    public UserDTO getUserDTO(Serializable id) {
        return converterDTO.toDTO(userDAO.get(id));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        if (passwordValidation(userDTO)) {
            userDAO.begin();
            User user = userDAO.get(userDTO.getId());
            user.setName(userDTO.getName());
            user.setLogin(userDTO.getLogin());
            user.setPassword(userDTO.getNewPassword());
            user.setBirthday(userDTO.getBirthday());
            user.setPaymentMethods(userDTO.getPaymentMethods());
            userDAO.commit();

        }
    }

    @Override
    public boolean passwordValidation(UserDTO userDTO) {
        if (userDTO.getId() != null) {
            User user = userDAO.get(userDTO.getId());
            if (user.getPassword().equals(userDTO.getOldPassword())) {
                if (userDTO.getNewPassword().equals(userDTO.getNewPasswordRepeat())) {
                    return true;
                }
            }
        } else return userDTO.getNewPassword().equals(userDTO.getNewPasswordRepeat());
        return false;
    }

    @Override
    public User getUser(Serializable id) {
        return userDAO.get(id);
    }
}
