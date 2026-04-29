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
        if(passwordValidation(userDTO)){
            userDAO.save(UserConverter.toUserEntity(userDTO));
        }
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
        if(passwordValidation(userDTO)) {
            User user = UserConverter.userProfileToEntity(userDTO);
            userDAO.update(user);
        }
    }

    @Override
    public boolean passwordValidation(UserDTO userDTO) {
        if (userDTO.getId()!=null) {
            User user = userDAO.get(userDTO.getId());
            if (user.getPassword().equals(userDTO.getOldPassword())) {
                if (userDTO.getNewPassword().equals(userDTO.getNewPasswordRepeat())) {
                    return true;
                }
            }
        }
        else return userDTO.getNewPassword().equals(userDTO.getNewPasswordRepeat());
        return false;
    }

    @Override
    public User getUser(Serializable id){
        return userDAO.get(id);
    }
}
