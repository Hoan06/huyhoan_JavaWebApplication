package uploadfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

    private final String uploadDir = System.getProperty("user.dir") + "/uploads";

    @GetMapping("")
    public String form() {
        return "upload";
    }

    @PostMapping("")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            return "upload";
        }

        try {
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            File destination = new File(uploadDir + "/" + fileName);
            file.transferTo(destination);

            model.addAttribute("fileName", fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "view-upload";
    }
}