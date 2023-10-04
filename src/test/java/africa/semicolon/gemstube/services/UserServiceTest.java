package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.RegisterRequest;
import africa.semicolon.gemstube.dtos.responses.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void registerTest(){
        RegisterRequest request = new RegisterRequest();
        request.setEmail("nati@gmail.com");
        request.setPassword("nati1234");

                RegisterResponse response = userService.register(request);

         assertNotNull(response);

         assertNotNull(response.getId());
    }
}
