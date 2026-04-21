package org.example.controller.postConverters;

import org.example.dto.LoginDTO;

import javax.servlet.http.HttpServletRequest;

public class PostToLoginDTO {
    public static LoginDTO toLoginDTO(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        return LoginDTO.builder().login(login).password(password).build();
    }
}
