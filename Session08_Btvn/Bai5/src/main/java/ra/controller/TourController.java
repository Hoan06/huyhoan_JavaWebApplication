package ra.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.model.dto.TourDto;

@Controller
@RequestMapping("/tour")
public class TourController {

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("tourDto", new TourDto());
        return "create-tour";
    }

    @PostMapping("/save")
    public String saveTour(@Valid @ModelAttribute("tourDto") TourDto tourDto,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "create-tour";
        }
        return "redirect:/tour/success";
    }
}
