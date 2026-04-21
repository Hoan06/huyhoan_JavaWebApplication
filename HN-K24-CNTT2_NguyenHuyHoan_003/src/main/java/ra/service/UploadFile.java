package ra.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    String uploadToLocal(MultipartFile file);
}
