package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.data.models.User;
import africa.semicolon.gemstube.dtos.requests.RegisterRequest;
import africa.semicolon.gemstube.dtos.responses.RegisterResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    private RegisterRequest registerRequest;
    private RegisterResponse response;
    @BeforeEach
    void setUp(){
        registerRequest = new RegisterRequest();
        response = new RegisterResponse();
        registerRequest.setEmail("nati@gmail.com");
        registerRequest.setPassword("nati1234");
        response = userService.register(registerRequest);


    }
    @Test
    public void registerTest(){
         assertNotNull(response);
         assertNotNull(response.getId());
    }

    @Test
    public void testGetUserById() throws GemsTubeException {
        userService.register(registerRequest);
        User user = userService.getUserById(response.getId());
        assertThat(user).isNotNull();
    }
}
