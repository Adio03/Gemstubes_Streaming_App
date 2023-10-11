package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.UploadRequest;
import africa.semicolon.gemstube.dtos.responses.UploadResponse;
import com.cloudinary.api.ApiResponse;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class MediaServiceTest {
    @Autowired
    private MediaService mediaService;

    @Test
    public void uploadMediaTest(){
        UploadRequest request = new UploadRequest();
        UploadResponse response = mediaService.upload(request);
        assertThat(response).isNotNull();
    }
}
