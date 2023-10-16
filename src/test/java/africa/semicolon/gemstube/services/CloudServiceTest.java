package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.exceptions.MediaCloudException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CloudServiceTest {
    @Autowired
    private CloudService cloudService;

    @Test
    public void uploadTest() throws MediaCloudException {
        String response = cloudService.upload(getTestFile());
            assertNotNull(response);


    }
    public static MultipartFile getTestFile() {
        Path path = Paths.get("C:\\Users\\mr Adio\\IdeaProjects\\gemstube\\src\\main\\resources\\assets\\codeBase.jpg");
        try (var inputStream = Files.newInputStream(path);) {
            MultipartFile multiPartFile = new MockMultipartFile("test-image", inputStream);
            return multiPartFile;

        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }
}