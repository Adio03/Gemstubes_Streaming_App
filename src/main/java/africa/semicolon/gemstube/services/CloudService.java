package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.exceptions.MediaCloudException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
    String upload(MultipartFile multipartFile) throws MediaCloudException;
}
