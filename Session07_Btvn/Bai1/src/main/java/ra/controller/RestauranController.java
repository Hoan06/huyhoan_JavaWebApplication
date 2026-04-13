package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.model.RestaurantProfile;

@Controller
@RequestMapping("/merchant")
public class RestauranController {

    @PostMapping("/merchant/update-profile")
    public String updateProfile(RestaurantProfile profile) {
        System.out.println("Tên quán: " + profile.getName());
        // Gọi service lưu vào DB...
        return "success";
    }
}