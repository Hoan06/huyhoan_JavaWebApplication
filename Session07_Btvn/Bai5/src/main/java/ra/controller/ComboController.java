package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.model.Combo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/combo")
public class ComboController {

    private static List<Combo> comboList = new ArrayList<>();

    @ModelAttribute("foods")
    public List<String> getFoods() {
        return Arrays.asList("Gà rán", "Pizza", "Trà sữa", "Khoai tây", "Burger");
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("combo", new Combo());
        return "combo-form";
    }

    @PostMapping("/add")
    public String addCombo(
            @ModelAttribute Combo combo,
            @RequestParam("banner") MultipartFile file,
            Model model
    ) {

        if (combo.getItemList() == null || combo.getItemList().size() < 2) {
            model.addAttribute("error", "Phải chọn ít nhất 2 món!");
            return "combo-form";
        }

        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn banner!");
            return "combo-form";
        }

        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + fileName));

            combo.setBannerPath(fileName);

            comboList.add(combo);


            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(combo);
            System.out.println("Combo vừa thêm: " + json);

            return "redirect:/combo/add";

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi load ảnh");
            return "combo-form";
        }
    }

}