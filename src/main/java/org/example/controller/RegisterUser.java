package org.example.controller;

import org.example.controller.postConverters.PostToUserDTO;
import org.example.dto.UserDTO;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.ACCOUNT_JSP_RELATIVE_PATH;

public class RegisterUser extends HttpServlet {
    UserService userService = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDTO userDTO = PostToUserDTO.toUserDTO(request);
        if (userDTO.getId() == null) {
            userService.registerUser(userDTO);
        } else {
            userService.updateUseProfile(userDTO);
        }
        response.sendRedirect(ACCOUNT_JSP_RELATIVE_PATH);
    }
}
