package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.RegisterRequest;
import africa.semicolon.gemstube.dtos.responses.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
}
