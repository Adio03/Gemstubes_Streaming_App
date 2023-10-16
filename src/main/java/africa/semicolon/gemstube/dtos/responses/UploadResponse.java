package africa.semicolon.gemstube.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadResponse {
    private String message;
    private Long mediaId;

}
