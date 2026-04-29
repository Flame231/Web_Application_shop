package org.example.service.user;

import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.model.User;

import java.io.Serializable;

public interface UserService {

    void registerUser(UserDTO userDTO);

    UserDTO authorizeUser(LoginDTO loginDTO);

    UserDTO getUserData(Serializable id);

    void updateUseProfile(UserDTO userDTO);

    public boolean passwordValidation(UserDTO userDTO);

    public User getUser(Serializable id);
}
