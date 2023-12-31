package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.exceptions.MediaCloudException;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Service
@Slf4j
@AllArgsConstructor
public class CloudServiceImpl implements CloudService{

    private Cloudinary cloudinary;
    @Override
    public String upload(MultipartFile multipartFile) throws MediaCloudException {
        try{
            Map<?,?> uploadResponse = cloudinary.uploader().upload(multipartFile.getBytes(),ObjectUtils.asMap(
                    "resource_type","auto"

            ));
            log.info("upload response ->{}", uploadResponse);
            String url = (String) uploadResponse.get("secure_url");
            return url;
        }catch (IOException exception){
            throw new MediaCloudException(exception.getMessage());
        }

    }


}
