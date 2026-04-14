package uploadfile.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImage {
    public String uploadToLocal(MultipartFile file);
}
