package org.example.service.user;

import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.dto.LoginDTO;
import org.example.dto.ConverterDTO.ConverterDTO;
import org.example.dto.ConverterDTO.UserDTOConverter;
import org.example.dto.dto.UserDTO;
import org.example.model.user.User;
import org.example.service.BcryptUtil;
import org.example.service.exceptions.*;

import javax.persistence.PersistenceException;
import java.io.Serializable;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();
    private ConverterDTO<User, UserDTO> converterDTO = new UserDTOConverter();


    @Override
    public void registerUser(UserDTO userDTO) {
        passwordValidation(userDTO);
        try {
            userDAO.save(converterDTO.toEntity(userDTO));
        } catch (PersistenceException e) {
            throw new UserAlreadyExists("Пользователь с таким именем уже зарегистрирован!", e);
        }
    }

    @Override
    public UserDTO authorizeUser(LoginDTO loginDTO) {
        User user = null;
        user = userDAO.findUser(loginDTO.getLogin());
        if (user == null || !BcryptUtil.checkPassword(loginDTO.getPassword(), user.getPasswordHash())) {
            throw new WrongLoginOrPassword("Неверный логин или пароль!");
        }
        return converterDTO.toDTO(user);
    }

    public UserDTO getUserDTO(Serializable id) {
        return converterDTO.toDTO(userDAO.get(id));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        passwordValidation(userDTO);
            userDAO.begin();
            User user = userDAO.get(userDTO.getId());
            user.setName(userDTO.getName());
            user.setLogin(userDTO.getLogin());
            user.setPasswordHash(BcryptUtil.hashPassword(userDTO.getNewPassword()));
            user.setBirthday(userDTO.getBirthday());
            user.setPaymentMethods(userDTO.getPaymentMethods());
            userDAO.commit();

    }

    @Override
    public void passwordValidation(UserDTO userDTO) {
        if (userDTO.getId() != null) {
            User user = userDAO.get(userDTO.getId());
            if (BcryptUtil.checkPassword(userDTO.getOldPassword(), user.getPasswordHash())) {
                if (!userDTO.getNewPassword().equals(userDTO.getNewPasswordRepeat())) {
                    throw new DifferentPasswordsUpdate("Введенные пароли не совпадают!");
                }
            } else {
                throw new WrongPassword("Неверный пароль!");
            }
        } else {
            if (!userDTO.getNewPassword().equals(userDTO.getNewPasswordRepeat())) {
                throw new DifferentPasswordsRegistration("Введенные пароли не совпадают!");
            }
        }
    }

    @Override
    public User getUser(Serializable id) {
        return userDAO.get(id);
    }
}
