package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.model.Food;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Controller
@RequestMapping("/food")
public class FoodController {

    private static List<Food> foodList = new ArrayList<>();

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("food", new Food());
        return "form";
    }

    @PostMapping("/add")
    public String addFood(
            @ModelAttribute Food food,
            @RequestParam("image") MultipartFile file,
            Model model
    ) {
        System.out.println("CALL API ADD FOOD");
        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ảnh!");
            return "form";
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null ||
                !(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg"))) {
            model.addAttribute("error", "Chỉ chấp nhận file ảnh (.jpg, .png, .jpeg)");
            return "error";
        }

        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá phải >= 0");
            return "form";
        }

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String newFileName = System.currentTimeMillis() + "_" + fileName;
            String filePath = uploadDir + newFileName;

            file.transferTo(new File(filePath));
            food.setImagePath(newFileName);

            int index = foodList.size();
            foodList.add(food);

            System.out.println("Mon vua them: " + food.getName());
            System.out.println("Tong so mon có trong danh sach: " + foodList.size());

            return "redirect:/food/detail?id=" + index;
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi upload file!");
            return "form";
        }

    }


    @GetMapping("/detail")
    public String showDetails(@RequestParam("id") int id, Model model){

        if (id < 0 || id >= foodList.size()) {
            model.addAttribute("error", "Không tìm thấy món!");
            return "error";
        }

        Food food = foodList.get(id);
        model.addAttribute("food", food);

        return "detail";
    }
}