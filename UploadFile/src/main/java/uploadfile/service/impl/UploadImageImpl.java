package uploadfile.service.impl;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uploadfile.service.UploadImage;

import java.io.File;
import java.io.IOException;

@Service
public class UploadImageImpl implements UploadImage {
    private ServletContext servletContext;

    public UploadImageImpl(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    private String destPath = "";

    @Override
    public String uploadToLocal(MultipartFile file) {

        if (file != null && !file.isEmpty()) {
            // Xủ lí upload ảnh
            String realPath = servletContext.getRealPath("/resources/images");

            File f = new File(realPath);
            if (!f.exists()) {
                f.mkdirs(); // Nếu không tồn tại thì tạo ra thư mục images trong resources
            }

            destPath = f.getAbsolutePath() +  "/" + file.getOriginalFilename(); // Lấy về đường dẫn gốc ổ đĩa

            try {
                file.transferTo(new File(destPath));
                return file.getOriginalFilename();
            } catch (IOException e) {
                System.out.println("Load fail !" + e.getMessage());
            }
        }


        return "";
    }
}
