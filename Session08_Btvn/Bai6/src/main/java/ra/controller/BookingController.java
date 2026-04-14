package ra.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.model.dto.BookingDto;

@Controller
public class BookingController {

    @GetMapping("/booking")
    public String showForm(Model model) {
        model.addAttribute("bookingDto", new BookingDto());
        return "booking-form";
    }

    @PostMapping("/booking")
    public String handleBooking(
            @Valid @ModelAttribute("bookingDto") BookingDto bookingDto,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "booking-form";
        }

        // Logic lưu vào Database...
        return "redirect:/booking/success";
    }
}