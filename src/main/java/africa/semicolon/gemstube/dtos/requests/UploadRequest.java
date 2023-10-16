package africa.semicolon.gemstube.dtos.requests;

import africa.semicolon.gemstube.data.models.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadRequest {
    private Long creatorId;
    private MultipartFile multipartFile;
    private String title;

    private String description;
    private Type type;

}
