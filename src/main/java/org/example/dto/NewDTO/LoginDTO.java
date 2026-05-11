package org.example.dto.NewDTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginDTO {

    private String login;

    private String password;
}
