package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.data.models.Media;
import africa.semicolon.gemstube.data.models.User;
import africa.semicolon.gemstube.data.repositries.MediaRepository;
import africa.semicolon.gemstube.dtos.requests.UploadRequest;
import africa.semicolon.gemstube.dtos.responses.UploadResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;
import africa.semicolon.gemstube.exceptions.MediaCloudException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor

public class MediaServiceImpl implements MediaService{
    private final MediaRepository mediaRepository;
    private final CloudService cloudService;
    private final UserService userService;
    private


    @Override
    public UploadResponse upload(UploadRequest request) throws GemsTubeException {
        ModelMapper mapper = new ModelMapper();
        User user = userService.getUserById(request.getCreatorId());
        String fileUrl =  cloudService.upload(request.getMultipartFile());
        Media media = mapper.map(request)
        media.setDescription(request.getDescription());
        media.setUrl(fileUrl);
        media.setTitle(request.getTitle());
        media.setCreatedAt(LocalDateTime.now());
        media.setUploader(user );

       Media savedMedia = mediaRepository.save(media);
       UploadResponse response = new UploadResponse();
       response.setMessage("Media upload successful");
       response.setMediaId(savedMedia.getId());
       return  response;

    }
}
