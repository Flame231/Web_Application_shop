package org.example.postConverters;

import org.example.dto.LoginDTO;

import javax.servlet.http.HttpServletRequest;

import static org.example.util.NamesUtil.LOGIN_PARAMETER;
import static org.example.util.NamesUtil.PASSWORD_PARAMETER;

public class PostToLoginDTO {

    public static LoginDTO toLoginDTO(HttpServletRequest request) {
        ConverterPost tConverterPost = new ConverterPost(request);
        String login = tConverterPost.convertParameter(LOGIN_PARAMETER, String.class);
        String password = tConverterPost.convertParameter(PASSWORD_PARAMETER, String.class);
        return LoginDTO.builder().login(login).password(password).build();
    }
}
