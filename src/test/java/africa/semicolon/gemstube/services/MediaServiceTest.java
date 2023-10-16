package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.RegisterRequest;
import africa.semicolon.gemstube.dtos.requests.UploadRequest;
import africa.semicolon.gemstube.dtos.responses.UploadResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class MediaServiceTest {
    @Autowired
    private MediaService mediaService;
    @Autowired
    private UserService userService;

    public static final String IMAGE_LOCATION ="C:\\Users\\mr Adio\\IdeaProjects\\gemstube\\src\\main\\resources\\assets\\codeBase.jpg";

    @Test
    public void uploadMediaTest() throws GemsTubeException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@email.com");
        registerRequest.setPassword("12345678");
        var registerResponse = userService.register(registerRequest);
        UploadRequest request = new UploadRequest();
        request.setCreatorId(1L);
        request.setTitle("The media test");
        request.setDescription("test to upload media");
        request.setMultipartFile(getTestFile(IMAGE_LOCATION));
        UploadResponse response = mediaService.upload(request);
        assertThat(response).isNotNull();
    }


    public static MultipartFile getTestFile(String file_location) {
        Path path = Paths.get(file_location);
        try (var inputStream = Files.newInputStream(path);) {
            MultipartFile multiPartFile = new MockMultipartFile("test-image", inputStream);
            return multiPartFile;

        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }
}
