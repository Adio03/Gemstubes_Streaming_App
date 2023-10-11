package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.requests.UploadRequest;
import africa.semicolon.gemstube.dtos.responses.UploadResponse;

public interface MediaService {
    UploadResponse upload(UploadRequest request);
}
