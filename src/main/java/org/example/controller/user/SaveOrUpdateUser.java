package org.example.controller.user;

import org.example.dto.dto.UserDTO;
import org.example.postConverters.PostToUserDTO;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.MAIN_PAGE_CLIENT;
import static org.example.util.NamesUtil.SAVE_OR_UPDATE_USER;

@WebServlet(SAVE_OR_UPDATE_USER)
public class SaveOrUpdateUser extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserDTO userDTO = PostToUserDTO.toUserDTO(request);
        userService.saveOrUpdateUser(userDTO);
        response.sendRedirect(request.getContextPath() + MAIN_PAGE_CLIENT);
    }
}
