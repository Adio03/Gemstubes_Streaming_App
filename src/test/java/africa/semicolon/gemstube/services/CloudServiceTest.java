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

import static africa.semicolon.gemstube.data.models.Type.IMAGE;
import static africa.semicolon.gemstube.data.models.Type.VIDEO;
import static africa.semicolon.gemstube.services.MediaServiceTest.getTestFile;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CloudServiceTest {
    @Autowired
    private CloudService cloudService;

    public static final String IMAGE_LOCATION ="C:\\Users\\mr Adio\\IdeaProjects\\gemstube\\src\\main\\resources\\assets\\codeBase.jpg";

    public static final String VIDEO_LOCATION ="C:\\Users\\mr Adio\\IdeaProjects\\gemstube\\src\\main\\resources\\assets\\You Could Not Live With Your Own Failure_ _ Avengers_ Endgame 4k.mp4";

    @Test
    public void uploadImageTest() throws MediaCloudException {
        String response = cloudService.upload(getTestFile(IMAGE_LOCATION));
            assertNotNull(response);


    }

    @Test
    public void uploadVideoTest() throws MediaCloudException {
        String response = cloudService.upload(getTestFile(VIDEO_LOCATION));
        assertNotNull(response);
    }



}