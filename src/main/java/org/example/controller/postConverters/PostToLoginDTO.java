package org.example.controller.postConverters;

import org.example.dto.LoginDTO;

import javax.servlet.http.HttpServletRequest;

import static org.example.util.NamesUtil.LOGIN_PARAMETER;
import static org.example.util.NamesUtil.PASSWORD_PARAMETER;

public class PostToLoginDTO {

    public static LoginDTO toLoginDTO(HttpServletRequest request) {
        PostConverter tPostConverter = new PostConverter(request);
        String login = tPostConverter.convert(LOGIN_PARAMETER, String.class);
        String password = tPostConverter.convert(PASSWORD_PARAMETER, String.class);
        return LoginDTO.builder().login(login).password(password).build();
    }
}
