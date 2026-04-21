package ra.service.impl;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.service.UploadFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UploadFileImpl implements UploadFile {

    private final ServletContext servletContext;

    @Autowired
    public UploadFileImpl(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    String destPath = "";

    @Override
    public String uploadToLocal(MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String realPath = System.getProperty("user.dir") + "/src/main/resources/static/images/";

            File f = new File(realPath);
            if (!f.exists()) {
                f.mkdirs();
            }
            destPath = f.getAbsolutePath() +  "/" + file.getOriginalFilename();
            try {
                file.transferTo(new File(destPath));
                return file.getOriginalFilename();
            } catch (IOException e) {
                System.out.println("Load Fail !" + e.getMessage());
            }
        }
        return "";
    }
}