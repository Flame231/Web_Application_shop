package org.example.service.user;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.ConverterDTO.ValidatorDTO;
import org.example.dto.dto.LoginDTO;
import org.example.dto.ConverterDTO.ConverterDTO;
import org.example.dto.ConverterDTO.UserDTOConverter;
import org.example.dto.dto.UserDTO;
import org.example.model.user.User;
import org.example.service.BcryptUtil;
import org.example.service.exceptions.*;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.io.Serializable;

public class UserServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserService.class);

    private UserDAO userDAO = new UserDAOImpl();
    private ConverterDTO<User, UserDTO> converterDTO = new UserDTOConverter();


    @Override
    public void saveOrUpdateUser(UserDTO userDTO) {
        if (userDTO.getId() == null) {
            try {
                ValidatorDTO.validate(userDTO);
                passwordValidation(userDTO);
                userDAO.save(converterDTO.toEntity(userDTO));
                logger.info("Пользователь {} успешно зарегистрирован!", userDTO.getLogin());
            } catch (PersistenceException e) {
                logger.error("Ошибка регистрации пользователя {}", userDTO.getLogin(), e);
                throw new UserRegistrationException("Ошибка регистрации пользователя: пользователь с таким логином уже зарегистрирован");
            } catch (Exception e) {
                logger.error("Ошибка регистрации пользователя", e);
                throw new UserRegistrationException("Ошибка регистрации пользователя: " + e.getMessage());
            }
        } else updateUser(userDTO);
    }

    @Override
    public UserDTO authorizeUser(LoginDTO loginDTO) {
        User user = null;
        try{
            user = userDAO.findUser(loginDTO.getLogin());
        }catch (NoResultException e){
            logger.info("Ошибка авторизации пользователя: логин не найден", e);
            throw new WrongLoginOrPassword("Неверный логин или пароль!");
        }
        if (!BcryptUtil.checkPassword(loginDTO.getPassword(), user.getPasswordHash())) {
            String userName = user.getName();
            logger.info("Ошибка авторизации пользователя {}: введён неверный логин или пароль", userName);
            throw new WrongLoginOrPassword("Неверный логин или пароль!");
        }
        logger.info("Успешная авторизация пользователя {}", loginDTO.getLogin());
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
