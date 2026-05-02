package org.example.service.user;

import org.example.dto.LoginDTO;
import org.example.dto.UserDTO;
import org.example.model.user.User;

import java.io.Serializable;

public interface UserService {

    void registerUser(UserDTO userDTO);

    UserDTO authorizeUser(LoginDTO loginDTO);

    UserDTO getUserDTO(Serializable id);

    void updateUser(UserDTO userDTO);

    boolean passwordValidation(UserDTO userDTO);

    User getUser(Serializable id);


}
