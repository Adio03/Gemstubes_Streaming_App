package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.data.models.User;
import africa.semicolon.gemstube.dtos.requests.RegisterRequest;
import africa.semicolon.gemstube.dtos.responses.RegisterResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    User getUserById(Long id) throws GemsTubeException;

}
