package org.example.service.user;

import org.example.converterDTO.UserConverter;
import org.example.dao.user.UserDAO;
import org.example.dao.user.UserDAOImpl;
import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.model.User;

import java.io.Serializable;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void registerUser(UserDTO userDTO) {
        userDAO.save(UserConverter.toUserEntity(userDTO));
    }

    @Override
    public UserDTO authorizeUser(LoginDTO loginDTO) {
        return UserConverter.toUserDTO(userDAO
                .findUser(loginDTO.getLogin(), loginDTO.getPassword()));
    }

    public UserDTO getUserData(Serializable id) {
        return UserConverter.toUserDTO(userDAO.get(id));
    }

    @Override
    public void updateUseProfile(UserDTO userDTO) {
        User user = UserConverter.userProfileToEntity(userDTO);
        userDAO.update(user);
    }
}
