package ra.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadImage {
    String uploadToLocal(MultipartFile file);
}
