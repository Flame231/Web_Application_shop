package service;

import com.mysql.cj.log.Log;
import org.example.dao.user.UserDAO;
import org.example.dto.dto.LoginDTO;
import org.example.dto.dto.UserDTO;
import org.example.model.user.Role;
import org.example.model.user.User;
import org.example.service.exceptions.UserAlreadyExists;
import org.example.service.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.PersistenceException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {


    @Mock
    private UserDAO userDAOmock;

    @InjectMocks
    UserServiceImpl userService;

    private UserDTO userDTO;

    @BeforeEach
    void setUp() {
        userDTO = UserDTO.builder()
                .name("user")
                .login("user")
                .newPassword("pass123")
                .newPasswordRepeat("pass123")
                .birthday(LocalDate.of(1990, 1, 1))
                .build();
    }

    @Test
    void shouldRegisterUser() {
        userService.registerUser(userDTO);
        verify(userDAOmock, times(1)).save(any(User.class));
    }

    @Test
    void shouldNotRegisterExistingUser() {
        User user = User.builder()
                .name("Иван")
                .login("ivan123")
                .passwordHash("$2a$12$Tjd1.D8tpqQ0Y5vKqjY6ZuGZbP.93UTyFYg38A8UHiUI5KrDBbBc2")
                .birthday(LocalDate.of(1997, 7, 21))
                .paymentMethods("123")
                .role(Role.CLIENT)
                .build();
        doThrow(new PersistenceException()).when(userDAOmock).save(any(User.class));

        assertThrows(UserAlreadyExists.class, () -> {
            userService.registerUser(userDTO);
        });
    }

    @Test
    void shouldAuthorizeUser() {

        User user = User.builder()
                .name("user")
                .login("user")
                .passwordHash("$2a$12$FtqmQGj3R6.3G3D1CS2asu21/CVOva7PXYWBKSv0/U9JRUntecra2")
                .birthday(LocalDate.of(1997, 7, 21))
                .paymentMethods("123")
                .role(Role.CLIENT)
                .build();

        LoginDTO loginDTO = LoginDTO.builder().login("user").password("user").build();
        doReturn(user)
                .when(userDAOmock).findUser(loginDTO.getLogin());
        UserDTO userDTOGenerated = userService.authorizeUser(loginDTO);
        assertEquals(userDTO.getLogin(),userDTOGenerated.getLogin());

    }
}
