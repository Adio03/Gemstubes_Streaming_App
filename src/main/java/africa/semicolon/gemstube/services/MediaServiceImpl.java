package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.data.models.Media;
import africa.semicolon.gemstube.dtos.requests.UploadRequest;
import africa.semicolon.gemstube.dtos.responses.UploadResponse;
import africa.semicolon.gemstube.exceptions.MediaCloudException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor


public class MediaServiceImpl implements MediaService{
    private final CloudService cloudService;
    @Override
    public UploadResponse upload(UploadRequest request) throws MediaCloudException {
      String response =  cloudService.upload(request.getMultipartFile());
        Media media = new Media();
        return null;
    }
}
