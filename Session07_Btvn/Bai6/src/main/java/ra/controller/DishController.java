package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.model.DailyDishDTO;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/daily")
public class DishController {

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Điểm tâm", "Bữa trưa", "Ăn vặt");
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("dailyDish", new DailyDishDTO());
        return "daily-special";
    }

    @PostMapping("/save")
    public String save(
            @ModelAttribute DailyDishDTO dto,
            @RequestParam("bannerFile") MultipartFile file,
            RedirectAttributes redirect
    ) {

        if (file.isEmpty()) {
            redirect.addFlashAttribute("error", "Chưa chọn ảnh");
            return "redirect:/daily/form";
        }

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + fileName));

            System.out.println("Đã nhận món: " + dto.getName() + " - Upload ảnh thành công");

            return "redirect:/daily/form";

        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Upload lỗi!");
            return "redirect:/daily/form";
        }
    }
}