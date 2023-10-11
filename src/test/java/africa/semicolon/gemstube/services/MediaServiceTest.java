package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.UploadRequest;
import africa.semicolon.gemstube.dtos.responses.UploadResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;
import africa.semicolon.gemstube.exceptions.MediaCloudException;
import com.cloudinary.api.ApiResponse;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static africa.semicolon.gemstube.services.CloudServiceTest.getTestFile;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class MediaServiceTest {
    @Autowired
    private MediaService mediaService;

    @Test
    public void uploadMediaTest() throws GemsTubeException {
        UploadRequest request = new UploadRequest();
        request.setCreatorId(1L);
        request.setTitle("The media test");
        request.setMultipartFile(getTestFile());
        UploadResponse response = mediaService.upload(request);
        assertThat(response).isNotNull();
    }
}
