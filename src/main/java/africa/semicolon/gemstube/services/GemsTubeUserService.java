package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.data.models.User;
import africa.semicolon.gemstube.data.repositries.UserRepository;
import africa.semicolon.gemstube.dtos.requests.RegisterRequest;
import africa.semicolon.gemstube.dtos.responses.RegisterResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GemsTubeUserService implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        User saveduser = userRepository.save(user);
        return new RegisterResponse(saveduser.getId());
    }

    @Override
    public User getUserById(Long id) throws GemsTubeException {

        return userRepository.findById(id).orElseThrow(
                () -> new GemsTubeException(String.format("user with id %d not found",id))
        );
    }


}
