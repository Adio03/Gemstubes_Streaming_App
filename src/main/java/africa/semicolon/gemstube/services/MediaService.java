package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.UploadRequest;
import africa.semicolon.gemstube.dtos.responses.UploadResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;
import africa.semicolon.gemstube.exceptions.MediaCloudException;

public interface MediaService {
    UploadResponse upload(UploadRequest request) throws GemsTubeException;
}
